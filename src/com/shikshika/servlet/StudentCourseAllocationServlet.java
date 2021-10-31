package com.shikshika.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.shikshika.dao.AllocationDao;
import com.shikshika.model.Allocation;
import com.shikshika.model.Category;
import com.shikshika.model.Course;


@WebServlet("/allocatestudentcourse")
public class StudentCourseAllocationServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 try
	     {
	    	 PrintWriter out = response.getWriter();

	    	 String student_id = request.getParameter("student_id");
	    	 String cid = request.getParameter("cid");
	          
	          Allocation al= new Allocation(student_id,cid);
	        		 
	        	 int status = AllocationDao.allocateCourse(al);
	             if(status == 1)
	             {
	            	 response.sendRedirect("Adst_course.jsp?student_id="+student_id);
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
