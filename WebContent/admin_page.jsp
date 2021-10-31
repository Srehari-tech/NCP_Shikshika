<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.shikshika.connection.DbCon"%>
<%@page import="com.shikshika.dao.CourseDao"%>
<%@page import="com.shikshika.dao.CategoryDao"%>
<%@page import="com.shikshika.model.*"%>
<%@page import="java.util.*"%>


  <%
 								
     List<Course> courses = CourseDao.getAllCourses();
      %>

<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
         
        <meta http-equiv="Content-Type" name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

        <title>Shikshika</title>
         
         <script>
         
         
         
         function submitClick()
         {
            let input = document.getElementById('cid').value;
            let input2= document.getElementById('name').value;
            input=input.toString();
            inpu2=input2.toString();
            
             if(input.length <8)
            	 {
            	 alert("coursecode cannot be less than 8 characters");
            	 return false;
            	 }
             else if(input.length >8)
            	 {
            	 alert("coursecode cannot be more than 8 characters");
            	 }
             else if(input2.length <2)
        	 {
        	 alert("coursename cannot be one character");
        	 }
             
             
        }
        </script>
        
        <style>
            .inner{
                margin: 15px 0;
                
                
				  
            }
           .container { 
					  
					  padding: 10px;
					  background-colour:white;
					 
					}
					
					body {
   background-image: url("background-1.jpg");
}
					
            
            
        </style>
        <%@include file="/includes/navbar.jsp"%>
    </head>
    <body>
        
<div class="container">
            <div class="inner">
               <div class="card" style="background-color:white;">
               <div class="row" style="padding:30px;">
                    <div class="col-md-3" >
                        <h3>Add Course</h3>

                        <form name="addform" action="add-course" method="post"  enctype="multipart/form-data">
                            <div class="form-group">
                                <label>Course Code</label>
                                <input class="form-control" id="cid" name="cid" place-holder="Course Code" minlength="8" maxlength="8" pattern="[A-Z,0-9]{1,8}" required>
                            </div>
                            <div class="form-group">
                                <label>Course Name</label>
                                 <input class="form-control" id="name" name="name" place-holder="Course Name" minlength="2" required>
							 </div>
                            
                            
                           	 <%    
						                List<Category> listCategory = CategoryDao.getAllCategory();
						            
						 		%>
                            
                            <div class="form-group" >
  
                                <label>Category</label>
                                <select id="inputState" class="form-control" name="cat_id" required>
                                    <option value="">Choose Semester</option>
						         <%
									if (! listCategory.isEmpty()) 
									{
										for (Category p : listCategory) 
										{
									%>
                                    <option value=<%=p.getId()%>>Semester <%=p.getId()%></option>
                                    <%
										}
									}
									%>
                                </select>
               				 </div>

                            
							  <div class="form-group" >
							  <p>Image</p>
							   <div class="custom-file ">
							      <input type="file" class="custom-file" value="upload" id="cimage" name="cimage">				      
							    </div>
							    </div>
							    
				
							 
							<br>
							
                            <button type="submit"  class="btn btn-primary" onClick="submitClick( )">Submit</button>
                            <button type="reset" class="btn btn-primary">Reset</button>
                            <br>
                        </form>
                    </div>



                <div class="col-md-9">
                    <h3>Course Details</h3>
                        <table class="table">
                            <thead class="bg-light">
                                <tr>
                                    <th scope="col">Course Code</th>
                                    <th scope="col">Course Name</th>
                                    <th scope="col">Category</th>
                                    <th scope="col">Image</th>
                                    <th scope="col"></th>
                                    <th scope="col"></th>
                                    
                                </tr>
                            </thead>
                                 <tbody>
                                
								 <%
			if (!courses.isEmpty()) {
				for (Course p : courses) {
			%>
			<tr>
								    <td><%=p.getCid() %></td>
									<td><%=p.getName() %></td>
									<td><%=p.getCategory() %></td>
									<td><img src="course-images/<%=p.getImage()%>"alt="" border=3 height=100 width=100></img></td>
									<td><a href="course_edit.jsp?cid=<%=p.getCid()%>" class="btn btn-primary">Edit</a></td>
									<td><a href="course_delete.jsp?cid=<%=p.getCid()%>" class="btn btn-danger">Delete</a></td>
							</tr>	
								
								
								 <%
				}
			}
			%> 
                            <tbody>
                                 
                            </tbody>
                        </table>
</div>
</div>
               </div>
                
</div>
</div>

        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    </body>
</html>

