package com.water.tools.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by mrwater on 16/6/4.
 */
public class MWSessionUtils {

    public static String GLOBAL_USER = "global_user";

    public static String GLOBAL_EMPINFO = "global_empinfo";

    private MWSessionUtils (){}

    /**
     * @description 添加用户对象到session中
     * @param request
     * @param user
     * @time 2016-06-04
     */
    public static void addUser2Session(HttpServletRequest request, Map<String,Object> user) {

        HttpSession session = request.getSession();
        session.setAttribute(GLOBAL_USER,user);
    }

    /**
     * @description 添加后台操作人员对象到session中
     * @param request
     * @param empInfo
     * @time 2016-09-06
     */
    public static void addEmpInfo2Session(HttpServletRequest request, Map<String,Object> empInfo) {

        HttpSession session = request.getSession();
        session.setAttribute(GLOBAL_EMPINFO,empInfo);
    }

    /**
     * @description 从session中移除对象
     * @time 2016-08-19
     */
    public static void removeUser2Session(HttpServletRequest request) {

        request.getSession().removeAttribute(GLOBAL_USER);
        System.out.println("清空了session用户对象");
    }

    /**
     * @description 从session中移除后台管理员对象
     * @time 2016-09-06
     */
    public static void removeEmpInfo2Session(HttpServletRequest request) {

        request.getSession().removeAttribute(GLOBAL_EMPINFO);
        System.out.println("清空了session后台管理员对象");
    }

    /**
     * @description 从session中获取对象
     * @time 2016-08-19
     */
    public static Map<String,Object> getUserBySession(HttpServletRequest request) {

        return (Map<String,Object>)request.getSession().getAttribute(GLOBAL_USER);
    }

    /**
     * @description 从session中获取后台管理员对象
     * @time 2016-09-06
     */
    public static Map<String,Object> getEmpInfoBySession(HttpServletRequest request) {

        return (Map<String,Object>)request.getSession().getAttribute(GLOBAL_EMPINFO);
    }

}
