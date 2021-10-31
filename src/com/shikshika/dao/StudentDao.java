package com.shikshika.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.shikshika.connection.DbCon;
import com.shikshika.model.*;


public class StudentDao {
	private Connection con;

	private String query;
    private PreparedStatement pst;
    private ResultSet rs;

	public StudentDao (Connection con) {
		this.con = con;
	}
	
	public Student studentLogin(String student_id, String password) {
		Student student = null;
        try {
            query = "select * from students where student_id=? and password=?";
            pst = this.con.prepareStatement(query);
            pst.setString(1, student_id);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if(rs.next())
            {
            	student = new Student();
            	student.setStudent_id(rs.getString("student_id"));
            	student.setName(rs.getString("name"));
            	student.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return student;
    }
	
	 public static Student getstid(String student_id) throws ClassNotFoundException
	 {
		 Student student = null;
	        try {
	        	Connection conn = DbCon.getConnection();
	            String query = "select * from students where student_id=? ";
	            PreparedStatement pst = conn.prepareStatement(query);
	            pst.setString(1, student_id);
	           
	            ResultSet rs = pst.executeQuery();
	            if(rs.next())
	            {
	            	student = new Student();
	            	student.setStudent_id(rs.getString("student_id"));
	            	student.setName(rs.getString("name"));
	            	student.setEmail(rs.getString("email"));
	            	student.setPassword(rs.getString("password"));
	            
	            }
	        } catch (SQLException e) {
	            System.out.print(e.getMessage());
	        }
	        return student;
	    }
	 
	
	
	 public boolean saveStudent(Student student)
	 {
	        boolean set = false;
	        try
	        {
	            //Insert register data to database
	           String query = "UPDATE students SET email=?, password=? WHERE student_id=?";
	           
	           PreparedStatement pt = this.con.prepareStatement(query);
	          
	           
	           pt.setString(1, student.getEmail());
	           pt.setString(2, student.getPassword());
	           pt.setString(3, student.getStudent_id());
	           
	         
	           
	           pt.executeUpdate();
	           set = true;
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        return set;
	    }
	 
	 
	 public static List<Student>  getAllStudent() throws ClassNotFoundException 
		{
	        List<Student> st = new ArrayList<>();
	        try {

	        	//Connection conn = DbCon.getConnection();
	        	Connection conn = DbCon.getConnection();
	            String query = "select * from students";
	            PreparedStatement pst = conn.prepareStatement(query);
	            ResultSet rs = pst.executeQuery();

	            while (rs.next()) 
	            {
	            	Student row = new Student();
	                row.setStudent_id(rs.getString("student_id"));
	                row.setName(rs.getString("name"));
	                row.setEmail(rs.getString("email"));
	                row.setPassword(rs.getString("password"));
	               
	                st.add(row);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }
	        return st;
	    }

	


	public static int addStudent(Student student) throws ClassNotFoundException 
	{
		try 
		{
			Connection conn = DbCon.getConnection();
			
	        	 String query1 = "insert into students(student_id,name) values(?,?)";
	        	 PreparedStatement pst = conn.prepareStatement(query1);
	        	 pst.setString(1, student.getStudent_id());
		         pst.setString(2, student.getName());
		         pst.executeUpdate();
		         return 1;
	        
		}
	   catch (SQLException e)
		{
        e.printStackTrace();
        System.out.println(e.getMessage());
       }
		
		return 0;
        
	}

	public static int deleteStudent(String id) 
	{
		int status=0;
	     try
	     {
	    	Connection conn = DbCon.getConnection();
	    	PreparedStatement pt = conn.prepareStatement("delete from students where student_id=?");
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

	public static int updateStudent(Student student) 
	{
		int value=0;
	       try{
	    	   Connection conn = DbCon.getConnection();
	    	   System.out.print("student ::::+"+student);
	           String query = "UPDATE students SET name=?, email=?, password=? WHERE student_id=?";
	           
	           PreparedStatement pt = conn.prepareStatement(query);
	          
	           pt.setString(1, student.getName());
	           pt.setString(2, student.getEmail());
	           pt.setString(3, student.getPassword());
	           pt.setString(4, student.getStudent_id());
	          
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