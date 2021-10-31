<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.shikshika.dao.CourseDao"%>
<%@page import="com.shikshika.model.*"%>
<%@page import="java.util.*"%>   

    
<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<body id="myPage"




%>
<!-- Sidebar on click -->

<nav class="w3-sidebar w3-bar-block w3-white w3-card w3-animate-left w3-xxlarge" style="display:none;z-index:2" id="mySidebar">
  <a href="javascript:void(0)" onclick="w3_close()" class="w3-bar-item w3-button w3-display-topright w3-text-teal">Close
    <i class="fa fa-remove"></i>
  </a>
  <a href="#" class="w3-bar-item w3-button">Link 1</a>
  <a href="#" class="w3-bar-item w3-button">Link 2</a>
  <a href="#" class="w3-bar-item w3-button">Link 3</a>
  <a href="#" class="w3-bar-item w3-button">Link 4</a>
  <a href="#" class="w3-bar-item w3-button">Link 5</a>
</nav>

<!-- Navbar -->

<div class="w3-top">

 <div class="w3-bar w3-light-grey w3-left-align">
  <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-hover-white w3-theme-d2" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
 <a href="#ab" class="w3-bar-item w3-button w3-hide-small w3-hover-white">About</a>
  <a href="#sy" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Syllabus</a>
  <a href="#mt" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Materials</a>
  <%
  	String pid = request.getParameter("student_id");
  	String aid = request.getParameter("admin_id");
  	System.out.println(pid);
     if((pid == null) && (aid == null))
       {
    %>
    <a href="course.jsp" class="w3-bar-item w3-button w3-hide-small w3-hover-white">All Courses</a>     
     <%
        }
     else if(aid != null)
     		{
     		%>	
     		<a href="studentinfo.jsp?student_id=<%= pid %>" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Student panel</a>
     		<a href="Mycourses.jsp?student_id=<%=pid%>" class="w3-bar-item w3-button w3-hide-small w3-hover-white">All Courses</a> 
     		<%
     		}
             else
             {	 
             %>
             <a href="Adst_course.jsp?student_id=<%=pid%>&admin_id=<%=aid%>" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Allocation Page</a>
    		<a href="Adminpanel.jsp?admin_id=<%=aid%>" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Admin Panel</a> 	
			<%
             }
             %>
  
   
 </div>


<!-- Image Header -->
<div class="w3-display-container "  >
  <img src="background.jpg" alt="boat" style="width:100%;min-height:350px;max-height:400px;">
  
 <div class="w3-container w3-display-middle ">  
    <div style="  text-align: center;
    background-color: white;
    background-size: 100%;
    color: black;
    font-family: Georgia, 'Times New Roman', Times, serif;">
    
    
    
    
        <%
			    String id = request.getParameter("cid");
			    Course cd = CourseDao.getDetailsCourse(id);
			    
 		%>
<h1><%=cd.getName()%></h1>
</div>
  </div>
  </div>




<!-- Team Container -->
<div class=" w3-padding-54 w3-center" id="team"><table>
<tr><table>
  <thead><h1 id="ab">About Course</h1></thead>
  <tbody><h4><%=cd.getAbt_course()%></h4></tbody></table></tr>
  <tr><table><thead><div style="padding-left: 10pt;"><br><p><h1  id="sy">Syllabus</h1></p></thead>
  
  <tbody>
          
          
          <h4><%=cd.getSyllabus()%></h4>
          </tbody>
          </table></tr><br>
          <tr><table>
         
            <div style=" margin-left: auto;
            margin-right: auto;"><thead>
                <h1 id="mt">Textbooks</h1></thead></div><tbody>
         
                <h4><%=cd.getTextbook()%></h4>
               
                
              </tbody></table></tr>
              
                <h4><tr><table style=" margin-left: auto;
                  margin-right: auto;"><thead><div >
                <p ><h1  id="re" style=" margin-left: auto;
                  margin-right: auto;">Reference</h1></p></div></thead>
              
              <tbody>
         
                <h4><%=cd.getRef()%></h4>
               
                
              </tbody>
                </table></tr> <br>
        <br>
                

</table>
</div>
          </div>


<!-- Footer -->
<footer >
    
  
</footer>

<script>
// Script for side navigation
function w3_open() {
  var x = document.getElementById("mySidebar");
  x.style.width = "300px";
  x.style.paddingTop = "10%";
  x.style.display = "block";
}

// Close side navigation
function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
}

// Used to toggle the menu on smaller screens when clicking on the menu button
function openNav() {
  var x = document.getElementById("navDemo");
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
  } else { 
    x.className = x.className.replace(" w3-show", "");
  }
}
</script>

</body>
</html>
