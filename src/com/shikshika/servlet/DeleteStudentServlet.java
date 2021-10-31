package com.shikshika.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shikshika.dao.*;


@WebServlet("/delete-student")
public class DeleteStudentServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		try
	     {
	    	 String id = request.getParameter("student_id");  
	    	 System.out.println(id);
	    	 
	           
	    	 int status = StudentDao.deleteStudent(id);
	         if(status == 1)
	         {
	        	 
	        	 response.sendRedirect("StudentList.jsp");
	         }
	         else
	         {
	            System.out.print("wrong cre3dential");
	         }
	         
	     }
	     catch(Exception e)
	     {
	         e.printStackTrace();
	     }
		
	}

}
