package com.shikshika.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.shikshika.connection.DbCon;
import com.shikshika.model.*;


public class FacultyDao {
	private Connection con;

	private String query;
    private PreparedStatement pst;
    private ResultSet rs;

	public FacultyDao (Connection con) 
	{
		this.con = con;
	}
	
	public Faculty facultyLogin(String faculty_id, String password) {
		Faculty faculty = null;
        try {
            query = "select * from faculty where faculty_id=? and password=?";
            pst = this.con.prepareStatement(query);
            pst.setString(1, faculty_id);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if(rs.next())
            {
            	faculty = new Faculty();
            	faculty.setId(rs.getString("faculty_id"));
            	faculty.setName(rs.getString("facultyname"));
            	faculty.setCourseId(rs.getString("cid"));
            
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return faculty;
    }
	
	
	//get cat
	
	 public Faculty getCid(String faculty_id)
	 {
		 Faculty faculty = null;
	        try {
	            query = "select * from faculty where faculty_id=? ";
	            pst = this.con.prepareStatement(query);
	            pst.setString(1, faculty_id);
	           
	            rs = pst.executeQuery();
	            if(rs.next())
	            {
	            	faculty = new Faculty();
	            	faculty.setId(rs.getString("faculty_id"));
	            	faculty.setName(rs.getString("facultyname"));
	            	faculty.setCourseId(rs.getString("cid"));
	            
	            }
	        } catch (SQLException e) {
	            System.out.print(e.getMessage());
	        }
	        return faculty;
	    }
	 
	//get courseid
		
		 public boolean saveFaculty(Faculty faculty)
		 {
		        boolean set = false;
		        try
		        {
		            //Insert register data to database
		            String query = "insert into faculty(faculty_id,facultyname,cid,password) values(?,?,?,?)";
		           
		           PreparedStatement pt = this.con.prepareStatement(query);
		           pt.setString(1, faculty.getId());
		           pt.setString(2, faculty.getName());
		           pt.setString(3, faculty.getCourseId());
		           pt.setString(4, faculty.getPassword());
		           
		           pt.executeUpdate();
		           set = true;
		        }
		        catch(Exception e)
		        {
		            e.printStackTrace();
		        }
		        return set;
		    }
		 
		 
	 
	 public static int addFaculty(Faculty faculty)
	    {
	        int test = 1;
	        
	        try
	        {
	        	Connection conn = DbCon.getConnection();
	            String query =  "insert into faculty (faculty_id,facultyname,cid,password) values(?,?,?,?)";
	            PreparedStatement pst = conn.prepareStatement(query);
	            pst.setString(1, faculty.getId());
	            pst.setString(2, faculty.getName());
	            pst.setString(3, faculty.getCourseId());
	            pst.setString(4, faculty.getPassword());
	 
	            pst.executeUpdate();
	            

	        }catch(Exception e){
	            e.printStackTrace();
	        }
	        return test;
	    }
	 
	 
		
		//retrive courses
		public static List<Faculty>  getAllFaculty() throws ClassNotFoundException 
		{
	        List<Faculty> book = new ArrayList<>();
	        try {

	        	//Connection conn = DbCon.getConnection();
	        	Connection conn = DbCon.getConnection();
	            String query = "select * from faculty";
	            PreparedStatement pst = conn.prepareStatement(query);
	            ResultSet rs = pst.executeQuery();

	            while (rs.next()) 
	            {
	            	Faculty row = new Faculty();
	                row.setId(rs.getString("faculty_id"));
	                row.setName(rs.getString("facultyname"));
	                row.setCourseId(rs.getString("cid"));
	                row.setPassword(rs.getString("password"));
	               
	                book.add(row);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }
	        return book;
	    }
		
		
		
		// delete faculty from database
		   
		   
		 public static int deleteCourse(String faculty_id)
		 {
			 int status=0;
		     try
		     {
		    	 Connection conn = DbCon.getConnection();
			     //String query= "delete from courses where faculty_id=?";
			     PreparedStatement pt = conn.prepareStatement("delete from faculty where faculty_id=?");
		        pt.setString(1, faculty_id);
		        pt.execute();
		        status=1;
		         
		     }
		     catch(Exception ex)
		     {
		         ex.printStackTrace();
		     }
		     return status;
		 }
		   
		 
		 //get single faculty
		 public static Faculty getSingleFaculty(String faculty_id) 
		 {
			 Faculty row = null;
		        try 
		        {
		        	Connection conn = DbCon.getConnection();
		            String query = "select * from faculty where faculty_id=? ";
		            
		            PreparedStatement pst = conn.prepareStatement(query);
		            pst.setString(1,faculty_id);
		            ResultSet rs = pst.executeQuery();

		            while (rs.next()) 
		            {
		            	row = new Faculty(rs.getString("faculty_id"),rs.getString("facultyname"),rs.getString("cid"),rs.getString("password"));
		            }
		        } 
		        catch (Exception e) 
		        {
		            e.printStackTrace();
		            System.out.println(e.getMessage());
		        }

		        return row;
		    }
		 
		 
	//   update faculty information
		   public static int editFacultyInfo(Faculty faculty)
		   {
		       int value=0;
		       try{
		    	   Connection conn = DbCon.getConnection();
		           String query = "UPDATE faculty SET facultyname=?, cid=?, password=? WHERE faculty_id=?";
		           
		           PreparedStatement pt = conn.prepareStatement(query);
		          
		           pt.setString(1, faculty.getName());
		           pt.setString(2, faculty.getCourseId());
		           pt.setString(3, faculty.getPassword());
		           pt.setString(4, faculty.getId());
		          
		           pt.executeUpdate();
		           
		           value=1;
		           System.out.print(value);
		       }
		       catch(Exception ex)
		       {
		           ex.printStackTrace();
		       }
		       return value;
		       
		   }
	 
}

