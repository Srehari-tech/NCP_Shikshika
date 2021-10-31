<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.shikshika.connection.DbCon"%>
<%@page import="com.shikshika.dao.CourseDao"%>
<%@page import="com.shikshika.dao.StudentDao"%>
<%@page import="com.shikshika.model.*"%>
<%@page import="java.util.*"%>




<!DOCTYPE html>
<html>
    <head>
        
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

        <title>Edit Profile</title> 
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
       
        <%
			    String id = request.getParameter("student_id");
			    Student st = StudentDao.getstid(id);
 		%>
<div class="inner">
            <div class=" container">
                <div class="card" style="background-color:white;">
                <div class="row" style="padding:30px;" >
                    <div class="col-12">
                        <h3>Update your profile here</h3>
                <form action="update-profile" method="post">
                            
              
                            <div class="form-group">
                                <label>Student Id</label>
                                <input class="form-control" name="student_id" value="<%=st.getStudent_id()%>" readonly>
                            </div>
                           <div class="form-group">
                                <label>Name</label>
                                <input class="form-control" name="name" value="<%=st.getName()%>"  required>
                            </div>
            

                <div class="form-group">
                                <label>Email</label>
                                <input class="form-control" name="email" value="<%=st.getEmail()%>">
                 </div>
                 <div class="form-group">
                                <label>Password</label>
                                <input class="form-control" name="password" value="<%=st.getPassword()%>">
                 </div>
             
                
                <div class="btn">
                
                            <button type="submit" class="btn btn-primary">Submit</button>
                            <button  class="btn btn-primary"><a href="studentinfo.jsp">Cancel</a></button>
                </div>
                
                            
               </form>
</div>
</div>
</div>
</div>
</div>
        
    </body>
</html>

