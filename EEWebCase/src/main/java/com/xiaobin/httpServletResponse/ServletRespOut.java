package com.xiaobin.httpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: xiaobin3
 *
 * @author : xiaob
 * Email: xiaobin3@asiainfo.com
 * Date: 2018/4/9
 * Time: 20:39
 * To change this template use File | Settings | File Templates.
 */
public class ServletRespOut extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        C:\Files\IDEA_projects\mavenEEWeb\EEWebCase\target\EEWebCase\WEB-INF\美女.jpg
        //通过路径得到一个输入流
        String path = this.getServletContext().getRealPath("/WEB-INF/美女.jpg");
        FileInputStream fis = new FileInputStream(path);
        //创建字节输出流
        ServletOutputStream sos = response.getOutputStream();

        //得到要下载的文件名
        String filename = path.substring(path.lastIndexOf("\\")+1);

        //设置文件名的编码
        filename = URLEncoder.encode(filename, "UTF-8");//将不安全的文件名改为UTF-8格式

        //告知客户端要下载文件
        response.setHeader("content-disposition", "attachment;filename="+filename);
        response.setHeader("content-type", "image/jpeg");

        //执行输出操作
        int len = 1;
        byte[] b = new byte[1024];
        while((len=fis.read(b))!=-1){
            sos.write(b,0,len);
        }

        sos.close();
        fis.close();

//------------
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write("你好！我是一个字符输出流！".getBytes());
    }
}
