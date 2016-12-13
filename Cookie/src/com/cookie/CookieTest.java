package com.cookie;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieTest extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		String name = req.getParameter("username");//得到表单中提交的用户名
		Cookie cookie = new Cookie("username",name);//建立一个cookie来存放用户名
		cookie.setMaxAge(30*60);//cookie在客户端存活时间30分钟
		res.addCookie(cookie);//将此cookie增加为“Set-Cookie”响应首部
		RequestDispatcher view = req.getRequestDispatcher("cookieresult.jsp");//让jsp建立响应首部
		view.forward(req, res);
	}
	
}
