<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="com.shikshika.connection.DbCon"%>
<%@page import="com.shikshika.dao.CourseDao"%>
<%@page import="com.shikshika.dao.FacultyDao"%>
<%@page import="com.shikshika.model.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
         <!-- Required meta tags -->
        
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

        <title>delete this faculty</title>
        <style>
            .inner{
                position: relative;
                margin: 0 auto;
                width: 650px;
                display: block;
                padding: 50px 0;
            }
            h3{
                text-align: center;
                border-bottom: 2px solid midnightblue;
                margin-bottom: 20px;
            }
            nav li a{
                font-size: 25px;
                font-weight: 500;
            }
            a{
                color: #fff;
                text-decoration: none;
            }
			         
			body {
			    background-image: url("background-1.jpg");
			}
			.btn
			{
			    
				  display: flex;
				  justify-content: center;
				  align-items: center;
				  margin:20px;
				  
			}


        </style>
    </head>
    <body>
       <div  class="container-fluid">
            <nav class="navbar navbar-light">
                <a class="navbar-brand">Shikshika</a>
                <ul class="navbar-nav ml-auto mt-3 mx-5">
                        <li class="nav-item">
                            <a class="nav-link active" href="admin_page.jsp">Home</a>
                        </li>
                </ul>
            </nav>
        </div>
        <%
			    String id = request.getParameter("faculty_id");
        		Faculty cd = FacultyDao.getSingleFaculty(id);
        		System.out.println(id);
   
 		%>
<div class="inner">
            <div class=" container">
            <div class="card" style="background-color:white;">
                <div class="row" style="padding:30px;" >
                    <div class="col-12">
                        <h3>Are you sure you want to delete this faculty?</h3>
                <form action="delete-faculty" method="post">

              
                            <div class="form-group">
                                <label>ID</label>
                                <input class="form-control" name="faculty_id" value="<%=id%>" readonly>
                            </div>
                           <div class="form-group">
                                <label>Faculty Name</label>
                                <input class="form-control" name="faculty_name" value="<%=cd.getName()%>"  readonly>
                            </div>
            

                <div class="form-group" >
  
                                <label>Course Allocated</label>
                                <select id="inputState" class="form-control" name="cid" readonly>
                                    <option ><%=cd.getCourseId()%></option>          
                                </select>
                </div>
                <div class="form-group">
                                <label>Password</label>
                                <input class="form-control" name="password" value="<%=cd.getPassword()%>" readonly>
                </div>
                <div class="btn">
                
                            <button type="submit" class="btn btn-primary">Delete</button>
                            <button  class="btn btn-primary"><a href="Facultylist.jsp">Cancel</a></button>
                </div>
               </form>
</div>
</div>
</div>
</div>
</div>
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        
    </body>
</html>

