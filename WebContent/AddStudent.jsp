<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.shikshika.connection.DbCon"%>
<%@page import="com.shikshika.dao.CourseDao"%>
<%@page import="com.shikshika.dao.FacultyDao"%>
<%@page import="com.shikshika.dao.StudentDao"%>
<%@page import="com.shikshika.model.*"%>
<%@page import="java.util.*"%>





<!doctype html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <title>Document</title>
    <style>
body {
    background-image: url("background-1.jpg");
}

.inner{
                position: relative;
                margin: 0 auto;
                width: 500px;
                display: block;
                padding-bottom: 50px;
                padding-bottom: 50px;
				background-color:white;
				}
				
				.btn
			{
			    
				  
				  align-items: center;
				  margin-left:10px;
				   margin-right:100px;
				  
			}
				

</style>
</head>

<body>

<div class="inner">
<div class="container"  >
<div class="jumbotron text-center">
    <h3 class="display-9">Add Student</h3>
</div>
  
   
    <form  method="post" action="add-student" >
        <div class="row">
            <div class="col-sm-10" style="margin-left:auto;margin-right: auto;">

               
                <div class="form-group">
                    <label for="faculty_id">Student Id</label>
                    <input type="text" class="form-control" pattern="{16}" required  name="student_id" id="student_id" placeholder="Enter student roll number">

                </div>
                
       
                <div class="form-group">
                    <label for="facultyname">Student Name</label>
                    <input type="text" class="form-control"  name="name" id="name"
                           placeholder="Name">
                </div>
             
            
            <div>
                <button type="submit" class="btn btn-primary">Submit</button>
                <button type="submit" class="btn btn-warning" style="text-color:black;"><a href="StudentList.jsp">Cancel</button>
            </div>
        </div>
         </div>
         
    </form>
</div>
</div>


</body>
</html>