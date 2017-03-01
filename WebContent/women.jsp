<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@page import="com.project.bean.Product"%>
<%@page import="javax.websocket.Session"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.project.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Gretong a Ecommerce Category Flat Bootstarp Responsive
	Website Template | Women :: w3layouts</title>
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
<script src="js/simpleCart.min.js">
	
</script>
</head>
<body>


	<!-- Load category list from database -->



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
						<a href="index.jsp"><span id="logo">Amazon Online Store</span></a>
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
	<!-- *************************************************************************************************** -->
	<!-- -->
	<!-- content -->
	<div class="container" style="margin-left: 130px;">
		<div class="women_main" style="margin-left: 50px;">
			<!-- *********************************************************************************************** -->


			<!-- start content -->
			<div class="col-md-9 w_content" style="margin-left: 0px;">
				<div class="women" style="margin-left: 0px;">
					<!-- Displaying the selected category and  the no  of product is present in it -->
					<!-- Getting the list of product in particular category -->
					<%-- 		<% ArrayList<Product> productList = (ArrayList) request.getAttribute("productList"); %> <%=productList.size() %>--%>
					<!-- <a href="#"><h4><%=request.getAttribute("SelectedCategory")%> - <span></span> </h4></a> -->

					<ul class="w_nav">
						<li>Sort :</li>

						<li><a class="active" href="#">popular</a></li>
						<li><a href="#">new </a></li>
						<li><a href="#">discount</a></li>
						<li><a href="#">price: Low High </a></li>
						<div class="clear"></div>
					</ul>
					<div class="clearfix"></div>
				</div>
				<!-- grids_of_4 -->
				<!-- 	<div class="grids_of_4"> -->

				
				<div class="items">
				<div style="width: 100%;">
					<!-- Run loop to display the products  -->
					<!-- Used jstl tag for loop and printing the object values -->
					
					<!-- Using table for formating display structure -->
					<table>
					<c:forEach items="${requestScope.productList}" var="product">
						<div class="grid1_of_4" style="margin-left: 8px;">
							<!-- div for product image -->
							<div class="content_box">
								<img src="images/1.jpg" class="img-responsive" alt="" />
								<h4>
									<a href="details.jsp"><c:out value="${product.name}"></c:out></a>
								</h4>
								<p></p>
								
								
								<!--  display the discription of item-->
								
								<div class="grid_1 simpleCart_shelfItem">
								Product Price
									<div class="item_add">
										<span class="item_price"><h6>
												<strike> <c:out value="${product.price}"></c:out></strike>
											</h6></span>
									</div>
								
									<div class="item_add">
										<span class="item_price"><h6>
												discount
												<c:out value="${product.discount}"></c:out>
											</h6></span>
									</div>
									
									
									<div class="item_add">
										<span class="item_price"><h6>
											
												<c:out value="${product.price * (100-product.discount)/100}"></c:out>
											</h6></span>
									</div>
									<div class="item_add">
										<span class="item_price"><h6>
												available quantity
												<c:out value="${product.quantity}"></c:out>
											</h6></span>
									</div>
									<div class="item_add">
										<!-- Creating form to take input quantity and send the value to controller -->
										<form action="InsertIntoCart" method="post">
											<input class="item_add" type="text"
												value="<c:out value="${product.productId}"></c:out>"
												name="pId" readonly> <input class="item_add"
												type="hidden"
												value="<c:out value="${product.quantity}" ></c:out>"
												name="originalQuantity" readonly> Enter Quantity<input type="number"
												name="quantity" placeholder="Enter Quantity" value="0" min="0" max="${product.quantity}"> <input
												type="submit" class="button button2" value="Add to Cart">
										</form>
									</div>
								</div>
							</div>
						</div>
						
					</c:forEach>
				</div>
				
				</div>
			</div>

			
				<!-- end content -->
			</div>
		</div>

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