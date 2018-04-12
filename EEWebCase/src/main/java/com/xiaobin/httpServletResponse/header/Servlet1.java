package com.xiaobin.httpServletResponse.header;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//没有响应 告知客户端去重定向到servlet2
		//1、设置状态码302
		//response.setStatus(302);
		//2、设置响应头Location
		//response.setHeader("Location", "/WEB14/servlet2");
		
		//封装成一个重定向的方法sendRedirect(url)
		// [①地址栏会刷新城重定向之后的URL ②send后面的语句会继续执行，除非return]
		response.sendRedirect("/servlet2");
		System.out.println("①地址栏会刷新城重定向之后的URL ②send后面的语句会继续执行，除非return");
//		[①地址栏的URL不会变化 ②且可以将该页面的内容传递给重定向之后的页面 ③速度较快 ④Forward后面的语句不会继续发送给客户端]
//		this.getServletContext().getRequestDispatcher("/servlet2").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}