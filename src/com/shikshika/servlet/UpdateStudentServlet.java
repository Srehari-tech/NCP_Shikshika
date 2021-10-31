package com.shikshika.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shikshika.dao.FacultyDao;
import com.shikshika.dao.StudentDao;
import com.shikshika.model.Faculty;
import com.shikshika.model.Student;

@WebServlet("/update-profile")
public class UpdateStudentServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 String student_id = request.getParameter("student_id");
		 String name = request.getParameter("name");
	     String email = request.getParameter("email");
	     String password = request.getParameter("password");   

	     
	     try
	     {
	        	 
	    	 Student student = new Student(student_id,name,email,password);
	      
	         
	    	 int success=StudentDao.updateStudent(student);
	         if(success == 1)
	         {
	             
	        	 response.sendRedirect("studentinfo.jsp?student_id="+student_id); 
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
