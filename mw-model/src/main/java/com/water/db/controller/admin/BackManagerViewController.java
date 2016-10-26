package com.water.db.controller.admin;

import com.water.db.service.IUserService;
import com.water.tools.web.MWSessionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/22.
 * 后台管理控制器类-视图跳转
 */
@Controller
@RequestMapping(value = "/admin")
public class BackManagerViewController {

    @Resource(name = IUserService.SERVICE_NAME)
    private IUserService userService;

    /**
     * @author      Zhang Miaojie
     * @description 跳转到后台管理系统的首页面
     * @time        2016-08-22
     * @return      /WEB-INF/page/admin/index.jsp
     */
    @RequestMapping(value = "/index")
    public String redirct2Home() {

        return "/admin/index";
    }

    /**
     * @author      Zhang Miaojie
     * @description 跳转到后台管理系统的登录界面
     * @time        2016-08-22
     * @return      /WEB-INF/page/admin/login.jsp
     */
    @RequestMapping(value = "/login.action")
    public String redirect2login() {
        System.out.println("in login!");
        return "/admin/login";
    }

    /**
     * @author      Zhang Miaojie
     * @description 登录，授权
     * @time        2016-08-22
     * @return      /WEB-INF/page/admin/index.jsp
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Map<String,Object> empInfo = userService.findEmpInfoByUserNameAndPwd(username,password);
        //如果empInfo等于空，则重定向到登录界面
        if (empInfo == null) {
            response.sendRedirect("/admin/login.action");
            return;
        }

        //添加到session中
        MWSessionUtils.addEmpInfo2Session(request,empInfo);
        response.sendRedirect("/admin/index");
        return;
    }

    @RequestMapping(value = "/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //清空session中empinfo信息对象
        MWSessionUtils.removeEmpInfo2Session(request);
        response.sendRedirect("/admin/login.action");
    }

}
