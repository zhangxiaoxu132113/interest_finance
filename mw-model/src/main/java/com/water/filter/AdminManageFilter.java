package com.water.filter;

import com.water.tools.web.MWSessionUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/6.
 * 后台管理系统过滤
 */
public class AdminManageFilter implements Filter {

    List<String> urls = new ArrayList<String>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        urls.add("/admin/login.action");
        urls.add("/admin/login");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 获得用户请求的URI
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        // 获得用户请求的URI
        String path = request.getRequestURI();
        System.out.println("[访问的url地址为] : " + path);

        //对要放行的页面进行判断
        for (int i=0; i < urls.size(); i++) {
            if (path.endsWith(urls.get(i))) {
                filterChain.doFilter(request,response);
                return;
            }
        }

        //判断管理员是否登录过
        Map<String,Object> empinfo = MWSessionUtils.getEmpInfoBySession(request);
        if (empinfo != null) {
            filterChain.doFilter(request,response);
            return;
        }

        //判断没有登录过，跳转到登录界面
        response.sendRedirect("/admin/login.action");
        return;
    }

    @Override
    public void destroy() {

    }
}
