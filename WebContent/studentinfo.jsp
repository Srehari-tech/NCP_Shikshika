<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="com.shikshika.connection.DbCon"%>
<%@page import="com.shikshika.dao.CourseDao"%>
<%@page import="com.shikshika.dao.FacultyDao"%>
<%@page import="com.shikshika.dao.StudentDao"%>
<%@page import="com.shikshika.dao.CategoryDao"%>
<%@page import="com.shikshika.model.*"%>
<%@page import="java.util.*"%>



<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>

  
  <style>
  
body {
    margin: 0;
     background-image: url("background-1.jpg");
}

ul {
    list-style-type: none;
    margin: 0;
    padding: 0px;
    width: 20%;
    background-color: #4fc3f7;
    position: fixed;
    height: 100%;
    overflow: auto;
}
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 500px;
  max-height: 900px;
  margin: auto;
  margin-top:60px;
  padding:60px;
  text-align: center;
  font-family: arial;
  background-color:white;
}

.title {
  color: grey;
  font-size: 18px;
}





li a {
    display: block;
    color: #000;
    padding: 20px 16px 8px 16px;
    text-decoration: none;
}

li a.active {
    background-color: #01579b;
    color: white;
}

li a:hover:not(.active) {
    background-color: #555;
    color: white;
}
  
  </style>
</head>
<body>
<%
String id = request.getParameter("student_id");
System.out.println(id);
Student st = StudentDao.getstid(id);
System.out.println(st);
%>

<ul>
  <li><a class="active" href="studentinfo.jsp"><h2>Welcome</h2></a></li>
  <li><a href="Mycourses.jsp?student_id=<%=id%>"><h3>My Courses</h3></a></li>
  <li><a href="Student_edit_profile.jsp?student_id=<%=id%>"><h3>Edit Profile</h3></a></li>
  <li><a href="log-out"><h3>Logout</h3></a></li>
</ul>


<div style="margin-left:25%;padding:5px 16px;height:1000px;">

  <h2 style="text-align:center;padding:30px;background-color:white;">Student Panel</h2>

<div class="card">

  <h1><%=id%></h1>
  <p class="title"><%=st.getName()%></p>
  <p><%=st.getEmail()%></p>
  
 
</div>
 
</div>

</body>
</html>
