package com.shikshika.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.shikshika.connection.DbCon;
import com.shikshika.dao.*;
import com.shikshika.model.*;

@WebServlet("/delete-cat")
public class DeleteCategoryServlet extends HttpServlet 
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
	    	 int id = Integer.parseInt(request.getParameter("cat_id"));  
	    	 System.out.println(id);
	    	 
	           
	    	 int status = CategoryDao.deleteCategory(id);
	         if(status == 1)
	         {
	        	 
	        	 response.sendRedirect("Category.jsp");
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
