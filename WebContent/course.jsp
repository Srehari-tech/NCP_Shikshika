<%@page import="com.shikshika.connection.DbCon"%>
<%@page import="com.shikshika.dao.StudentDao"%>
<%@page import="com.shikshika.dao.CourseDao"%>
<%@page import="com.shikshika.model.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%

//response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
//response.setHeader("Pragma","no-cache");

List<Course> courses = CourseDao.getAllCourses();

%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>
<style>
body {
   background-image: url("background-1.jpg");
}

</style>
<title>Shikshika</title>
</head>
<body>
	<%@include file="/includes/navbar.jsp"%>

	<div class="container" style="margin-top:50px;background-color:#e3f2fd;padding:30px;">
		
		<div class="row" >
			<%
			if (!courses.isEmpty()) {
				for (Course p : courses) {
			%>
			
			
				<div class="card  text-center"  style="width: 18rem;margin-right:50px;">
				    <div class="embed-responsive embed-responsive-16by9">
    						 <img alt="Card image cap" class="card-img-top embed-responsive-item" src="course-images/<%=p.getImage()%>" />
  					</div>
					<div class="card-body">
						<h5 class="card-title"><%=p.getName() %></h5>
						<h6 class="cid"><%=p.getCid() %></h6>
						<h6 class="category">Category: <%=p.getCategory() %></h6>
						<br>
						<p><a class="btn btn-primary" href="CourseDetails.jsp?cid=<%=p.getCid()%>">Details</a></p>
						
					</div>
				</div>
			
		
		
			<%
			}
			} else {
			out.println("No courses Available");
			}
			%>

		</div>
	</div>

	<%@include file="/includes/footer.jsp"%>
</body>
</html>