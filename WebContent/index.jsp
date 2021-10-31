<%@page import="com.shikshika.connection.DbCon"%>
<%@page import="com.shikshika.dao.StudentDao"%>
<%@page import="com.shikshika.dao.AdminDao"%>
<%@page import="com.shikshika.model.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>




<!DOCTYPE html>
<html>

<head>
<%@include file="/includes/head.jsp"%>
<link rel="icon" href="team-images/favicon.ico">
<style>

.footer-copyright
{
margin-top: 150px;


}
body {


    background-image: url("background-1.jpg");
}


</style>

<title>Shikshika</title>
</head>
<body >

	<%@include file="/includes/navbar.jsp"%>
<div class="jumbotron text-center" style=" margin-top:100px;">
    <h1 class="display-5">Shikshika</h1>
    <p>Online Course Website</p>
</div>
<section class="clean-block about-us" style="background:#e3f2fd;" id="about">
            <div class="container">
                <div class="block-heading">
                    <br>
                    <h2 class="text-info text-center">About Us</h2>
                    <p>We provide you the one stop solution portal for all your educational requirements, whether you're a pupil or master, we make your life and learning easier.</p>
                </div>
                <hr>
                
                <section class="team-grid">
                    <div class="container" style="background: rgb(246,246,246);">
                        <div class="intro">
                            <h2 class="text-center">Team </h2>
                            <p class="text-center">Meet our team that made this project possible.&nbsp; </p>
                        </div>
                <div class="row">      
              <div class="col-sm-4" >
                <div class="card  text-center" >
				    <div class="embed-responsive embed-responsive-16by9">
    						 <img alt="Card image cap" class="card-img-top embed-responsive-item" src="team-images/me.jpg" />
  					</div>
  					
					<div class="card-body">
						<h5 class="card-title">Ashwin Nair</</h5>
					</div>
				</div>
				</div>
				
				
				<div class="col-sm-4" style="width:10rem;">
				 <div class="card  text-center" >
				    <div class="embed-responsive embed-responsive-16by9">
    						 <img alt="Card image cap" class="card-img-top embed-responsive-item" src="team-images/adarsh.jpg" />
  					</div>
					<div class="card-body">
						<h5 class="card-title">Adarsh MS</</h5>
					</div>
				</div>
				</div>
				
				
				  <div class="col-sm-4" style="width:10rem;">
				 <div class="card  text-center"  >
				    <div class="embed-responsive embed-responsive-16by9">
    						 <img alt="Card image cap" class="card-img-top embed-responsive-item" src="team-images/niranjana.jpg" />
  					</div>
					<div class="card-body">
						<h5 class="card-title">Niranjana Ashok</</h5>
					</div>
				</div>
				</div>
				
				  <div class="col-sm-4" style="margin-top: 40px;margin-left: 120px;">
				<div class="card  text-center">
				    <div class="embed-responsive embed-responsive-16by9">
    						 <img alt="Card image cap" class="card-img-top embed-responsive-item" src="team-images/niranjana2.jpg" />
  					</div>
					<div class="card-body">
						<h5 class="card-title">Niranjana Sunish</</h5>
					</div>
				</div>
				</div>
				
				 <div class="col-sm-4" style="margin-top: 40px;margin-left: 120px;">
				<div class="card  text-center" >
				    <div class="embed-responsive embed-responsive-16by9">
    						 <img alt="Card image cap" class="card-img-top embed-responsive-item" src="team-images/howdy.jpg" />
  					</div>
					<div class="card-body">
						<h5 class="card-title">Sre Hari</</h5>
					</div>
				</div>
				</div>
                   </div> 
                </section>

 
 
   

 <div class=footer-copyright>
        <nav class="navbar navbar-expand-lg navbar-light bg-light-grey">
        
   <p style="margin:auto;padding-bottom:16px;">&copy;2021 Copyright Shikshika</p>
  
   </nav>    
 </div>
	

 
</body>

</html>