package com.xiaobin.servletConfig;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: xiaobin3
 *
 * @author : xiaob
 * Email: xiaobin3@asiainfo.com
 * Date: 2018/4/2
 * Time: 23:13
 * To change this template use File | Settings | File Templates.
 */
public class ServletRequestDispatcher extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = this.getServletContext();
//        RequestDispatcher rd = servletContext.getRequestDispatcher("/servletContext");
//        rd.forward(request,response);
        //将请求详细传递
        servletContext.getRequestDispatcher("/servletConfig").forward(request,response);
        System.out.println("事办完了！");
    }
}
