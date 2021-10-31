<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.shikshika.connection.DbCon"%>
<%@page import="com.shikshika.dao.CourseDao"%>
<%@page import="com.shikshika.dao.FacultyDao"%>
<%@page import="com.shikshika.dao.StudentDao"%>
<%@page import="com.shikshika.dao.CategoryDao"%>
<%@page import="com.shikshika.model.*"%>
<%@page import="java.util.*"%>
<% 
String id = request.getParameter("admin_id");
System.out.println(id); 
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    
    <title>Document</title>
    <style>
    body {
   background-image: url("background-1.jpg");
}
 
    </style>
    <%@include file="/includes/navbar.jsp"%>
</head>
<body>

<div class="card" style="background-color:#f3e5f5;margin: 80px ">
<div class="container-fluid">

    <a href="AddStudent.jsp" style="margin: 20px 0" class="btn btn-primary"><b>&nbsp;&nbsp; +  </b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Add Student</a>
    <table class="table">
        <thead class="table-primary"> 
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Student Name</th>
            <th scope="col"></th>
            <th scope="col"></th>
            
        </tr>
        </thead>
        <tbody>
       
        		<%
				List<Student> flt = StudentDao.getAllStudent();
				%>
			    
			    <%
					if (!flt.isEmpty()) 
					{
						for (Student p : flt) 
						{
			     %>
			     <tr>
			     			
                            <td><b><%=p.getStudent_id() %></b></td>
			     			<td><b><%=p.getName() %></b></td>
							<td><a href="delete-student?student_id=<%=p.getStudent_id() %>" class="btn btn-danger">Delete</a></td>
							<td><a href="Adst_course.jsp?student_id=<%=p.getStudent_id()%>&admin_id=<%=id%>" class="btn btn-info">Manage</a></td>
                            	
            					
            					</tr>
            			<%
						}
					}
            			%>
				
									
        </tbody>
    </table>
</div>
</div>


<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>