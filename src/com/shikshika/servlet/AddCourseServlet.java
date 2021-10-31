package com.shikshika.servlet;


import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.shikshika.connection.DbCon;
import com.shikshika.dao.*;
import com.shikshika.model.*;

@WebServlet("/add-course")
@MultipartConfig

public class AddCourseServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
	 response.setContentType("text/html;charset=UTF-8");
	 
     try
     {
    	 PrintWriter out = response.getWriter();

    	 String cid = request.getParameter("cid");
    	 String name = request.getParameter("name");
    	 String cat_id = request.getParameter("cat_id");
         Part image = request.getPart("cimage");
         
         String fn = image.getSubmittedFileName();
        // String path ="C:\\Users\\HP-WORLD\\Downloads\\apache-tomcat-9.0.54\\webapps\\uploaded_images\\"+fn;
         String path ="C:\\Users\\HP-WORLD\\eclipse-workspace\\shikshika_ncp\\WebContent\\course-images\\"+fn;
          Course course = new Course(cid,name,cat_id,fn);
          image.write(path);
        	 

        	 int status = CourseDao.addCourse(course);
             if(status == 1)
             {
            	 response.sendRedirect("admin_page.jsp");
             }
             else
             {
                System.out.print("wrong cre3dential");
             }
         }
             
         //String path = getServletContext().getRealPath("/"+"WebContent"+"/"+"course-images"+File.separator+fn);
         //String path = getServletContext().getRealPath("/"+"cr_images"+"/"+fn);
         //String path ="C:/Users/HP-WORLD/eclipse-workspace/shikshika_ncp/WebContent/course-images/"+fn;
         //System.out.println(path);
         //image.write(path);
       
        
       
        	 //System.out.println("File Uploaded to this directory: "+path);
        	
        
         
         
     
     catch(Exception e)
     {
         e.printStackTrace();
     }

     
	}
	
}