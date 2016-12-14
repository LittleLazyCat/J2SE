package com.example.web;

import java.io.IOException;
import java.util.ArrayList;
import com.example.model.jspModel;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class jspServlet extends HttpServlet {
	
    
	private static final long serialVersionUID = 1L;

	 
 
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	 
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String hobby = req.getParameter("hobby");
		jspModel jspm = new jspModel();
		ArrayList<String> list = jspm.shareHobby(hobby);
		req.setAttribute("hobby", hobby);
		req.setAttribute("names", list);
		RequestDispatcher view = req.getRequestDispatcher("result.jsp");
		view.forward(req, res);
	}

}
