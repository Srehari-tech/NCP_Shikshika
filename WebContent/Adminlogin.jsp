<%@page import="com.shikshika.model.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

	


<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>

<style >


.login-page {
  width: 360px;
  padding: 8% 0 0;
  margin: auto;
}
.login-page .form .login{
  margin-top: -31px;
margin-bottom: 26px;
}
.form {
  position: relative;
  z-index: 1;
  background: #FFFFFF;
  max-width: 360px;
  margin: 0 auto 100px;
  padding: 45px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}
.form input {
  font-family: "Roboto", sans-serif;
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}
.form button {
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background-color: blue;
  background-image: linear-gradient(45deg,#1565c0, #f8bbd0);
  width: 100%;
  border: 0;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}


.container {
  position: relative;
  z-index: 1;
  max-width: 300px;
  margin: 0 auto;
}

.btn
{
	margin-top:60px;
	margin-left:200px;
}
body {
    background-image: url("background-1.jpg");
}

</style>
<title> Shikshika- Admin </title>

</head>

<body>
<div>
<a href="index.jsp" class="btn btn-light btn-lg"> <b>Home</b> </a>
</div>
<div>
    <div class="login-page">
      <div class="form">
        <div class="login">
          <div class="login-header">
            <h3>Welcome Admin</h3>
          </div>
        </div>
        <form class="login-form" action="admin-login" method="post">
          <input type="text" placeholder="Admin-id" name="login-admin_id" />
          <input type="password" placeholder="password" name="login-admin_password" />
          <button>login</button>
        </form>
      </div>
    </div>
</div>
</body>
</html>