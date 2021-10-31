package com.shikshika.servlet;

import java.io.*;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.shikshika.connection.DbCon;
import com.shikshika.dao.*;
import com.shikshika.model.*;

@WebServlet("/add-faculty")

public class AddFacultyServlet  extends HttpServlet
{
private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
	 response.setContentType("text/html;charset=UTF-8");
	 
     try
     {
    	 PrintWriter out = response.getWriter();

    	 String faculty_id = request.getParameter("faculty_id");
    	 String facultyname = request.getParameter("facultyname");
    	 String cid = request.getParameter("cid");
    	 String password =request.getParameter("password");
         
         Faculty faculty = new Faculty(faculty_id,facultyname,cid,password);
           	 

        	 int status = FacultyDao.addFaculty(faculty);
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

