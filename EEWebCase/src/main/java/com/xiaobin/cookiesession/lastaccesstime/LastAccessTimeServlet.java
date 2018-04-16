package com.xiaobin.cookiesession.lastaccesstime;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LastAccessTimeServlet extends HttpServlet {
	private static final String LAST_ACCESS_TIME = "lastAccessTime";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		lastAccessTime(request, response);
		Date accessDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd|HH:mm:ss");
		String currentTime = format.format(accessDate);

		Cookie cookie = new Cookie(LAST_ACCESS_TIME,currentTime);
		cookie.setMaxAge(60*10*100);
		response.addCookie(cookie);

		String lastAccessTime = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie coo:cookies) {
                if (LAST_ACCESS_TIME.equals(coo.getName())){
                    lastAccessTime = coo.getValue();
                }
            }
		}

		HttpSession session = request.getSession();
//		Object name = session.getAttribute("name");
		session.setAttribute("name", "jerry");

		String id = session.getId();//该session对象的编号id
		response.setContentType("text/html;charset=UTF-8");
		if (StringUtils.isBlank(lastAccessTime)){
			response.getWriter().write("您是第一次访问"+id);
		}else{
			response.getWriter().write("您上次的访问的时间是："+lastAccessTime+"&&&&&&&&&&&"+id);
		}

	}

	private void lastAccessTime(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//当前登陆时间转换，不能有空格
		Date accessDate = new Date();
		SimpleDateFormat formateDate = new SimpleDateFormat("yyyy年mm月dd日hh:mm:ss");
		String currentAccessTime = formateDate.format(accessDate);

		//将转换后的时间参数放到新的cookie里面,送给页面
		Cookie cookie = new Cookie(LAST_ACCESS_TIME,currentAccessTime);
		cookie.setMaxAge(60*10*100);
		response.addCookie(cookie);

		//获取客户端请求里面的cookie
		String lastAccessTime = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookieEach : cookies) {
                if (LAST_ACCESS_TIME.equals(cookieEach.getName())){
                	lastAccessTime = cookieEach.getValue();
				}
            }
		}

		response.setContentType("text/html;charset=UTF-8");
		if (StringUtils.isBlank(lastAccessTime)){
			response.getWriter().write("您是第一次访问");
		}else{
			response.getWriter().write("您上次的访问的时间是："+lastAccessTime);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}