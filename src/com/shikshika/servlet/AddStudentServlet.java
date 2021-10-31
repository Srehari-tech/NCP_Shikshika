package com.shikshika.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shikshika.dao.*;
import com.shikshika.model.*;


@WebServlet("/add-student")
public class AddStudentServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 try
	     {
	    	 PrintWriter out = response.getWriter();

	    	 String student_id = request.getParameter("student_id");
	    	 String studentname = request.getParameter("name");
	    	
	         
	         Student student = new Student(student_id,studentname);
	           	 

	        	 int status = StudentDao.addStudent(student);
	             if(status == 1)
	             {
	            	 response.sendRedirect("StudentList.jsp");
	             }
	             else
	             {
	                System.out.print("Wrong Credentials!!!");
	             }
	         }
	             
	   
	     catch(Exception e)
	     {
	         e.printStackTrace();
	     }

	     
		}
	

}
