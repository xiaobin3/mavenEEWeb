package com.xiaobin.httpServletResponse.demo;

import com.xiaobin.httpServletResponse.utils.FileUtil;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class DemoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //读TXT
//        readTxtFile(response);
        //读图片文件（文件名没有中文）
//        readPicFile(response);
        readFileWithCHNName(request,response);
    }

    private void readFileWithCHNName(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("content-type", "image/jpeg");
        String path = this.getServletContext().getRealPath("/WEB-INF/86户型.jpg");
        String filename = path.substring(path.lastIndexOf("\\")+1);
        //设置文件名的编码
        //获得请求头中的User-Agent
        String agent = request.getHeader("User-Agent");
        //根据不同浏览器进行不同的编码
        String filenameEncoder = FileUtil.fileNameEncoderUtil(agent,filename);
        System.out.println(filename);
        response.setHeader("content-disposition", "attachment;filename="+filenameEncoder);
        FileInputStream inputStream = new FileInputStream(path);
        ServletOutputStream outputStream = response.getOutputStream();
        int len;
        byte[] b = new byte[1024];
        while ((len = inputStream.read(b)) != -1){
            outputStream.write(b,0,len);
        }
        inputStream.close();
        outputStream.close();
    }

    private void readPicFile(HttpServletResponse response) throws IOException {
        response.setHeader("content-type", "image/jpeg");
        String path = this.getServletContext().getRealPath("/WEB-INF/86.jpg");
        FileInputStream inputStream = new FileInputStream(path);
        ServletOutputStream outputStream = response.getOutputStream();
        int len;
        byte[] b = new byte[1024];
        while ((len = inputStream.read(b)) != -1){
            outputStream.write(b,0,len);
        }
        inputStream.close();
        outputStream.close();
    }

    private void readTxtFile(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<String> words = new ArrayList<>();
        try {
            BufferedReader buff = new BufferedReader(new InputStreamReader(this.getServletContext().getResourceAsStream("/WEB-INF/new_words.txt"),"utf-8"));
            String word = null;
            while ((word = buff.readLine())!=null){
                words.add(word);
            }
            buff.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        PrintWriter writer = response.getWriter();
        writer.write(words.toString());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
