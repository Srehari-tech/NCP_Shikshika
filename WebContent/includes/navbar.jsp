<%@page import="com.shikshika.connection.DbCon"%>
<%@page import="com.shikshika.dao.StudentDao"%>
<%@page import="com.shikshika.dao.CourseDao"%>
<%@page import="com.shikshika.dao.AdminDao"%>
<%@page import="com.shikshika.model.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%

Student auth = (Student) request.getSession().getAttribute("auth");
if (auth != null) 
{
	request.setAttribute("auth", auth);
}

Admin adminst = (Admin) request.getSession().getAttribute("adminst");
if (adminst != null) {
	request.setAttribute("adminst", adminst);
}
Faculty teacher = (Faculty) request.getSession().getAttribute("teacher");
if (teacher != null) {
    request.setAttribute("teacher", teacher);
}


%>



<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container">
		<a class="navbar-brand" href="index.jsp">Shikshika</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
			
				
				
				<%
				if (auth == null && adminst==null && teacher==null) 
				{
				%>
				<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="login.jsp">Student Login</a></li>
				<li class="nav-item"><a class="nav-link" href="StudentRegister.jsp">Student Sign Up</a></li>
				<li class="nav-item"><a class="nav-link" href="Adminlogin.jsp">Admin</a></li>
				<li class="nav-item"><a class="nav-link" href="FacultyLogin.jsp">Faculty</a></li>
				<%
				} 
				else if (auth != null) 
				{
						if (auth != null) 
						{
						%>
						<li class="nav-item"><a class="nav-link" href="log-out">Logout</a></li>
						<li class="nav-item"><a class="nav-link" href="course.jsp">Course</a></li>
						
						<%
						} 
						else 
						{
						%>
						<li class="nav-item"><a class="nav-link" href="login.jsp">Student Login</a></li>
						<li class="nav-item"><a class="nav-link" href="StudentRegister.jsp">Student Sign Up</a></li>
						<%
						}
				}	
				else if(adminst != null)
				{
					if (adminst != null) 
					{
					%>
					<li class="nav-item"><a class="nav-link" href="course.jsp">Course</a></li>
					<li class="nav-item"><a class="nav-link" href="Adminpanel.jsp">Admin Panel</a></li>
					<li class="nav-item"><a class="nav-link" href="exit">Logout</a></li>
					<%
					} 
					else 
					{
					%>
					<li class="nav-item"><a class="nav-link" href="Adminlogin.jsp">AdminLogin</a></li>
					<%
					}
				}
				else if(teacher != null)
				{
					if (teacher != null) 
					{
					%>
					<li class="nav-item"><a class="nav-link" href="course.jsp">Course</a></li>
					<li class="nav-item"><a class="nav-link" href="fexit">Logout</a></li>
					<%
					} 
					else 
					{
					%>
					<li class="nav-item"><a class="nav-link" href="FacultyLogin.jsp">Faculty Login</a></li>
					<%
					}
				}
				%>
				
				
	
			</ul>
		</div>
	</div>
</nav>