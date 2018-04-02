package com.xiaobin.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: xiaobin3
 *
 * @author : ${user}
 * Email: xiaobin3@asiainfo.com
 * Date: 2018/4/1
 * Time: 22:56
 * To change this template use File | Settings | File Templates.
 */
public class servletDemo2HTTPServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        int num = 1;
        System.out.println("doGet来啦！");
        System.out.println(req.getRemoteAddr());
        System.out.println(req.getCookies());
        num++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(num);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        doGet(req,resp);
        System.out.println("doPost来啦！");
    }
}
