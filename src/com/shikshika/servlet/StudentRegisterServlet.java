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

@WebServlet("/student-register")
public class StudentRegisterServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		response.setContentType("text/html;charset=UTF-8");
		
		
		//make user object
		try (PrintWriter out = response.getWriter()) 
		{
			String student_id = request.getParameter("student_id");
			//String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			Student studentModel = new Student(student_id,email, password);

			//create a database model
			StudentDao regStudent = new StudentDao(DbCon.getConnection());
			if (regStudent.saveStudent(studentModel)) 
			{
			   response.sendRedirect("login.jsp");
			} else 
			{
			    String errorMessage = "User Available";
			    request.getSession().setAttribute("RegError", errorMessage);
			    response.sendRedirect("register.jsp");
			    }

		} 
		catch (ClassNotFoundException|SQLException e) 
		{
			e.printStackTrace();
		} 
		
	}
}	