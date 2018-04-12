package com.xiaobin.servletConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: xiaobin3
 *
 * @author : xiaob
 * Email: xiaobin3@asiainfo.com
 * Date: 2018/4/2
 * Time: 22:17
 * To change this template use File | Settings | File Templates.
 */
public class ServletContextDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String enCode = this.getServletContext().getInitParameter("enCode");
        System.out.println("取出的配置文件中的全局配置为："+enCode);
        getResources();
        String out = String.valueOf(this.getServletContext().getAttribute("servletDemo2HTTPServlet"));
        System.out.println("我在ServletContextDemo中取出ServletConfigDemo塞的值：" + out);
    }

    private void getResources() throws IOException {
        //获取资源路径
        String path1 = this.getServletContext().getRealPath("/WEB-INF/a.properties");
        System.out.println(path1);
        String path2 = this.getServletContext().getRealPath("/META-INF/application.xml");
        System.out.println(path2);
        String path3 = this.getServletContext().getRealPath("/home.jsp");
        System.out.println(path3);

        Properties properties = new Properties();
        properties.load(new FileInputStream(path1));
        //取出文件内容，map形式 key=I am a.properties
        System.out.println(properties.get("key"));
    }
}
