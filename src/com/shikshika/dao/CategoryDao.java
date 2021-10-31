package com.shikshika.dao;
import java.sql.*;
import java.util.*;

//import com.shikshika..Cart;
import com.shikshika.model.Category;
import com.shikshika.model.Course;
import com.shikshika.connection.DbCon;

public class CategoryDao 
{

	public static List<Category> getAllCategory() throws ClassNotFoundException 
	{
        List<Category> book = new ArrayList<>();
        try {

        	
        	Connection conn = DbCon.getConnection();
            String query = "select * from category_course";
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) 
            {
            	Category row = new Category();
            	row.setId(rs.getInt("cat_id"));
                row.setName(rs.getString("category"));
                book.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return book;
    }
	
	
	//add category
	public static int addCategory(Category category)
    {
        int test = 1;
        
        try
        {
        	Connection conn = DbCon.getConnection();
            String query =  "insert into category_course(cat_id,category) values(?,?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, category.getId());
            pst.setString(2, category.getName());
            pst.executeUpdate();
            

        }catch(Exception e){
            e.printStackTrace();
        }
        return test;
    }
	
	// delete cat from database
	   
	   
	 public static int deleteCategory(int id)
	 {
		 int status=0;
	     try
	     {
	    	 Connection conn = DbCon.getConnection();
		     //String query= "delete from courses where cat_id=?";
		     PreparedStatement pt = conn.prepareStatement("delete from category_course where cat_id=?");
	        pt.setInt(1, id);
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
