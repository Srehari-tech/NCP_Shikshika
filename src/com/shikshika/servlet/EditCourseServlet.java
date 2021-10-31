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

@WebServlet("/edit-course")
@MultipartConfig


	
public class EditCourseServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	 response.setContentType("text/html;charset=UTF-8");
	
	 String cid = request.getParameter("cid");
	 String name = request.getParameter("name");
     String category = request.getParameter("category");
     String image = request.getParameter("image");
     Part image1 = request.getPart("image1");
     

     	
     String fn = image1.getSubmittedFileName();
    if(image.equals(fn) || fn.equals(""))
    {
    	String path ="C:\\Users\\HP-WORLD\\eclipse-workspace\\shikshika_ncp\\WebContent\\course-images\\"+image;
    	
       
    }
    else 
    {
    	String path ="C:\\Users\\HP-WORLD\\eclipse-workspace\\shikshika_ncp\\WebContent\\course-images\\"+fn;
    	 image1.write(path);
    }
     
    Course course = new Course(cid,name,category,fn);
     	 
     
     try
     {
    
         
    	 int success=CourseDao.editCourseInfo(course);
         if(success == 1)
         {
        	 System.out.println(success);
             
        	 response.sendRedirect("admin_page.jsp"); 
         }
         else
         {
             System.out.print("wrong cre3dential");
         }
         
         
         
        
         
    	 
         
     }catch(Exception e){
         e.printStackTrace();
     }
     
	 
	 
	}
}
