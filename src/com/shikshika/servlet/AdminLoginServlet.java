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

@WebServlet("/admin-login")
public class AdminLoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) 
		{
			String admin_id = request.getParameter("login-admin_id");
			String ad_password = request.getParameter("login-admin_password");

			AdminDao udao = new AdminDao(DbCon.getConnection());
			Admin admin = udao.adminLogin(admin_id, ad_password);
			if (admin != null) 
			{
				request.getSession().setAttribute("adminst", admin);
				response.sendRedirect("Adminpanel.jsp?admin_id="+admin_id);
			} 
			else 
			{
				response.sendRedirect("Adminlogin.jsp");
			}

		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		} 

	}
}