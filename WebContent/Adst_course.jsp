<%@page import="com.shikshika.connection.DbCon"%>
<%@page import="com.shikshika.dao.StudentDao"%>
<%@page import="com.shikshika.dao.CourseDao"%>
<%@page import="com.shikshika.dao.AllocationDao"%>
<%@page import="com.shikshika.model.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


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
	<div class="card text-center">
	<%
String id = request.getParameter("student_id");
System.out.println(id);
String aid = request.getParameter("admin_id");
System.out.println(aid);
Student st = StudentDao.getstid(id);
System.out.println(st);
%>
		  <div class="card-body">
		    <h5 class="card-title"><%=id %></h5>
		    <p class="card-text"><%=st.getName() %></p>
		  </div>
	</div>
	</div>
	
	
	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">Allocate Course</div>
			<div class="card-body">
				<form action="allocatestudentcourse" method="post">
					<%
			    List<Course> cs = CourseDao.getAllCourses();
 				%>
 				 <div class="form-group" >
  								
  								<input type="hidden" id="student_id" name="student_id" value="<%=id%>">
                                <label>Select Course</label>
                                <select id="inputState" class="form-control" name="cid" required>
                                    <option >Allocate</option>
								 <%
									if (!cs.isEmpty()) 
									{
										for (Course p :cs) 
										{
									%>
                                    <option value=<%=p.getCid()%>><%=p.getName()%></option>
                                    <%
										}
									}
									%>
                                </select>
                </div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary">Add</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	

	<div class="container" style="margin-top:50px;background-color:white;padding:30px;">
	
		<div class="card-header my-3">All Courses</div>
		<div class="row" >
			<%
			List<Course> courses = AllocationDao.getAllallocatedCourses(id);
			if (!courses.isEmpty()) {
				for (Course p : courses) {
			%>
			
			
				<div class="card  text-center"  style="width: 18rem;margin-right:50px;margin-left:30px;">
				    <div class="embed-responsive embed-responsive-16by9">
    						 <img alt="Card image cap" class="card-img-top embed-responsive-item" src="course-images/<%=p.getImage()%>" />
  					</div>
					<div class="card-body" style="background-color:#e3f2fd;">
						<h5 class="card-title"><%=p.getName() %></h5>
						<h6 class="cid"><%=p.getCid() %></h6>
						<h6 class="category">Category: <%=p.getCategory() %></h6>
						<br>
						<p><a class="btn btn-primary" href="CourseDetails.jsp?cid=<%=p.getCid()%>&admin=<%=aid%>&student_id=<%=id%>">Details</a></p>
					</div>
					<div class="card-footer">
					<p><a class="btn btn-danger" href="delete-alloc?cid=<%=p.getCid()%>&student_id=<%=id %>">Remove</a></p>
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