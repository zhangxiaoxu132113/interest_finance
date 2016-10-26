package com.water.db.controller;

import com.water.db.service.IMessageService;
import com.water.db.service.ISystemDDLService;
import com.water.db.service.IUserService;
import com.water.tools.lang.GlobalUtil;
import com.water.tools.web.MWSessionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zhang Miaojie on 16/8/9.
 * 用户控制器类
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Resource(name = GlobalUtil.USER_SERVICE)
    private IUserService userService;

    @Resource(name = GlobalUtil.MESSAGE_SERVICE)
    private IMessageService messageService;

    @Resource(name = GlobalUtil.SYSTEMDDL_SERVICE)
    private ISystemDDLService systemDDLService;

    /**
     * @author      Meng Sheng
     * @description 跳转到用户登录界面
     * @time        2016-09-08
     * @return      /WEB-INF/page/common/userLogin.jsp
     */
    @RequestMapping(value = "/login.html")
    public String redirect2userLogin(){
        System.out.println("in userLogin..............");
        return "/common/userLogin";
    }

    /**
     * @author      Meng Sheng
     * @description 跳转到用户注册界面
     * @time        2016-09-08
     * @return      /WEB-INF/page/common/userRegister.jsp
     */
    @RequestMapping(value = "/register.html")
    public String redirect2userRegister(){
        System.out.println("in userRegister..............");
        return "/common/userRegister";
    }

    /**
     * @author      Meng Sheng
     * @description 跳转到找回密码界面
     * @time        2016-09-08
     * @return      /WEB-INF/page/common/registerPwd.jsp
     */
    @RequestMapping(value = "/forgotPass.html")
    public String redirect2userRegisterPwd(){
        System.out.println("in userRegisterPwd..............");
        return "/common/userRetrievePwd";
    }


    /**
     * @author      Zhang Miaojie
     * @description 跳转到用户模块【账户总揽页面】
     * @time        2016-08-09
     * @return      /WEB-INF/page/user/personHome.jsp
     */
    @RequestMapping(value = "/accountInfo/{userId}", method = RequestMethod.GET)
    public String redirect2accountInfo() {

        System.out.println("in redirect2accountInfo");
        return "/user/personHome";
    }

    /**
     * @author      Zhang Miaojie
     * @description 用户退出
     * @time        2016-08-15
     * @return      /WEB-INF/page/index.jsp
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {

        MWSessionUtils.removeUser2Session(request);
        return "redirect:/";
        //return "/index";这样跳转，只是跳转页面，不会跳转URL地址，所以要重定向跳转
    }

    /**
     * @author      Meng Sheng
     * @description 根据用户的ID查询用户
     * @time        2016-08-25
     */
    @RequestMapping(value="/getUserByUid", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map<String,Object> getUserByUid(HttpServletRequest request){
        Map<String,Object> resultJson = new HashMap<>();
        int userId=Integer.parseInt(request.getParameter("userId"));
        resultJson = userService.findUserByUserId(userId);
        return resultJson;
    }


}
