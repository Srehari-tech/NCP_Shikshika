package com.shikshika.servlet;

import java.io.*;
import java.sql.SQLException;

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

@WebServlet("/update-course")



	
public class UpdateCourseServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	 response.setContentType("text/html;charset=UTF-8");
	
	 String cid = request.getParameter("cid");
	 String name = request.getParameter("name");
     String category = request.getParameter("cat_id");
     String image = request.getParameter("image");
     String abt_course = request.getParameter("abt_course");
     String syllabus = request.getParameter("syllabus");
     String textbook = request.getParameter("textbook");
     String ref = request.getParameter("ref");
     
     Course course = new Course(cid,name,category,image,abt_course,syllabus,textbook,ref);
     System.out.println("----"+course);
     
     try
     {
    
         
    	 int success=CourseDao.updateCourseInfo(course);
         if(success == 1)
         {
             System.out.println(success);
             response.sendRedirect( "faculty_course.jsp?cid="+cid);
        	 //response.sendRedirect("faculty_course.jsp"); 
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
