package com.shikshika.servlet;


import java.io.*;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shikshika.connection.DbCon;
import com.shikshika.dao.*;
import com.shikshika.model.*;

@WebServlet("/exit")
public class AdminLogoutServlet  extends HttpServlet
{

		private static final long serialVersionUID = 1L;
		 
		 
		    
	   
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			response.setContentType("text/html;charset=UTF-8");
			try (PrintWriter out = response.getWriter()) 
			{
				request.getSession().getAttribute("adminst");
				
					request.getSession().removeAttribute("adminst");
					response.sendRedirect("index.jsp");
				

			} 
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

	}

