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

@WebServlet("/student-login")
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String student_id = request.getParameter("login-student_id");
			String password = request.getParameter("login-password");

			StudentDao stdao = new StudentDao(DbCon.getConnection());
			Student student = stdao.studentLogin(student_id, password);
			if (student != null) 
			{
				request.getSession().setAttribute("auth", student);
				Student st=StudentDao.getstid(student_id);
				String id=st.getStudent_id();
				System.out.println("id ="+id);
				response.sendRedirect("studentinfo.jsp?student_id="+id);
			} else 
			{
				response.sendRedirect("index.jsp");
			}

		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		} 

	}
}