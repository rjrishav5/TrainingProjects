<%@page import="org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="com.springboot.model.Books" %>
<!DOCTYPE html>
<html>
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
  border-top: 2px solid blue;
   border-bottom:2px solid blue;
background-color: #bcc3f1ba;
    height: 80px;
}

.header{
    background-color:rgb(9, 212, 145);
    justify-content: center;
    color: whitesmoke
    
}

.form-group {
 
    width: 70%;}
    
.footer {
   border-bottom:2px solid blue;
     border-top: 2px solid blue;
 
   color: white;
   text-align: center;
   background-color: #bcc3f1ba;
   height: 60px;
      position: fixed;
   left: 0;
   bottom: 0;
   width: 100%;
   
}

label{
margin-left: 140px;
    margin-right: 170px;
}

</style>

</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
 
  
    <div style="margin-right:10px;">
    <span> </span> 
  <div class="float-right">
  
   <form action="/logoutUser" method="post">
    
    <button type="submit" class="btn btn-secondary btn-md float-right" style="padding-top: 0;margin-left: 1140px;" id="btnLogin"> Logout

</button>
</form>
</div>
</div></div>
  
  </div>
  
</nav>

     <%
      Books edit = (Books)request.getAttribute("edit");
  	String date = edit.getDateAdded();
  	System.out.println("date = "+date);
  	
  	Integer id=edit.getBookId();
  	System.out.println(id);
         %> 


<%--body --%>
<div class="container">
   <div class="text-center"style="margin-top:50px"> <h2>Edit Book Details</h2>
    </div>
    
 
            
   <%-- Product Specification form --%>
    
      <form name = "Form" action="/submitEdit" method="post"  class="form-horizontal" style="margin-top:60px;">
        <div class="form-group row has-success">
           <label class="control-label col-sm-2" for="id">Book Code</label>
            <div class="col-sm-5">
               <input class="title  form-control" readonly class="text"  id="Id" name="bookId" value="<%=edit.getBookId() %>" required >
            </div>
        </div>
        
        <div class="form-group row has-success">
            <label class="control-label col-sm-2 " for="Name">Book Name</label>
            <div class="col-sm-5">
                <input class="  quantity form-control " type="text" id="Name" name ="bookName" value= "<%= edit.getBookName() %>" required >
            </div>
        </div>
        <div class="form-group row has-success">
            <label class="control-label col-sm-2" for="author">Author</label>
            <div class="col-sm-3">
            
               
           <select id="author" name="authorName" style="width: 230px;">
           
            <option value="Andy Hunt">Andy Hunt</option>
  <option value="John Brown">John Brown</option>
  <option value="Mark Manson">Mark Manson</option>
  <option value="Paulo Coehlo">Paulo Coehlo</option>
  <option value="Robert Cecil">Robert Cecil</option>
 
</select>
            </div>
        </div> 
          <div class="form-group row has-success">
            <label class="control-label col-sm-2" for="date">	Added on</label>
            <div class="col-sm-5">
                  <input type="text" readonly class="form-control-plaintext" name="dateAdded" id="date" value="<%= date %>">
            </div>
        </div>
        
        
        <div style="margin-left:130px; margin-top:60px;">
         <button type="submit" class=" button btn-lg btn-danger" style="margin-right: 20px;"  value="Submit">Submit</button>
         <button type="button" class=" button btn-lg btn-primary "  value="Submit">cancel</button>
         
        </div>
        
         
          
          
       </form>
         
    
 </div>

	<div class="footer">
  <p></p>
</div>

</body>
</html>