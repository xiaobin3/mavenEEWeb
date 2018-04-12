package com.xiaobin.httpServletResponse.header;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//设置定时刷新的头 如下servlet1重定向到servlet2，servlet2中定时刷新servlet1，就形成了循环刷新
//		response.setHeader("refresh", "5;url=http://localhost:8080/servlet1");
		response.getWriter().write("hello haohao...我是servlet1通过调用response.sendRedirect(\"/servlet2\")过来的！");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}