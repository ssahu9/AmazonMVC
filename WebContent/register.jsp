<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.project.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Gretong a Ecommerce Category Flat Bootstarp Responsive
	Website Template | Register :: w3layouts</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary JavaScript plugins) -->
<script type='text/javascript' src="js/jquery-1.11.1.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/table.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Gretong Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Playfair+Display:400,700,900'
	rel='stylesheet' type='text/css'>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>
	$(document).ready(function() {
		$(".megamenu").megamenu();
	});
</script>
<script src="js/menu_jquery.js"></script>
</head>
<body>


	<!-- Load category list from database 
	<jsp:include page="/AvailableCategory" />-->

	<!-- header_top -->
	<div class="top_bg">
		<div class="container">
			<div class="header_top">
				<div class="top_right">
					<ul>
						<li><a href="#">help</a></li>|
						<li><a href="#">Contact</a></li>|
						<li><a href="CallErrorPageServlet">Delivery information</a></li>
					</ul>
				</div>
				<div class="top_left">
					<h2>
						<span></span> Call us : 032 2352 782
					</h2>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- header -->
	<div class="header_bg">
		<div class="container">
			<div class="header">
				<div class="head-t">
					<div class="logo">
						<a href="index.jsp"><span id="logo">Amazon Online Store</span> </a>
					</div>
					<!-- start header_right -->
					<div class="header_right">
						<div class="rgt-bottom">
							<!-- Session check -->
							<!-- Providing login and register option  only if user variable is exit in session scope -->
							<c:if test="${sessionScope.email == null}">

								<div class="log">
									<div class="login">
										<div id="loginContainer">
											<a href="#" id="loginButton"><span>Login</span></a>
											<div id="loginBox">
												<!-- Insert target jsp page -->
												<form id="loginForm" action=".\LoginServlet" method="post">
													<fieldset id="body">
														<fieldset>
															<label for="email">Email Address</label> <input
																type="text" name="email" id="email">
														</fieldset>
														<fieldset>
															<label for="password">Password</label> <input
																type="password" name="password" id="password">
														</fieldset>
														<input type="submit" id="login" value="Sign in"> <label
															for="checkbox"><input type="checkbox"
															id="checkbox"> <i>Remember me</i></label>
													</fieldset>
													<!-- <span><a href="#">Forgot your password?</a></span>-->
												</form>
											</div>
										</div>
									</div>
								</div>
								<div class="reg">
									<a href="register.jsp">REGISTER</a>
								</div>
							</c:if>
							<!--  Link for signout  only if user variable is not exit in session scope -->
							<c:if test="${sessionScope.email != null}">
								<div class="reg">
									<a href="register.jsp">LOGOUT</a>
								</div>
								
								<!--  Link for profile information updation  -->
								<div class="log" style="margin-left: 0px;">
									<a href="UpdateCustomerProfile.jsp">UPDATE PROFILE</a>
								</div>
								
							</c:if>
							<div class="create_btn">
								<a href="CheckoutServlet">CHECKOUT</a>
							</div>
							<div class="clearfix"></div>
						</div>

						<div class="cart box_1">
							<a href="checkout.jsp">
								<h3>
									<span></span>
								</h3>
							</a>
							<p>
								<a href="javascript:;" class="simpleCart_empty"></a>
							</p>
							<div class="clearfix"></div>
						</div>



						<div class="search">
							<form action="SearchProductServlet">
								<input type="text" value="" placeholder="search..."> <input
									type="submit" value="">
							</form>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="clearfix"></div>
				</div>


					<!-- start header menu -->
				<!-- Category bar -->
				<ul class="megamenu skyblue">
					<li class="active grid"><a class="color1" href="index.jsp">Home</a></li>
					<li class="grid"><a class="color1"  href="GetProducts">ALL</a></li>
				<c:forEach items="${applicationScope['categoryList']}"
						var="category">
						<li class="grid"><a class="color6"  href="GetProducts?selectedCategory=${category.categoryName}">${category.categoryName}</a></li>
						</c:forEach>


				</ul>
				<!-- End of Header Menu -->
			</div>
		</div>
	</div>
	<!-- content -->
	<div class="container">
		<div class="main">
			<!-- start registration -->
			<div class="registration">
				<div class="registration_left">
					<h2>
						new user? <span> create an account </span>
					</h2>
					<!-- [if IE] 
		    < link rel='stylesheet' type='text/css' href='ie.css'/>  
		 [endif] -->

					<!-- [if lt IE 7]>  
		    < link rel='stylesheet' type='text/css' href='ie6.css'/>  
		<! [endif] -->
					<script>
						(function() {

							// Create input element for testing
							var inputs = document.createElement('input');

							// Create the supports object
							var supports = {};

							supports.autofocus = 'autofocus' in inputs;
							supports.required = 'required' in inputs;
							supports.placeholder = 'placeholder' in inputs;

							// Fallback for autofocus attribute
							if (!supports.autofocus) {

							}

							// Fallback for required attribute
							if (!supports.required) {

							}

							// Fallback for placeholder attribute
							if (!supports.placeholder) {

							}

							// Change text inside send button on submit
							var send = document
									.getElementById('register-submit');
							if (send) {
								send.onclick = function() {
									this.innerHTML = '...Sending';
								}
							}

						})();
					</script>
					<div class="registration_form">
						<!-- Form -->
						<form id="registration_form" action="Register" method="post">
							<div>
								<label> <input placeholder="first name:" type="text"
									pattern=^[a-zA-Z]{1,20}$ tabindex="1" name="fname" required
									autofocus>
								</label>
							</div>
							<div>
								<label> <input placeholder="last name:" type="text"
									tabindex="2" pattern=^[a-zA-Z]{1,20}$ name="lname" required
									autofocus>
								</label>
							</div>
							<div>
								<label> <input placeholder="email address:" type="email"
									name="email" tabindex="3" required>
								</label>
							</div>
							<div>
								<label> <input placeholder="number" type="tel"
									name="phone" pattern=^[7-9][0-9]{9}$ tabindex="3" required>
								</label>
							</div>
						
							<div>
								<label> <input placeholder="password" type="password"
									pattern=^[a-zA-Z][a-zA-Z0-9-_\.]{7,20}$ name="pwd" tabindex="4"
									required>
								</label>
							</div>
							<div>
								<label> <input placeholder="retype password"
									type="password" pattern=^[a-zA-Z][a-zA-Z0-9-_\.]{7,20}$
									name="rpwd" tabindex="4" required>
								</label>
							</div>
							<div>
								<input type="submit" value="create an account"
									id="register-submit">
							</div>
						</form>
						<!-- /Form -->
					</div>
				</div>
				<div class="registration_left">
					<h2>existing user</h2>
					<div class="registration_form">
						<!-- Form -->
						<form id="registration_form" action=".\LoginServlet" method="post">
							<div>
								<label> <input placeholder="email:" name="email"
									type="email" tabindex="3" required>
								</label>
							</div>
							<div>
								<label> <input placeholder="password" name="password"
									type="password" tabindex="4" required>
								</label>
							</div>
							<div>
								<input type="submit" value="sign in" id="register-submit">
							</div>
							<div class="forget">
								<a href="#">forgot your password</a>
							</div>
						</form>
						<!-- /Form -->
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<!-- end registration -->
		</div>
	</div>
	<!-- Foot top section (Follow us on) -->
	<div class="foot-top">
		<div class="container">
			<div class="col-md-6 s-c">
				<li>
					<div class="fooll">
						<h5>follow us on</h5>
					</div>
				</li>
				<li>
					<div class="social-ic">
						<ul>
							<li><a href="CallErrorPageServlet"><i class="facebok"> </i></a></li>
							<li><a href="CallErrorPageServlet"><i class="twiter"> </i></a></li>
							<li><a href="CallErrorPageServlet"><i class="goog"> </i></a></li>
							<li><a href="CallErrorPageServlet"><i class="be"> </i></a></li>
							<li><a href="CallErrorPageServlet"><i class="pp"> </i></a></li>
							<div class="clearfix"></div>
						</ul>
					</div>
				</li>
				<div class="clearfix"></div>
			</div>
			<div class="col-md-6 s-c">
				<div class="stay">
					<div class="stay-left">
						<form>
							<input type="text"
								placeholder="Enter your email to join our newsletter"
								required="">
						</form>
					</div>
					<div class="btn-1">
						<form>
							<input type="submit" value="join">
						</form>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- End of Foot top section (Follow us on) -->

	<!-- Footer Section -->
	<div class="footer">
		<div class="container">
			<div class="col-md-3 cust">
				<h4>CUSTOMER CARE</h4>
				<li><a href="CallErrorPageServlet">Help Center</a></li>
				<li><a href="CallErrorPageServlet">FAQ</a></li>
				<li><a href="CallErrorPageServlet">How To Buy</a></li>
				<li><a href="CallErrorPageServlet">Delivery</a></li>
			</div>
			<div class="col-md-2 abt">
				<h4>ABOUT US</h4>
				<li><a href="CallErrorPageServlet">Our Stories</a></li>
				<li><a href="CallErrorPageServlet">Press</a></li>
				<li><a href="CallErrorPageServlet">Career</a></li>
				<li><a href="CallErrorPageServlet">Contact</a></li>
			</div>
			<div class="col-md-2 myac">
				<h4>MY ACCOUNT</h4>
				<li><a href="register.jsp">Register</a></li>
				<li><a href="CheckoutServlet">My Cart</a></li>
				<li><a href="./CustomerAllBill">Bill History</a></li>
				<li><a href="CheckoutServlet">Payment</a></li>
			</div>
			<div class="col-md-5 our-st">
				<div class="our-left">
					<h4>OUR STORES</h4>
				</div>
				<div class="clearfix"></div>
				<li><i class="add"> </i>Jl. Haji Muhidin, Blok G no.69</li>
				<li><i class="phone"> </i>025-2839341</li>
				
			</div>
			<div class="clearfix"></div>
			<p>
				Copyrights © 2015 Gretong. All rights reserved | Template by <a
					href="http://w3layouts.com/">W3layouts</a>
			</p>
		</div>
	</div>
	<!-- End of Footer section -->
</body>
</html>