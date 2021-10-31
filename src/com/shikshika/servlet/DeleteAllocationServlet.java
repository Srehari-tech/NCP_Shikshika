package com.shikshika.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shikshika.dao.AllocationDao;
import com.shikshika.dao.CategoryDao;

@WebServlet("/delete-alloc")
public class DeleteAllocationServlet extends HttpServlet 
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
	    	 String id = request.getParameter("cid");  
	    	 String stid = request.getParameter("student_id");  
	    	 System.out.println("course-id="+id);
	    	 System.out.println("course st-id="+stid);
	    	 
	           
	    	 int status = AllocationDao.deleteAllocation(id);
	         if(status == 1)
	         {
	        	 
	        	 response.sendRedirect("Adst_course.jsp?student_id="+stid);
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
