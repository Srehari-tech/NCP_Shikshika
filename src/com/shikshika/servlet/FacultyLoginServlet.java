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

@WebServlet("/faculty-login")
public class FacultyLoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) 
		{
			String faculty_id = request.getParameter("login-faculty_id");
			String f_password = request.getParameter("login-faculty_password");

			FacultyDao fdao = new FacultyDao(DbCon.getConnection());
			Faculty faculty = fdao.facultyLogin(faculty_id, f_password);
			if (faculty != null) 
			{
				request.getSession().setAttribute("teacher", faculty);
				Faculty f1=fdao.getCid(faculty_id);
				String id=f1.getCourseId();
				System.out.println(id);
				response.sendRedirect( "faculty_course.jsp?cid="+id );
				//request.getRequestDispatcher("faculty_course.jsp").forward(request, response);
				//response.sendRedirect("faculty_course.jsp");
			} 
			else 
			{
				response.sendRedirect("FacultyLogin.jsp");
			}

		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		} 

	}
}