<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<link href="<c:url value='/static/css/bootstrap.css' />" rel='stylesheet' type='text/css' />

<!-- jQuery (necessary JavaScript plugins) -->
<script src="<c:url value="/static/js/jquery-1.11.1.min.js" />"></script>
<!-- Custom Theme files -->
<link href="<c:url value='/static/css/style.css' />" rel='stylesheet' type='text/css' />
<link href="<c:url value='/static/css/table.css' />" rel='stylesheet' type='text/css' />

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
<link href="<c:url value='/static/css/megamenu.css' />" rel='stylesheet' type='text/css'  media="all" />

<script src="<c:url value="/static/js/megamenu.js" />"></script>

<script>
	$(document).ready(function() {
		$(".megamenu").megamenu();
	});
</script>
<script src="<c:url value="/static/js/megamenu.js" />"></script>
<script src="<c:url value="/static/js/simpleCart.min.js" />"></script>

	
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
						<li class="grid"><a class="color6"  href="./getProducts?category=${category.categoryName}">${category.categoryName}</a></li>
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
							<%! String path= "images/"; %>
							<%! String ext =".jpg"; %>
								<img style="idth:"100px" height="100px" src="${product.productId}" class="img-responsive" alt="" />
								<h4>
								<span class="mycss"><c:out   value="${product.name}"></c:out></span>	
								</h4>
								<p></p>
								
								
								<!--  display the discription of item-->
								
								<div class="grid_1 simpleCart_shelfItem">
								<span class="mycss">Product Price</span>
									<div class="item_add">
										<span class="item_price"><h6>
												<span class="mycss"><strike> <c:out value="${product.price}"></c:out></strike></span>
											</h6></span>
									</div>
								
									<div class="item_add">
										<span class="item_price"><h6>
												<span class="mycss">discount</span>
												<span class="mycss"><c:out value="${product.discount}"></c:out>%</span>
											</h6></span>
									</div>
									
									
									<div class="item_add">
										<span class="item_price"><h6>
											
												<span class="mycss">New Price:<c:out value="${product.price * (100-product.discount)/100}"></c:out></span>
											</h6></span>
									</div>
								
									<div class="item_add">
										<!-- Creating form to take input quantity and send the value to controller -->
									
										<form:form action="./ProductDetails" commandName="product">
											
   <form:input class="item_add" type="hidden" value="${product.name}" readonly="true" path="name"/>
                                          
                                          <form:input class="item_add"
												type="hidden" path="quantity"
												value="${product.quantity}"
												name="originalQuantity" readonly="true"/> <form:input
												type="submit" path="" class="button button2" value="ViewProduct"/>
										
										</form:form>
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

	<!-- End of Footer section -->
</body>
</html>