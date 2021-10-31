package com.shikshika.dao;

import java.sql.*;
import java.util.*;

//import com.shikshika..Cart;
import com.shikshika.model.Course;
import com.shikshika.connection.DbCon;

public class CourseDao {
	//private Connection con;

	//private String query;
    //private PreparedStatement pst;
    //private ResultSet rs;
    

	
	
	//add course information to database
    public static int addCourse(Course course)
    {
        int test = 1;
        
        try
        {
        	Connection conn = DbCon.getConnection();
            String query =  "insert into courses (cid,name,cat_id,image) values(?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, course.getCid());
            pst.setString(2, course.getName());
            pst.setString(3, course.getCategory());
            pst.setString(4, course.getImage());
        
         
 
            pst.executeUpdate();
            

        }catch(Exception e){
            e.printStackTrace();
        }
        return test;
    }
	
	//retrive courses
	public static List<Course>  getAllCourses() throws ClassNotFoundException 
	{
        List<Course> book = new ArrayList<>();
        try {

        	//Connection conn = DbCon.getConnection();
        	Connection conn = DbCon.getConnection();
            String query = "select * from courses";
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) 
            {
            	Course row = new Course();
                row.setCid(rs.getString("cid"));
                row.setName(rs.getString("name"));
                row.setCategory(rs.getString("cat_id"));
                row.setImage(rs.getString("image"));
               
                book.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return book;
    }
	
	
	
//  get single book information in edit page
 
	
	 public static Course getSingleCourse(String cid) 
	 {
		 Course row = null;
	        try 
	        {
	        	Connection conn = DbCon.getConnection();
	            String query = "select * from courses where cid=? ";
	            
	            PreparedStatement pst = conn.prepareStatement(query);
	            pst.setString(1,cid);
	            ResultSet rs = pst.executeQuery();

	            while (rs.next()) 
	            {
	            	row = new Course(rs.getString("cid"),rs.getString("name"),rs.getString("cat_id"),rs.getString("image"));
	            }
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }

	        return row;
	    }
	 
	 
	 //get all categories
	 
	 
//   edit course information
   public static int editCourseInfo(Course course)
   {
       int value=0;
       try{
    	   Connection conn = DbCon.getConnection();
           String query = "UPDATE courses SET name=?, cat_id=?, image=? WHERE cid=?";
           
           PreparedStatement pt = conn.prepareStatement(query);
          
           
           pt.setString(1, course.getName());
           pt.setString(2, course.getCategory());
           pt.setString(3, course.getImage());
           pt.setString(4, course.getCid());
          
           pt.executeUpdate();
           
           value=1;
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
       }
       return value;
       
   }
   
   
// delete course from database
   
   
 public static int deleteCourse(String cid)
 {
	 int status=0;
     try
     {
    	 Connection conn = DbCon.getConnection();
	     String query= "delete from courses where cid=?";
	     PreparedStatement pt = conn.prepareStatement("delete from courses where cid=?");
        pt.setString(1, cid);
        pt.execute();
        status=1;
         
     }
     catch(Exception ex)
     {
         ex.printStackTrace();
     }
     return status;
 }
   

//update course information
public static int updateCourseInfo(Course course)
{
   int value=0;
   try{
	   
	   Connection conn = DbCon.getConnection();
       String query = "UPDATE courses SET name=?, cat_id=?,image=?,abt_course=? ,syllabus=?,textbook=?,ref=? WHERE cid=?";
       
       PreparedStatement pt = conn.prepareStatement(query);
      
       
       pt.setString(1, course.getName());
       pt.setString(2, course.getCategory());
       pt.setString(3, course.getImage());
       pt.setString(4, course.getAbt_course());
       pt.setString(5, course.getSyllabus());
       pt.setString(6, course.getTextbook());
       pt.setString(7, course.getRef());
       pt.setString(8, course.getCid());
      
       pt.executeUpdate();
       
       value=1;
   }
   catch(Exception ex)
   {
       ex.printStackTrace();
   }
   return value;
   
}


//get single coursedetails information in details page


 public static Course getDetailsCourse(String cid) 
 {
	 Course row = null;
        try 
        {
        	Connection conn = DbCon.getConnection();
            String query = "select * from courses where cid = ?";
            
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1,cid);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) 
            {
            	String a=rs.getString("cid");
            	String b=rs.getString("name");
            	String c=rs.getString("cat_id");
            	String h=rs.getString("image");
            	String d=rs.getString("abt_course");
            	String e=rs.getString("syllabus");
            	String f=rs.getString("textbook");
            	String g=rs.getString("ref");
            			
            	row = new Course(a,b,c,h,d,e,f,g);
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println(row);
        return row;
       
    }



	
}
