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
		String name = req.getParameter("username");//�õ������ύ���û���
		Cookie cookie = new Cookie("username",name);//����һ��cookie������û���
		cookie.setMaxAge(30*60);//cookie�ڿͻ��˴��ʱ��30����
		res.addCookie(cookie);//����cookie����Ϊ��Set-Cookie����Ӧ�ײ�
		RequestDispatcher view = req.getRequestDispatcher("cookieresult.jsp");//��jsp������Ӧ�ײ�
		view.forward(req, res);
	}
	
}
