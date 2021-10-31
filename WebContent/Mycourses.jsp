<%@page import="com.shikshika.connection.DbCon"%>
<%@page import="com.shikshika.dao.StudentDao"%>
<%@page import="com.shikshika.dao.CourseDao"%>
<%@page import="com.shikshika.dao.AllocationDao"%>
<%@page import="com.shikshika.model.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%


//response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
//response.setHeader("Pragma","no-cache");

String id = request.getParameter("student_id");
System.out.println(id);


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
	<nav class="navbar navbar-expand-lg navbar-light bg-light" style="margin-bottom:50px"; >
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <a class="navbar-brand" href="#">Shikshika</a>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto"></ul>
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="studentinfo.jsp?student_id=<%=id%>">Student panel</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="log-out" >logout</a>
                </li>

            </ul>

        </div>
    </div>
</nav>

	<div class="container" style="margin-top:50px;background-color:#e3f2fd;padding:30px;">
	
		<div class="card-header my-3">All Courses</div>
		<div class="row" >
			<%
			List<Course> courses = AllocationDao.getAllallocatedCourses(id);
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
						<p><a class="btn btn-primary" href="CourseDetails.jsp?student_id=<%=id%>&cid=<%=p.getCid()%>">Details</a></p>
						
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