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
		Cookie[] cookies = req.getCookies();//�������еõ�cookies
		if(cookies!=null)
		{
			int len = cookies.length;
			for(int i = 0;i<len;i++)//ѭ������cookie����
			{
				Cookie cookie = cookies[i];
				if("username".equals(cookie.getName()))//�����и���Ϊ��username����cookie
				{
					//���������һ��cookie���õ�����ֵ������ӡ���
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
