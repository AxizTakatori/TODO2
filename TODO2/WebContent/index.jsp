<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>TODO管理</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>

<!-- Plugin CSS -->
<link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/creative.min.css" rel="stylesheet">



<link href="css/commons.css" rel="stylesheet">




</head>

<body id="page-top">

		<c:if test="${not empty msg}">
			<p class = "error">${msg}</p>
		</c:if>

	<header class="masthead text-center text-white d-flex">
	<div class="container my-auto">
		<div class="row">
			<div class="col-lg-10 mx-auto">

				<h1>
					<strong>TODO管理</strong>



				</h1>
				<hr>
			</div>
			<div class="col-lg-8 mx-auto">
				<a class="btn btn-primary btn-xl js-scroll-trigger" href="#about">Login</a>
			</div>
		</div>
	</div>
	</header>
	<section class="bg-primary" id="about">
	<div class="container">
		<div class="wrapper">
			<form action="login" method="post" name="Login_Form"
				class="form-signin">
				<h3 class="form-signin-heading">
					<div class="col-lg-10 mx-auto">
						<h1>
							<strong>Welcome Back! Please Sign In</strong>
						</h1>
						<hr>
					</div>

				</h3>
				<hr class="colorgraph">
				<br> <input type="text" class="form-control" name="id"
					placeholder="Id" /> <input type="password" class="form-control"
					name="pass" placeholder="Password" />

				<button class="btn btn-lg btn-primary btn-block" name="Submit"
					value="Login" type="Submit">Login</button>

			</form>
		</div>
	</div>
	</section>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
	<script src="vendor/scrollreveal/scrollreveal.min.js"></script>
	<script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

	<!-- Custom scripts for this template -->
	<script src="js/creative.min.js"></script>

</body>

</html>