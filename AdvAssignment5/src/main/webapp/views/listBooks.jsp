<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="com.springboot.model.Books" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<style>


.navbar{
background-color: #bcc3f1ba;
    height: 70px;
    border-bottom:2px solid blue;
    border-top: 2px solid blue;
}

.header{
    background-color:#b29fd3;
    justify-content: center;
    color: whitesmoke
    
}


.footer {
    border-top: 2px solid blue;
   
   
   height: 55px;
    position: fixed;
   color: white;
  
   background-color:#bdc4f0;
  
   left: 0;
   bottom: 0;
   width: 100%;
     border-bottom:2px solid blue;
}



.table-bordered td, .table-bordered th{
    border-color: black !important;
}



.form-group {
 
    width: 68%;}

body{
    background-color: whitesmoke;
}











</style>

<%
	String user = (String)session.getAttribute("username");
	System.out.println("username = " + user);
	if(user==null)
		response.sendRedirect("/login");
	
%>


<script type="text/javascript">
function Delete(id)
{

txt = confirm("Confirm Delete This Book ? ");


if(txt)
window.location = "http://localhost:1235/deleteBooks/"+id;
}
</script>
</head>
<body>


<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header" style="font-size: 30px;">
      <h1 class=" text-center" style="margin-left:470px;" >Book Manager</h1>
    </div>
  
    <div style="margin-right:12px;">
    <span style="  margin-right: 30px;    font-size: 25px; "> welcome <%=user %></span>
  <div class="float-right">
  
   <form action="logoutUser" method="post">
    
    <button type="submit" class="btn  btn-outline-primary btn-lg float-right" style="padding-top: 0;margin-top:5px;" id="btnLogin"> Logout

</button>
</form>
</div>
</div>

  
  </div>
  
</nav>


	<div class ="container-fluid">
		<div class = "row ">
		<div >
			<h4 style="margin-left:10px; margin-top:12px;"> Books Listing </h4>
			</div>
			<span class = "col-lg-1" style="   margin-top: 10px; margin-left: 800px;  ">
				
				<a href = "/addBooks" class = "btn btn-primary btn-md mb-3 "> Add a book</a>
			</span>
			
		</div>
		
		
		
		<table class = "table  table-bordered" style="    font-size: larger;" >
			<thead >
				<tr>
					<th> Book Code</th>
					<th> Book Name</th>
					<th> Author </th>
					<th> Date Added </th>
					<th> Action </th>
				</tr>
			</thead>
			
			<tbody>
			   <%
                	Books[] list = (Books[])request.getAttribute("list");
                	
                	for(Books book:list)
                	{
                		
                		Integer id = book.getBookId();
                	
                		String editBook = "edit/";
                     	
                %>
                <tr>
				         <td><%= book.getBookId() %></td>
                        <td> <%= book.getBookName() %> </td>
                        <td><%= book.getAuthorName() %></td>                        
                        <td><%=  book.getDateAdded() %></td>
                        <td>
                        
						<a href =<%=editBook + id %> title="edit"
						 class = "btn btn-lg btn-outline-secondary">Edit</a>
						
		
		 <a href =# onclick="Delete(<%=id %>);return false;"
class ="btn btn-lg btn-outline-danger" title="Delete">Delete</a>
						 
					</td>
				</tr>
				 <%
                	}
                    %>
			</tbody>
		
		</table>
		
	</div>
	
	
	<div class="footer">
  <p></p>
</div>


</body>
</html>