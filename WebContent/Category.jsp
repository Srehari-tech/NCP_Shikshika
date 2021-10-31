<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.shikshika.connection.DbCon"%>
<%@page import="com.shikshika.dao.CourseDao"%>
<%@page import="com.shikshika.dao.CategoryDao"%>
<%@page import="com.shikshika.model.*"%>
<%@page import="java.util.*"%>



<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
         
        <meta http-equiv="Content-Type" name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

        <title>Shikshika</title>

        <style>
					
					body {
   background-image: url("background-1.jpg");
}
		
        </style>
        <%@include file="/includes/navbar.jsp"%>
    </head>
    <body>
    <div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">Add Semester</div>
			<div class="card-body">
				<form action="add-sem" method="post">
					<div class="form-group">
						<label>Semester Id</label> 
						<input type="number" min=1 max=8 name="cat_id" class="form-control" placeholder="Enter id" >
					</div>
					<div class="form-group">
						<label>Semester Title</label> 
						<input type="text" name="category" class="form-control" placeholder="Title">
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-danger">Add</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<div class="container" style="background-colour:green;">

    <div class="card w-50 mx-auto my-5 text-white bg-dark " >
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th colspan="1" style="text-align:center">Semester Id</th>
            <th colspan="1">Title</th>
            <th colspan="1"></th>
           
        </tr>
        </thead>
        <tbody style="background-color:#bbdefb;">
		 
       
        		<%
				List<Category> flt = CategoryDao.getAllCategory();
				%>
			    
			    <%
					if (!flt.isEmpty()) 
					{
						for (Category p : flt) 
						{
							int n=p.getId();
							System.out.println(n);
							
			     %>
			     <tr>
			     			<td class="text-center"><%=p.getId() %></td>
			     			<td><%=p.getName() %></td>
                            <td><a href="delete-cat?cat_id=<%=p.getId() %>" class="btn btn-danger">Delete</a></td>
               
            					</tr>
            			<%
						}
					}
            			%>
				
									
        </tbody>
        </tbody>
    </table>
</div>
</div>
        

	</body>
</html>

