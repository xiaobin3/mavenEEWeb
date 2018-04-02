package com.xiaobin.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: xiaobin3
 *
 * @author : ${user}
 * Email: xiaobin3@asiainfo.com
 * Date: 2018/4/1
 * Time: 13:10
 * To change this template use File | Settings | File Templates.
 */
public class servletDemo1 implements Servlet{

    public servletDemo1(){
        System.out.println("实例化！");
    }

    public void init(ServletConfig servletConfig) throws ServletException {

        System.out.println("初始化成功！");
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello,servlet!调用服务成功！");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {
        System.out.println("销毁！");
    }
}
