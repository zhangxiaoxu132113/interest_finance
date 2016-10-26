package com.water.db.controller;

import com.water.db.entry.BankInfo;
import com.water.db.service.IBankService;
import com.water.db.service.IMessageService;
import com.water.db.service.ISafeService;
import com.water.db.service.IUserService;
import com.water.tools.security.MD5Util;
import com.water.tools.web.MWSessionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Meng Sheng on 2016/9/13.
 * 账户安全控制器
 */
@Controller
@RequestMapping(value = "/user/safe")
public class SafeController {

    private static int STATUS_YES = 0;      //成功
    private static int STATUS_NOT = 1;      //失败
    private static int STATUS_MSG_CODE_ERROR = 2;      //验证码错误
    private static int STATUS_TELPHONE_NOTFOUND = 3;    //手机号码不存在

    @Resource(name = ISafeService.SERVICE_NAME)
    private ISafeService safeService;

    @Resource(name = IBankService.SERVICE_NAME)
    private IBankService bankService;

    @Resource(name = IMessageService.SERVICE_NAME)
    private IMessageService messageService;

    @Resource(name = IUserService.SERVICE_NAME)
    private IUserService userService;

    /**
     * @author      MengSheng
     * @description 手机认证，更新手机号码
     * @time        2016-09-22
     * @return
     */
    @RequestMapping(value = "/saveRzTellPhone", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String,Object> updateRzTellPhoneByUid(HttpServletRequest request) {

        Map<String, Object> resultJson = new HashMap<String, Object>();
        String tel_phone = request.getParameter("tel_phone");
        int userId = Integer.parseInt(request.getParameter("userId"));

        //判断验证码是否正确
        String verification_code = request.getParameter("msg_code");
        boolean code_flag = messageService.checkVericationCode(tel_phone,verification_code);
        if (!code_flag) {
            resultJson.put("status",STATUS_MSG_CODE_ERROR);//验证码验证失败
            return resultJson;
        }

        boolean flag = safeService.updateRzTellPhoneByUid(tel_phone,userId);
        if (!flag) {
            resultJson.put("status", STATUS_NOT);//保存认证手机号码失败
            return resultJson;
        }
        //保存认证手机号码成功
        resultJson.put("status", STATUS_YES);
        //删除保存在数据库的手机验证码
        messageService.deleteCodeData(tel_phone);
        return resultJson;
    }

    /**
     * @author      MengSheng
     * @descrition  实名认证，插入真实姓名
     * @time        2016-09-22
     */
    @RequestMapping(value = "/saveRealName", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String,Object> updateRealNameByUid(HttpServletRequest request) {

        Map<String, Object> resultJson = new HashMap<String, Object>();
        String realname = request.getParameter("real_name");
        String user_cardID = request.getParameter("user_cardID");//身份证
        //TODO 调第三方接口进行姓名和身份证校验
        int userId = Integer.parseInt(request.getParameter("userId"));

        boolean flag = safeService.updateRealNameByUid(realname,userId);
        System.out.println("flag:"+flag);
        if (!flag) {
            resultJson.put("status", STATUS_NOT);//保存实名认证失败
            return resultJson;
        }
        //保存实名认证成功
        resultJson.put("status", STATUS_YES);
        return resultJson;
    }

    /**
     * @author      MengSheng
     * @description 修改登录密码
     * @time        2016-08-17
     * @return
     */
    @RequestMapping(value = "/modifyPass", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String,Object> modifyPass(HttpServletRequest request) {

        Map<String, Object> pwdJson = new HashMap<String, Object>();
        String pwd=request.getParameter("pwd");
        int userId=Integer.parseInt(request.getParameter("userId"));
        String pwd_md5 = MD5Util.GetMD5Code(pwd);
        boolean flag = safeService.updatePwdByUid(pwd_md5,userId);
        //登录密码修改失败
        if (!flag) {
            pwdJson.put("status", STATUS_NOT);
            return pwdJson;
        }
        //登录密码修改成功
        pwdJson.put("status", STATUS_YES);
        return pwdJson;
    }

    /**
     * @author      MengSheng
     * @description 修改支付密码
     * @time        2016-08-17
     * @return
     */
    @RequestMapping(value = "/modifyPayPass", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String,Object> modifyPayPass(HttpServletRequest request) {

        Map<String, Object> pwdJson = new HashMap<String, Object>();
        String payPwd=request.getParameter("pwd");
        int userId=Integer.parseInt(request.getParameter("userId"));
        String payPwd_md5 = MD5Util.GetMD5Code(payPwd);
        boolean flag = safeService.upadatePayPwdByUid(payPwd_md5,userId);
        //支付密码修改失败
        if (!flag) {
            pwdJson.put("status",STATUS_NOT);
            return pwdJson;
        }
        //支付密码修改成功
        pwdJson.put("status", STATUS_YES);
        return pwdJson;
    }

    /**
     * @author      MengSheng
     * @description 验证登录密码
     * @time        2016-08-17
     * @return
     */
    @RequestMapping(value = "/checkLoginPass", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String,Object> checkLoginPass(HttpServletRequest request) {

        Map<String, Object> pwdJson = new HashMap<String, Object>();
        String pwd=request.getParameter("pwd");
        int userId=Integer.parseInt(request.getParameter("userId"));
        String pwd_md5 = MD5Util.GetMD5Code(pwd);
        //原登录密码错误
        boolean flag = safeService.findPwdByUid(pwd_md5,userId);
        if (!flag) {
            pwdJson.put("status", STATUS_NOT);
            return pwdJson;
        }
        //原登录密码正确
        pwdJson.put("status", STATUS_YES);
        return pwdJson;
    }

    /**
     * @author      MengSheng
     * @description 验证支付密码
     * @time        2016-08-17
     * @return
     */
    @RequestMapping(value="/checkPayPass", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String,Object> checkPayPass(HttpServletRequest request){

        Map<String, Object> payPwdJson = new HashMap<String, Object>();
        String payPwd=request.getParameter("pwd");
        String payPwd_md5 = MD5Util.GetMD5Code(payPwd);
        int userId=Integer.parseInt(request.getParameter("userId"));
        //原支付密码错误
        boolean flag = safeService.findPayPwdByUid(payPwd_md5,userId);
        if (!flag) {
            payPwdJson.put("status",STATUS_NOT);
            return payPwdJson;
        }
        //原支付密码正确
        payPwdJson.put("status",STATUS_YES);
        return payPwdJson;
    }

    /**
     * @author      Zhang Miaojie
     * @description 绑定银行卡
     * @time        2016-08-19
     * @return      Map<String,Object>
     *     0 绑定成功
     *     1 绑定失败
     *     2 服务器异常
     */
    @RequestMapping(value = "/bindBankCard", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String,Object> bindBankCard(HttpServletRequest request) {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        String username = request.getParameter("username");
        String cardId = request.getParameter("cardId");
        String bankName = request.getParameter("bankName");
        String card_num = request.getParameter("card_num");
        Map<String,Object> userMap = MWSessionUtils.getUserBySession(request);
        int userId = (Integer) userMap.get("USERID");
        int bankCode = 1;//银行CODE值
        Timestamp createTime = new Timestamp(new Date().getTime());

        //TODO 调用第三方绑定银行卡接口，绑定银行卡

        BankInfo bankInfo = new BankInfo();
        bankInfo.setAccountName(username);
        bankInfo.setCardId(cardId);
        bankInfo.setBankCode(bankCode);
        bankInfo.setBankCardId(card_num);
        bankInfo.setUserId(userId);
        bankInfo.setBankBranch(bankName);
        bankInfo.setCreateTime(createTime);

        System.out.println("bankInfo :"+bankInfo);

        //判断验证码是否正确
        String tell_phone = request.getParameter("tell_phone");
        String msg_code = request.getParameter("msg_code");
        boolean code_flag = messageService.checkVericationCode(tell_phone,msg_code);
        if (!code_flag) {
            resultJson.put("status",STATUS_MSG_CODE_ERROR);//验证码验证码验证失败
            return resultJson;
        }
        boolean bind_flag = bankService.bindBankCard(bankInfo);
        if (bind_flag) {
            resultJson.put("status",STATUS_NOT);
            return resultJson;
        }
        resultJson.put("status",STATUS_YES);
        return resultJson;
    }

    /**
     * @author      MengSheng
     * @description 加载账户安全信息
     * @time        2016-09-19
     * @return
     */
    @RequestMapping(value = "/findUserInfo", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map<String,Object> findUserInformation(HttpServletRequest request){

        Map<String,Object> resultJson = new HashMap<String,Object>();
        int userId = Integer.parseInt(request.getParameter("userId"));
        //用户信息
        Map<String,Object> userJson = userService.findUserByUserId(userId);
        //用户登录时间
        Map<String,Object> userLogJson = userService.findUserLogByUid(userId);
        //绑定的银行卡信息
        List<Map<String,Object>> bankCardList = bankService.findBankCardByUid(userId);

        resultJson.put("userInfo",userJson);
        resultJson.put("userLog",userLogJson);
        resultJson.put("bankCardList", bankCardList);
        return resultJson;
    }

    /**
     * @author      Zhang Miaojie
     * @description 检验手机号码是否已注册
     * @time        2016-08-16
     * @return      已注册：0 未注册：1
     */
    @RequestMapping(value = "/checkTellExist", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String,Object> checkTellByTel(HttpServletRequest request){

        Map<String,Object> resultJson = new HashMap<String,Object>();
        String tel_phone = request.getParameter("tel_phone");
        //手机号码是否已经注册
        Map<String,Object> tellMap = messageService.findUserByTelPhone(tel_phone);
        if (tellMap == null) {
            //手机号码未被注册
            resultJson.put("status",STATUS_NOT);
            return resultJson;
        }
        //手机号码已经被注册
        resultJson.put("status",STATUS_YES);
        return resultJson;
    }


}
