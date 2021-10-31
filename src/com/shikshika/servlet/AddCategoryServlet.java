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

@WebServlet("/add-sem")

public class AddCategoryServlet  extends HttpServlet
{
private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
	 response.setContentType("text/html;charset=UTF-8");
	 
     try
     {
    	 PrintWriter out = response.getWriter();

    	 int cat_id = Integer.parseInt(request.getParameter("cat_id"));
    	 String category =request.getParameter("category");
         
    	 Category cat = new Category(cat_id,category);
           	 

        	 int status = CategoryDao.addCategory(cat);
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
