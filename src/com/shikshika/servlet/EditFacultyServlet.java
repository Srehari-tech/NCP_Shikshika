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

@WebServlet("/edit-faculty")
	


	
public class EditFacultyServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	 response.setContentType("text/html;charset=UTF-8");
	
	 String faculty_id = request.getParameter("faculty_id");
	 String facultyname = request.getParameter("facultyname");
     String cid = request.getParameter("cid");
     String password = request.getParameter("password");   

     	
     
     
     try
     {
    
    	 
    	 Faculty faculty = new Faculty(faculty_id,facultyname,cid,password);
      
         
    	 int success=FacultyDao.editFacultyInfo(faculty);
         if(success == 1)
         {
             
        	 response.sendRedirect("Facultylist.jsp"); 
         }
         else
         {
             System.out.print("Wrong Credentials!!!");
         }
         
         
         
        
         
    	 
         
     }catch(Exception e){
         e.printStackTrace();
     }
     
	 
	 
	}
}
