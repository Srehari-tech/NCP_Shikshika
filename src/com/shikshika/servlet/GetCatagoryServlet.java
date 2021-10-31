package com.shikshika.servlet;

import com.google.gson.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.shikshika.dao.*;
import com.shikshika.model.*;


@WebServlet("/get-category")
public class GetCatagoryServlet extends HttpServlet  
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
        try (PrintWriter out = response.getWriter()) 
        {

            String op = request.getParameter("operation");
            out.write(op);
            if (op.equals("cat_id")) 
            {
                List<Category> clist = CategoryDao.getAllCategory();
                Gson json = new Gson();
                String catList = json.toJson(clist);
                response.setContentType("text/html");
                response.getWriter().write(catList);
            }
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}}