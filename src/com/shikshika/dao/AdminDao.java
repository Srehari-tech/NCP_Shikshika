package com.shikshika.dao;


import java.sql.*;
import com.shikshika.model.*;


public class AdminDao 
{
	private Connection con;
	private String query;
    private PreparedStatement pst;
    private ResultSet rs;

	public AdminDao (Connection con) 
	{
		this.con = con;
	}
	
	public Admin adminLogin(String admin_id, String ad_password) 
	{
		Admin admin = null;
        try 
        {
            query = "select * from administrator where admin_id=? and ad_password=?";
            pst = this.con.prepareStatement(query);
            pst.setString(1, admin_id);
            pst.setString(2, ad_password);
            rs = pst.executeQuery();
            if(rs.next())
            {
            	admin = new Admin();
            	admin.setAdmin_id(rs.getString("admin_id"));
            	//admin.setName(rs.getString("ad_password"));
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return admin;
    }
}