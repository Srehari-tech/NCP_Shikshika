package com.shikshika.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shikshika.connection.DbCon;
import com.shikshika.model.Allocation;
import com.shikshika.model.Course;

public class AllocationDao 
{
	
	public static int allocateCourse(Allocation al) 
	{
				int test = 1;
				
				try
				{
					//System.out.println("student added="+student_id);
					Connection conn = DbCon.getConnection();
				    String query =  "insert into course_allocate (student_id,cid) values(?,?)";
				    PreparedStatement pst = conn.prepareStatement(query);
				    
				    pst.setString(1, al.getStudent_id());
				    pst.setString(2, al.getCid());
				  
				    pst.executeUpdate();
				}
				catch(Exception e)
				{
				    e.printStackTrace();
				}
		return test;
	}
	
	public static List<Course>  getAllallocatedCourses(String id) throws ClassNotFoundException 
	{
        List<Course> book = new ArrayList<>();
        try {

        	
        	Connection conn = DbCon.getConnection();
            String query = "select cid,name,cat_id,image from courses where cid IN (select cid from course_allocate where student_id=?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1,id);
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
        System.out.println(book);
        return book;
    }

	public static int deleteAllocation(String id) 
	{
		 int status=0;
	     try
	     {
	    	Connection conn = DbCon.getConnection();
		    PreparedStatement pt = conn.prepareStatement("delete from course_allocate where cid=?");
	        pt.setString(1, id);
	        pt.execute();
	        status=1;
	         
	     }
	     catch(Exception ex)
	     {
	         ex.printStackTrace();
	     }
	     return status;
	}
	

}
