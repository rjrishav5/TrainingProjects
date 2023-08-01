<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet" href="login.css">
<title>login</title>
<style>
.form-control {
	margin-bottom: 20px;
	    margin-left: 40px;
}

.card-header {
	background-color: #a5b7e2c2;
}

.card-body {
	background-color: aliceblue;
}

.btn {
	border: 1px solid #146195;
}

label {
	margin-right: 50px;
	padding-bottom: 20px;
}

.navbar {
	background-color: mediumpurple;
	height: 60px;
}


body{

background-color: #143d5b;
}
</style>


</head>
<body>


	<nav class="navbar navbar-expand-lg navbar-light navbar-laravel">
		<div class="container">
			<h1>Login</h1>



		</div>
	</nav>


	<div class="container">
		<div class="row">
			<div
				class="col-md-12 min-vh-100 d-flex flex-column justify-content-center">
				<div class="row">
					<div class="col-lg-6 col-md-8 mx-auto" style="margin-top: 5%;">


						<!-- form card login -->
						<div class="card rounded shadow shadow-sm"
							style="border: 1px solid mediumslateblue;   background-color: darkorchid;">
							<div class="card-header">
								<h3 class="mb-0">Login</h3>
							</div>
							<div class="card-body" style="background-color:cornflowerblue;">

						


								<%
								String alert = (String) session.getAttribute("message");
							
								if (alert != null) {
								%>

								<div class="alert alert-warning alert-dismissible fade show"
									role="alert">
									<strong><%=alert %></strong> 
								
									<button type="button" class="btn-close" data-bs-dismiss="alert"
										aria-label="Close"></button>
								</div>


								<%
								session.setAttribute("message", null);
								}
								%>
								<form action="loginAccess" class="form" role="form"
									autocomplete="off" id="formLogin" method="POST">
									<div class="form-inline">
										<label for="uname1">Username</label> <input type="text"
											class="form-control form-control-md   rounded-0"
											name="username" id="uname1" required>
										
									</div>
									<div class="form-inline">
										<label>Password</label> <input type="password"
											class="form-control form-control-md  rounded-0"
											name="password" id="pwd1" required
											autocomplete="new-password">
										
									</div>
									<div class="row mb-1 w-95 p-0">
										<div class="col-md">

											<button type="submit" class="btn btn-outline-primary btn-lg "
												id="btnLogin">Login</button>
										</div>

									</div>




								</form>
							</div>
						
						</div>
						

					</div>


				</div>
				<!--/row-->

			</div>
		
		</div>
		
	</div>

	<footer class="bg-light text-center text-lg-start fixed-bottom">
		<!-- Copyright -->
		<div class="text-center p-3" style="background-color: mediumpurple;">


		</div>
		<!-- Copyright -->
	</footer>
</body>
</html>