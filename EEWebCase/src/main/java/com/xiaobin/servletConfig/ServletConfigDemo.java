package com.xiaobin.servletConfig;

import javax.servlet.ServletConfig;
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
 * @author : xiaob
 * Email: xiaobin3@asiainfo.com
 * Date: 2018/4/2
 * Time: 21:44
 * To change this template use File | Settings | File Templates.
 */
public class ServletConfigDemo extends HttpServlet {

    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("开始办事！");
        String enCode = config.getInitParameter("encode");
        System.out.println("配置的编码格式为：" + enCode);
        /*// （1）要执行super.init(config);

// （2）可是我在init方法里面 执行ServletContext sc = getServletContext();    始终不可以

// 找了很久  终于找到问题

//  init 方法是不能用getServletContext(); 也就是父类里面

//   要使用config对象获得

ServletContext sc = config.getServletContext();

init 方法里面用 super.getServletContext() 是错误的

}*/
        ServletContext servletContext = config.getServletContext();
        servletContext.setAttribute("servletDemo2HTTPServlet","servletDemo2HTTPServlet");
        String out = String.valueOf(servletContext.getAttribute("servletDemo2HTTPServlet"));
        System.out.println("我塞了值：" + out);
        System.out.println("取出类是:"+servletContext.getClass().getName());
        System.out.println("转给下一个部门！");
        servletContext.getRequestDispatcher("/servletContext").forward(request,response);

    }
}
