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

@WebServlet("/delete-faculty")
	

	
public class DeleteFacultyServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
	 response.setContentType("text/html;charset=UTF-8");
	 
     try
     {
    	 String id = request.getParameter("faculty_id");  
    	 System.out.println(id);
    	 
           
    	 int status = FacultyDao.deleteCourse(id);
         if(status == 1)
         {
        	 
        	 response.sendRedirect("Facultylist.jsp");
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