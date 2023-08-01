<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="com.springboot.model.Books" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>


<style>
.navbar{

 border-bottom:2px solid blue;
     border-top: 2px solid blue;
background-color: #bcc3f1ba;
    height: 80px;
}

.header{
    background-color:rgb(9, 212, 145);
    justify-content: center;
    color: whitesmoke
    
}


    
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
  ;
  
}



body {
    color: #566787;
    background: #f5f5f5;
    font-family: 'Varela Round', sans-serif;
    font-size: 16px;
}

.table-wrapper {
  
    background: #fff;
    padding: 20px 25px;
    border-radius: 3px;
   
}
.table-title {
    padding-bottom: 15px;
    background: #808080;
    color: #fff;
    padding: 16px 30px;
    margin: -20px -25px 10px;
    border-radius: 3px 3px 0 0;
}
.table-title h2 {
    margin: 5px 0 0;
    font-size: 24px;
}
.table-title .btn {
    color: #566787;
    float: right;
    font-size: 13px;
    background: #fff;
    border: none;
    min-width: 50px;
    border-radius: 2px;
    border: none;
    outline: none !important;
    margin-left: 10px;
}
.table-title .btn:hover, .table-title .btn:focus {
    color: #566787;
    background: #f2f2f2;
}
.table-title .btn i {
    float: left;
    font-size: 21px;
    margin-right: 5px;
}
.table-title .btn span {
    float: left;
    margin-top: 2px;
}
table.table tr th, table.table tr td {
    border-color: #e9e9e9;
    padding: 12px 15px;
    vertical-align: middle;
}
table.table tr th:first-child {
    width: 100px;
}
table.table tr th:last-child {
    width: 100px;
}

table.table-striped.table-hover tbody tr:hover {
    background: #f5f5f5;
}
table.table th i {
    font-size: 13px;
    margin: 0 5px;
    cursor: pointer;
}	
table.table td:last-child i {
    opacity: 0.9;
    font-size: 22px;
   
}
table.table td a {
    font-weight: bold;
    color: #566787;
    display: inline-block;
    text-decoration: none;
}
table.table td a:hover {
    color: #2196F3;
}
table.table td a.settings {
    color: #2196F3;
}
table.table td a.delete {
    color: #F44336;
}
table.table td i {
    font-size: 19px;
}

.status {
    font-size: 30px;
    margin: 2px 2px 0 0;
    display: inline-block;
    vertical-align: middle;
    line-height: 10px;
}
.text-success {
    color: #10c469;
}
.text-info {
    color: #62c9e8;
}
.text-warning {
    color: #FFC107;
}
.text-danger {
    color: #ff5b5b;
}

.hint-text {
    float: left;
    margin-top: 10px;
    font-size: 13px;
}




</style>
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
<!--       <h1 class="navbar-brand text-cente" style="margin-left:470px;" >Add</h1> -->
    </div>
  
    <div style="margin-right:10px;">
    <span> </span> 
  <div class="float-right">
  
   <form action="logoutUser" method="post">
    
    <button type="submit" class="btn btn-secondary btn-md float-right" style="padding-top: 0;" id="btnLogin"> Logout

</button>
</form>
</div>
</div>

  
  </div>
  
</nav>

<!-- to get current date  -->


<%--body --%>
<div class="container">
   <div class="text-center"style="margin-top:50px"> <h2>Edit Book Details</h2>
    </div>
    
 
            
   <%-- Product Specification form --%>
    
      <form name = "Form" action="/submitEdit" method="post"  class="form-horizontal" style="margin-top:60px;">
        <div class="form-group row has-success">
           <label class="control-label col-sm-2" for="id">Book Code</label>
            <div class="col-sm-5">
               <input class="title  form-control"  class="text"  id="Id" name="bookId"  required >
            </div>
        </div>
        
        <div class="form-group row has-success">
            <label class="control-label col-sm-2 " for="Name">Book Name</label>
            <div class="col-sm-5">
                <input class="  quantity form-control " type="text" id="Name" name ="bookName"  required >
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
                  <input type="text" readonly class="form-control-plaintext" name="dateAdded" id="currentdate" ">
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
    

	<div class="footer">
  <p></p>
</div>
</body>
<script>
	
var d = new Date();
var date = d.getDate();
var month= d.getMonth();
var monthName=new Array(12)





monthName[0]="January";
monthName[1]="February";
monthName[2]="March";
monthName[3]="April";
monthName[4]="May";
monthName[5]="June";
monthName[6]="July";
monthName[7]="August";
monthName[8]="September";
monthName[9]="October";
monthName[10]="November";
monthName[11]="December";


document.getElementById("currentdate").value = date +" "+ monthName[month] + " " + d.getFullYear();
System.out.println(monthName[0]);

System.out.println(monthName[1]);

System.out.println(monthName[2]);



</script>

</html>