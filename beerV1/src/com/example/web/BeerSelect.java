package com.example.web;

import com.example.model.*;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BeerSelect extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);
	}
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
//		PrintWriter pw = response.getWriter();
//		pw.println("Beer Selection Advice<br>");
		
		String c = request.getParameter("color");
		BeerExpert be = new BeerExpert();
		List brands = be.getBrands(c);
		request.setAttribute("styles", brands);//JSP要寻找styles
		RequestDispatcher view = request.getRequestDispatcher("result.jsp");//为JSP实例化一个请求分派器
		view.forward(request, response);
//		Iterator it = brands.iterator();
//		while(it.hasNext())
//		{
//			pw.println("<br>try: " + it.next());
//			
//		}
		
	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);
	}

	

}
