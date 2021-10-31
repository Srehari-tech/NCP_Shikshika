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
<title>Sikshika</title>
</head>
<body>
   <%@include file="/includes/navbar.jsp"%>
	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">Student Login</div>
			<div class="card-body">
				<form action="student-login" method="post">
					<div class="form-group">
						<label>Student Identification Number</label> 
						<input type="text" name="login-student_id" class="form-control" placeholder="Enter roll number" max=15">
					</div>
					<div class="form-group">
						<label>Password</label> 
						<input type="password" name="login-password" class="form-control" placeholder="Password">
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary">Login</button>
					</div>
					 <p class="message">Not registered? <a href="StudentRegister.jsp">Create an account</a></p>
				</form>
			</div>
		</div>
	</div>

	<%@include file="/includes/footer.jsp"%>
</body>
</html>