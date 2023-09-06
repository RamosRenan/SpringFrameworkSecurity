package com.personal.security.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DashboardAdmServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7412471371194808171L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/adm/dashboard.jsp");
		
		dispatcher.forward(req, resp);
	}

}// class
