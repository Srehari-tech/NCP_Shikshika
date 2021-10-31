
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
			<div class="card-header text-center">Student Register</div>
			<div class="card-body">
				<form action="student-register" method="post">
					<div class="form-group">
						<label>Student-Roll number</label>
                        <input type="text" name="student_id" class="form-control" placeholder=" " pattern="{16}">
					</div>
                    <div class="form-group">
						<label>Name</label>
                        <input type="text" class="form-control" placeholder=""  name="name" />
					</div>
                    <div class="form-group">
						<label>Email</label>
                        <input type="email" class="form-control"  placeholder=""  name="email" />
					</div>

					<div class="form-group">
						<label>Password</label> 
						<input type="password" name="password" class="form-control" placeholder="Password">
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>
					<div class="text-center" style="text-align:center";>
					<p >Already a registered user? <a href="login.jsp">Login</a></p>
					</div>
					 

				</form>
			</div>
		</div>
	</div>

	<%@include file="/includes/footer.jsp"%>
</body>
</html>