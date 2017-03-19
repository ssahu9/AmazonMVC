<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@page import="org.springframework.web.context.annotation.RequestScope"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="com.project.bean.Product"%>
<%@page import="java.util.LinkedList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.project.bean.CartDetails"%>
<%@page import="com.project.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- <!DOCTYPE HTML> -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Gretong a Ecommerce Category Flat Bootstarp Responsive
	Website Template | Home :: w3layouts</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel='stylesheet' type='text/css' />

<!-- jQuery (necessary JavaScript plugins) -->
<script src="<c:url value="/static/js/jquery-1.11.1.min.js" />"></script>

<!-- Custom Theme files -->
<link href="<c:url value='/static/css/style.css' />" rel='stylesheet'
	type='text/css' />

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
<link href="<c:url value='/static/css/megamenu.css' />" media="all"
	rel='stylesheet' type='text/css' />
<script src="<c:url value="/static/js/megamenu.js" />"></script>

<c:if test="${empty sessionScope.email}"></<c:redirect
		url="/index.jsp"></c:redirect>
</c:if>
<script>
	$(document).ready(function() {
		$(".megamenu").megamenu();
	});
</script>
<script src="<c:url value="/static/js/menu_jquery.js" />"></script>
<script src="<c:url value="/static/js/simpleCart.min.js" />"></script>


</script>
</head>
<body>
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
						<a href="index.jsp"><span id="logo">Amazon Online Store</span>
						</a>
					</div>
					<!-- start header_right -->
					<div class="header_right">
						<div class="rgt-bottom">
							<!-- Session check -->
							<!-- Providing login and register option  only if user variable is exit in session scope -->

							<!--  Link for signout  only if user variable is not exit in session scope -->
							<c:if test="${sessionScope.email != null}">
								<div class="log">
									<a href="./Logout">LOGOUT</a>
								</div>
								<div class="log">
									<a href="./CustomerAllBill">BILL DETAILS</a>
								</div>

								<!--  Link for profile information updation  -->
								<div class="log" style="margin-left: 0px;">
									<a href="UpdateCustomerProfile.jsp">UPDATE PROFILE</a>
								</div>
							</c:if>
							<div class="create_btn">
								<a href="CheckoutServlet" style="margin-left: 50px;">CHECKOUT</a>
							</div>
							<div class="clearfix"></div>
						</div>

						<div class="cart box_1">
							<a href="CheckoutServlet">
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
								<input type="text" value="" placeholder="search by product name"
									name="searchProduct"> <input type="submit" value="">
							</form>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="clearfix"></div>
				</div>

				<!-- start header menu -->


				<!-- header -->
				<ul class="megamenu skyblue">
					<li class="active grid"><a class="color1" href="./">Home</a></li>
					<li class="grid"><a class="color1" href="GetProducts">ALL</a></li>
					<c:forEach items="${applicationScope['categoryList']}"
						var="category">
						<li class="grid"><a class="color6"
							href="GetProducts?selectedCategory=${category.categoryName}">${category.categoryName}</a></li>
					</c:forEach>


				</ul>
			</div>
		</div>
	</div>

	<%-- <%
		LinkedList<CartDetails> cartDetails = (LinkedList<CartDetails>) RequestScope.ca;

		double sum = 0;
		for (CartDetails cart : cartDetails) {

			sum = sum + cart.getTotalPrice();
		}
	%>
 --%>


	<div class="container">
		<div class="check">
			<div class="col-md-3 cart-total">
				<a class="continue" href="./">Continue shopping</a>


				<div class="price-details">
					<h3>Price Details</h3>
					<span>Total</span> <span class="total1" style="color: black;">sum></span>
					<!-- 	<span>Discount</span> -->
					<!--  <span class="total1">---</span> <span>Delivery Charges</span> <span
						class="total1">150.00</span>-->
					<div class="clearfix"></div>
				</div>
				<ul class="total_price">
					<li class="last_price">
						<h4>TOTAL</h4>
					</li>
					<li class="last_price"><span>sum</span></li>
					<div class="clearfix"></div>
				</ul>


				<div class="clearfix"></div>
				<a class="order" href="./placeOrder">Place Order</a>
				<div class="total-item"></div>
			</div>
			<div class="col-md-9 cart-items">
				<h1>My Shopping Bag</h1>

				<script>
					$(document).ready(function(c) {
						$('.close1').on('click', function(c) {
							$('.cart-header').fadeOut('slow', function(c) {
								//$('.cart-header').remove();
							});
						});
					});
				</script>
				<c:forEach items="${cartList}" var="cart">
					<div class="cart-header">
						<div class="close1">
							<form:form commandName="product" action="./removeFromCart">

								<form:input class="item_add" type="hidden"
									value="${cart.productId}" name="pId" path="productId" />
								<form:input path="" type="submit" class="item_price"
									value="Remove From Cart" />
							</form:form>
						</div>
						<div class="cart-sec simpleCart_shelfItem">
							<div class="cart-item cyc">
								<img src="${cart.productId}" class="img-responsive" alt="" />
							</div>
							<div class="cart-item-info">
								<h3>${cart.productName}</h3>
								Quantity:
								<ul class="qty">
									<li><p>${cart.quantity}</p></li>

								</ul>

								<div class="delivery">

									<span>Delivered in 2-3 bussiness days</span>
									<div class="clearfix"></div>
								</div>
							</div>

							<div class="clearfix"></div>

						</div>
					</div>
				</c:forEach>

				<!-- 		<script>
					$(document).ready(function(c) {
						$('.close2').on('click', function(c) {
							$('.cart-header2').fadeOut('slow', function(c) {
								$('.cart-header2').remove();
							});
						});
					});
				</script>
				<div class="cart-header2">
					<div class="close2"></div>
					<div class="cart-sec simpleCart_shelfItem">
						<div class="cart-item cyc">
							<img src="images/11.jpg" class="img-responsive" alt="" />
						</div>
						<div class="cart-item-info">
							
							<h3>
								<a href="#">Mountain Hopper(XS R034)</a><span>Model No:
									3578</span>
							</h3>
							<ul class="qty">
								<li><p>Size : 5</p></li>
								<li><p>Qty : 1</p></li>
							</ul>
							<div class="delivery">
								<p>Service Charges : Rs.100.00</p>
								<span>Delivered in 2-3 bussiness days</span>
								<div class="clearfix"></div>
							</div>
						</div>
 -->
				<div class="clearfix"></div>

			</div>
		</div>
	</div>


	<div class="clearfix"></div>
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
							<li><a href="CallErrorPageServlet"><i class="facebok">
								</i></a></li>
							<li><a href="CallErrorPageServlet"><i class="twiter">
								</i></a></li>
							<li><a href="CallErrorPageServlet"><i class="goog">
								</i></a></li>
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
				Copyrights � 2015 Gretong. All rights reserved | Template by <a
					href="http://w3layouts.com/">W3layouts</a>
			</p>
		</div>
	</div>
	<!-- End of Footer section -->
</body>
</html>