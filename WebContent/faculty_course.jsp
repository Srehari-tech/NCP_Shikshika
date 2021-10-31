<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="com.shikshika.dao.CourseDao"%>
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
 </style>
     <%@include file="/includes/navbar.jsp"%>
</head>
<body>
    
   
    <%
			    String id = request.getParameter("cid");
   				System.out.println(id);
			    Course cd = CourseDao.getDetailsCourse(id);
			    System.out.println(cd);
 	%>
 		
<br>

<div class="container"  style="background-color: azure;">
    <h1 style="font-weight: lighter; ">Update Course</h1><br>
    <form action="update-course" method="post">
        <div class="row">
            <div class="col-sm-10">

                <div class="form-group">
                    <label for="cid">Course Code</label>
                    <input type="text" class="form-control" value="<%=id%>" name="cid" id="cid"  readonly>
                </div>
                
             <div class="form-group">
                    <label for="name">Course Name</label>
                    <input type="text" class="form-control" value="<%=cd.getName()%>" name="name" id="name"  readonly>
                </div>
             
                
                <div class="form-group">
                    <label for="cat_id">Semester</label>
                    <input type="text" class="form-control" value="<%=cd.getCategory()%>" name="cat_id" id="cat_id" readonly>
                    
                </div>
                <input type="hidden" id="image" name="image" value="<%=cd.getImage()%>"">
               
                
                <div class="form-group">
                    <label for="abt_course">About Course</label>
                     
                    <input class="form-control" rows="5" value=" <%=cd.getAbt_course()%>"  name="abt_course" id="abt_course">
                </div>
                
                <div class="form-group">
                    <label for="syllabus">Syllabus</label>
                    <input class="form-control" rows="5" value="<%=cd.getSyllabus()%>" name="syllabus" id="syllabus">
                </div>
                
                <div class="form-group">
                    <label for="textbook">Textbook</label>
                    <input class="form-control" rows="5" value="<%=cd.getTextbook()%>" name="textbook" id="textbook">
                </div>
                <div class="form-group">
                    <label for="ref">Web Reference</label>
                    <input class="form-control" rows="5" value="<%=cd.getRef()%>" name="ref" id="ref">
                </div>
<button type="submit" class="btn btn-primary">Submit</button>
            </div>
           
               
    </form>
     
            
</div>


<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
<script>
    function readURL(input){
        if(input.files && input.files[0]){
            var reader = new FileReader();
            reader.onload = function(e){
                $('#imgPreview').attr('src', e.target.result).width(100).height(100);
            }
            reader.readAsDataURL(input.files[0])
        }
    }
    $('#productImage').change(function(){
        readURL(this);
    });
    $(".custom-file-input").on("change", function() {
        var fileName = $(this).val().split("\\").pop();
        $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
    });
</script>
</body>
</html>