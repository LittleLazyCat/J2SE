package com.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CheckCookie extends HttpServlet {
	
 
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		Cookie[] cookies = req.getCookies();//从请求中得到cookies
		if(cookies!=null)
		{
			int len = cookies.length;
			for(int i = 0;i<len;i++)//循环处理cookie数组
			{
				Cookie cookie = cookies[i];
				if("username".equals(cookie.getName()))//查找有个名为“username”的cookie
				{
					//如果有这样一个cookie，得到它的值，并打印输出
					String name = cookie.getValue();
					out.println("hello" + name);
					break;
				}
			}
		}
		
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
