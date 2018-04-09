package com.xiaobin.httpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: xiaobin3
 *
 * @author : xiaob
 * Email: xiaobin3@asiainfo.com
 * Date: 2018/4/9
 * Time: 20:09
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "ServletRespDemo1")
public class ServletRespDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //服务器中默认的编码格式是 ISO-8859-1,不支持中文
////        高速服务器使用的编码格式
//        response.setCharacterEncoding("UTF-8");
////        告诉客户端使用的编码
//        response.setHeader("content-type","text/html;charset=UTF-8");
//        等于上面的2行代码的功能
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();//得到一个字符输出流
        printWriter.write("你好！我是一个字符输出流！");//向客户端响应文本内容
    }
}
