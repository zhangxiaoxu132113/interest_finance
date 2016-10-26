package com.water.db.controller.restful;

import com.water.db.entry.EmpInfo;
import com.water.db.entry.User2BidInfo;
import com.water.db.service.*;
import com.water.tools.lang.GlobalUtil;
import com.water.tools.lang.MWStringUtils;
import com.water.tools.security.MD5Util;
import com.water.tools.web.MWSessionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by Administrator on 2016/8/16.
 */
@RestController
@RequestMapping(value = "/user")
public class UserRestfulController {

    private static int LOGIN_STATUS_TELPHONE_NOTFOUND = 0;      //手机号码没有找到

    private static int LOGIN_STATUS_PASSWORD_INCORRECT = 1;     //用户密码输入不正确

    private static int LOGIN_STATUS_SUCCESS = 2;                //登录成功

    @Resource(name = IUserService.SERVICE_NAME)
    private IUserService userService;

    @Resource(name = IMessageService.SERVICE_NAME)
    private IMessageService messageService;

    @Resource(name = ISystemDDLService.SERVICE_NAME)
    private ISystemDDLService systemDDLService;

    @Resource(name = IInviteService.SERVICE_NAME)
    private IInviteService inviteService;

    @Resource(name = GlobalUtil.INTEGRAL_SERVICE)
    private IIntegralService integralService;

    @Resource(name = IBankService.SERVICE_NAME)
    private IBankService bankService;

    /**
     * @author      Zhang Miaojie
     * @description 用户登录
     * @time        2016-08-15
     * @return      /WEB-INF/page/index.jsp
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    public Map<String,Object> login(HttpServletRequest request) {

        Map<String, Object> loginJson = new HashMap<String, Object>();
        String login_name = request.getParameter("login_name");
        String login_pwd = request.getParameter("login_pwd");
        String login_pwd_md5 = MD5Util.GetMD5Code(login_pwd);

        //查询账号是否存在
        Map<String,Object> telUserMap = userService.findUserByTel(login_name);
        if (telUserMap == null) {
            loginJson.put("login-status",LOGIN_STATUS_TELPHONE_NOTFOUND);
            return loginJson;
        }

        Map<String,Object> userMap = userService.findUserByNameAndPwd(login_name,login_pwd_md5);
        //用户不存在，账户密码不正确
        if (userMap == null) {
            loginJson.put("login-status",LOGIN_STATUS_PASSWORD_INCORRECT);
            return loginJson;
        }
        //登录成功
        MWSessionUtils.addUser2Session(request,userMap);
        userService.recordLoginLog((Integer) userMap.get("USERID"));
        loginJson.put("login-status",LOGIN_STATUS_SUCCESS);
        return loginJson;
    }

    /**
     * @author      Zhang Miaojie
     * @description 用户注册
     * @time        2016-08-15
     * @return      /WEB-INF/page/index.jsp
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String,Object> register(HttpServletRequest request) {

        Map<String, Object> resultJson = new HashMap<String, Object>();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String pwdByMD5 = MD5Util.GetMD5Code(password);
        String redirect_after_login = request.getParameter("redirect_after_login");

        //判断验证码是否正确
        String tel_phone = username;
        String verification_code = request.getParameter("verification_code");
        boolean code_flag = messageService.checkVericationCode(tel_phone,verification_code);
        if (!code_flag) {
            resultJson.put("register_status",1);//验证码验证失败
            return resultJson;
        }

        Timestamp createTime = new Timestamp(new Date().getTime());

        //保存注册用户到数据库
        Map<String, Object> userMap = new HashMap<String, Object>();
        userMap.put("USERNAME",username);
        userMap.put("PASSWORD",pwdByMD5);
        userMap.put("CREATETIME",createTime);
        boolean reg_flag = userService.saveUser(userMap);

        //注册失败
        if (!reg_flag) {
            resultJson.put("register_status",2);
            return resultJson;
        }

        //TODO 页面跳转-暂不实现
//        if (redirect_after_login!=null && !redirect_after_login.equals("")) {
//
//        }

        //获取注册用户
        Map<String, Object> reg_userMap = userService.findUserByNameAndPwd(username,pwdByMD5);
        //用户邀请码(IDX_用户的ID)
        String inviteCode_init = "IDX_" + reg_userMap.get("USERID");
        System.out.println("用户邀请码："+inviteCode_init);
        //给注册用户初始化唯一邀请码
        boolean flag_invite = userService.updateUserInviteCodeByUid(inviteCode_init,(Integer)reg_userMap.get("USERID"));

        /**给注册用户加积分*/
        int score = 20;//注册用户加的积分
        int score_type = 1;//【0】表示支出积分，【1】表示收入积分
        String source = "用户注册";//积分来源
        int available_integral = score ;//可用积分
        int total_integral = score ;//总积分
        integralService.saveIntegral((Integer)reg_userMap.get("USERID"),score,score_type,source,available_integral,total_integral,createTime);

        //判断是否使用邀请码
        String invite_code = request.getParameter("invite_code");//用户邀请码
        if (!invite_code.equals("null")){
            int inviteWay = 1;//邀请方式为：1，复制链接方式

            //获取发出邀请的人
            Map<String, Object> send_invite_userMap = inviteService.findUserByInviteCode(invite_code);
            if (send_invite_userMap != null){
                //注册用户为邀请注册方式，添加邀请关系表
                Timestamp createDon = new Timestamp(new Date().getTime());
                inviteService.saveInvitation((Integer)send_invite_userMap.get("USERID"),(Integer)reg_userMap.get("USERID"),inviteWay,createDon);
            }
        }

        //保存用户到session
        MWSessionUtils.addUser2Session(request,reg_userMap);

        resultJson.put("register_status",0);
        return resultJson;

    }

    /**
     * @author      Zhang Miaojie
     * @description 找回密码
     * @time        2016-08-17
     * @return      /WEB-INF/page/index.jsp
     */
    @RequestMapping(value = "/recoverPwd", method = RequestMethod.POST, produces = "application/json")
    public Map<String,Object> recoverPassword(HttpServletRequest request){

        Map<String,Object> resultJson = new HashMap<String,Object>();

        String recover_tel_phone = request.getParameter("recover_tel_phone");
        String recover_code = request.getParameter("recover_code");
        String recover_pwd = request.getParameter("recover_pwd");
        String recover_pwd_md5 = MD5Util.GetMD5Code(recover_pwd);

        //判断验证码是否输入正确
        boolean flag = messageService.checkVericationCode(recover_tel_phone,recover_code);
        if (!flag) {
            //验证码输入错误
            resultJson.put("status",2);
            return resultJson;
        }
        //验证码输入正确，更新用户的密码
        userService.updatePwdByTelphone(recover_tel_phone,recover_pwd_md5);

        resultJson.put("status",0);
        return resultJson;
    }

    /**
     * @author      ZhangMiaojie
     * @descrition  获取user相关的数据字典
     * @time        2016/09/08
     */
    @RequestMapping(value = "/findUserSystemDDL", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map<String,Object> findUserSystemDDL() {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        List<Map<String,Object>> genderList =  systemDDLService.findGenderList();
        List<Map<String,Object>> departmentList = systemDDLService.findDepartmentList();
        List<Map<String,Object>> politics = systemDDLService.findPolitics();
        List<Map<String,Object>> marriages = systemDDLService.findMarriages();
        List<Map<String,Object>> jobName = systemDDLService.findJobName();

        resultJson.put("genderList",genderList);
        resultJson.put("departmentList",departmentList);
        resultJson.put("politics",politics);
        resultJson.put("marriages",marriages);
        resultJson.put("jobName",jobName);

        return resultJson;
    }

    /**
     * @author      ZhangMiaojie
     * @descrition  添加员工信息
     * @time        2016/09/08
     */
    @RequestMapping(value = "/addEmpInfo", method = RequestMethod.POST, produces = "application/json")
    public Map<String,Object> addEmpInfo(@RequestBody EmpInfo empInfo) {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        System.out.println("resultJson = "+resultJson);
        boolean flag = userService.addEmpInfo(empInfo);
        if (flag) {
            resultJson.put("status",0);
            return resultJson;
        }
        resultJson.put("status",1);
        return resultJson;
    }

    /**
     * @author      ZhangMiaojie
     * @descrition  获取员工列表信息
     * @time        2016/09/08
     */
    @RequestMapping(value = "/empinfo/list", method = RequestMethod.GET, produces = "application/json")
    public List<Map<String,Object>> findEmpInfoList() {

        List<Map<String,Object>> empInfoList = new ArrayList<Map<String,Object>>();
        empInfoList = userService.findEmpInfoList();

        return empInfoList;
    }

    /**
     * @author      ZhangMiaojie
     * @descrition  删除员工信息
     * @time        2016/09/09
     */
    @RequestMapping(value = "/empInfo/remove", method = RequestMethod.DELETE, produces = "application/json")
    public Map<String,Object> removeEmpInfo(HttpServletRequest request) {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        int itemId = Integer.parseInt(request.getParameter("itemId"));

        //调用删除员工信息的方法
        boolean flag = userService.deleteEmpInfoById(itemId);
        if (flag) {
            resultJson.put("status",0);
            return resultJson;
        }

        resultJson.put("status",1);
        return resultJson;
    }

    /**
     * @author      ZhangMiaojie
     * @descrition  添加权限角色
     * @time        2016/09/12
     */
    @RequestMapping(value = "/addPopem", method = RequestMethod.POST, produces = "application/json")
    public Map<String,Object> addPopem(HttpServletRequest request) throws Exception {

        request.setCharacterEncoding("GBK");
        Map<String,Object> resultJson = new HashMap<String,Object>();

        String role_name = MWStringUtils.getParameterByRequest(request,"role_name");
        String role_flag = MWStringUtils.getParameterByRequest(request,"role_flag");

        boolean flag = userService.addPopem(role_name,role_flag);
        if (flag) {
            resultJson.put("status",0);
            return resultJson;
        }

        resultJson.put("status",1);
        return resultJson;
    }

    /**
     * @author      ZhangMiaojie
     * @descrition  根据条件来查询用户的手机号码信息列表
     * @time        2016/09/19
     */
    @RequestMapping(value = "/queryTel", method = RequestMethod.GET, produces = "application/json")
    public List<Map<String,Object>> queryUserTelphonebyCondition(HttpServletRequest request) {

        List<Map<String,Object>> telPhoneList = new ArrayList<Map<String,Object>>();
        String telPhone = request.getParameter("user_tel");
        telPhoneList  =  userService.findTelphoneByCondition(telPhone);
        return telPhoneList;
    }

    /**
     * @author      ZhangMiaojie
     * @descrition  添加用户的投标信息
     * @time        2016/09/19
     */
    @RequestMapping(value = "/addRebate", method = RequestMethod.POST, produces = "application/json")
    public Map<String,Object> addRebate(@RequestBody User2BidInfo user2BidInfo) {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        boolean flag = userService.addRebate(user2BidInfo);
        if (flag) {
            resultJson.put("status",0);
            return resultJson;
        }

        resultJson.put("status",1);
        return resultJson;
    }


}















