package com.xiaobin.web.filter;

import com.xiaobin.domain.User;
import com.xiaobin.service.UserService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: xiaobin3
 * @Description:
 * @Date: Created in 14:18 2018/4/19
 * @Modified by:
 */
public class AutoLoginFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        //获得cookie中用户名和密码 进行登录的操作
        //定义cookie_username
        String cookie_username = null;
        //定义cookie_password
        String cookie_password = null;
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
            if(cookie.getName().equals(cookie_username)){
                cookie_username = cookie.getValue();
            }
            if(cookie.getName().equals(cookie_password)){
                cookie_password = cookie.getValue();
            }
        }
        User user = null;
        if(cookie_username!=null && cookie_password!=null){
            UserService userService = new UserService();
            user = userService.login(cookie_username,cookie_password);
        }

        session.setAttribute("user",user);
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
