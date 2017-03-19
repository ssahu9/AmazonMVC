<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->

<%@page import="com.project.bean.Product"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.project.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Gretong a Ecommerce Category Flat Bootstarp Responsive
	Website Template | Details :: w3layouts</title>
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
<link href="<c:url value='/static/css/megamenu.css' />" rel='stylesheet' media="all" type='text/css' />
<link href="<c:url value='/static/css/etalage.css' />" rel='stylesheet' type='text/css' />
<script src="<c:url value="/static/js/megamenu.js" />"></script>

<script>
	$(document).ready(function() {
		$(".megamenu").megamenu();
	});
</script>
<script src="<c:url value="/static/js/jquery.etalage.min.js" />"></script>
<script src="<c:url value="/static/js/menu_jquery.js" />"></script>
<script>
	jQuery(document)
			.ready(
					function($) {
				$('#etalage').etalage({
					thumb_image_width: 300,
					thumb_image_height: 400,
					source_image_width: 900,
					source_image_height: 1200,
					show_hint: true,
					click_callback: function(image_anchor, instance_id){
					alert('Callback example:\nYou clicked on an image with the anchor: "'+image_anchor+'"\n(in Etalage instance: "'+instance_id+'")');
					}
				});
						$('#etalage')
								.etalage(
										{
											thumb_image_width : 300,
											thumb_image_height : 400,
											source_image_width : 900,
											source_image_height : 1200,
											show_hint : true,
											click_callback : function(
													image_anchor, instance_id) {
												alert('Callback example:\nYou clicked on an image with the anchor: "'
														+ image_anchor
														+ '"\n(in Etalage instance: "'
														+ instance_id + '")');
											}
										});
					});
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
						<li><a href="contact.jsp">Contact</a></li>|
						<li><a href="#">Delivery information</a></li>
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
						<a href="./"><span id="logo">Amazon Online Store</span>
						 </a>
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
												<form:form  action="./login" method="post"  id="loginForm" commandName="user">
													<fieldset id="body">
														<fieldset>
															<form:label path="email">Email Address</form:label>
															<form:input path="email"/>
														</fieldset>
														<fieldset>
															<form:label path="password">Password</form:label> 
															<form:password path="password"/>
														</fieldset>
														<input type="submit" id="login" value="Sign in"> <label
															for="checkbox"><input type="checkbox"
															id="checkbox"> <i>Remember me</i></label>
													</fieldset>
													<!-- <span><a href="#">Forgot your password?</a></span>-->
												</form:form>
											</div>
										</div>
									</div>
								</div>
								<div class="reg">
									<a href="./regForm">REGISTER</a>
								</div>
							</c:if>
							<!--  Link for signout  only if user variable is not exit in session scope -->
							<c:if test="${sessionScope.email != null}">
								<div class="reg">
									<a href="././logout">LOGOUT</a>
								</div>
							</c:if>
							<div class="create_btn">
								<a href="./checkout">CHECKOUT</a>
							</div>
							<div class="clearfix"></div>
						</div>

						<div class="cart box_1">
							<a href="./checkout">
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
						<form:form action="./searchProduct">
								<input type="text" value="" placeholder="search by product name"
									name="productName"> <input type="submit" value="">
							</form:form>

						</div>
						<div class="clearfix"></div>
					</div>
					<div class="clearfix"></div>
				</div>
				<!-- start header menu -->
				<ul class="megamenu skyblue">
					<li class="active grid"><a class="color1" href="./">Home</a></li>
					<li class="grid"><a class="color1"  href="./getProducts?category=">ALL</a></li>
				<c:forEach items="${applicationScope['categoryList']}"
						var="category">
						<li class="grid"><a class="color6"  href="./getProducts?category=${category.categoryName}">${category.categoryName}</a></li>
						</c:forEach>


				</ul>
	</div>
</div>
</div>
<!-- content -->
<div class="container">
<div class="women_main">
	<!-- start content -->
			<div class="row single">
				<div class="col-md-9 det">
				  <div class="single_left">
				 	<div class="grid images_3_of_2"> -
						<ul id="etalage">

							<li>
								<a href="optionallink.jsp">
									<img  class="etalage_source_image" style="width:150px" height="150px" src="${pname.productId }" class="img-responsive" alt="" />
								<!-- 	<img class="etalage_source_image" src="images/d1.jpg" class="img-responsive" title="" />
									 --><%--<img class="etalage_source_image" style="width:150px" height="150px" src="<%=product2.getProductId() %>" class="img-responsive" alt="" />
						--%>	</a>
							</li>
							
						</ul>
						 <div class="clearfix"></div>		
				  </div>
				  <div class="desc1 span_3_of_2">
					<h3>${pname.name }</h3>
					<span class="brand"> <a href="#"> </a></span>
					<br>
					<span class="text">Product Id:</span>
					<span class="price-new">${pname.productId }</span>
				
						<div class="price">
							<span class="text">Price:</span>
							<span class="price-new">${pname.price }</span> 
							<c:set var="price" value="${pname.price }"></c:set>
							<c:set var="price" value="${pname.price }"></c:set>
							<br>
							<span class="text">Discount:</span>
							
					 	<span class="price-new">${pname.discount }%</span>  <br>
							<span class="text">New Price:</span>
							<span class="price-new"> ${pname.price-(pname.discount/100)*pname.price}</span> 
						
				
						</div>
				
					<div class="btn_form">
						
						<form:form action="./insertIntoCart" commandName="cart">
											<form:input path="productId" class="item_add" type="hidden"
												value="${pname.productId }"
												 readonly="true"/>
<input path="name" class="item_add" type="hidden" value="${pname.name }"
												 readonly="true"/>
												 
												 Enter Quantity<form:input type="number"
												name="quantity" path="quantity" placeholder="Enter Quantity" value="1" min="1" max="${pname.quantity }"/>
												 <form:input
												type="submit" class="button button2" path="" value="Add to Cart"/>
										</form:form>
						
						
					</div>
					
					
			   	 </div>
          	    <div class="clearfix"></div>
          	   </div>
          	    <div class="single-bottom1">
					<h6>Details</h6>
					<p class="prod-desc">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option</p>
				</div>
			
		   	  </div>
	      
</div>
</div>
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
						<li><a href="#"><i class="facebok"> </i></a></li>
						<li><a href="#"><i class="twiter"> </i></a></li>
						<li><a href="#"><i class="goog"> </i></a></li>
						<li><a href="#"><i class="be"> </i></a></li>
						<li><a href="#"><i class="pp"> </i></a></li>
							<div class="clearfix"></div>	
					</ul>
				</div>
			</li>
				<div class="clearfix"> </div>
		</div>
		<div class="col-md-6 s-c">
			<div class="stay">
						<div class="stay-left">
							<form:form>
								<input type="text" placeholder="Enter your email to join our newsletter" required=""/>
							</form:form>
						</div>
						<div class="btn-1">
							<form>
								<input type="submit" value="join">
							</form>
						</div>
							<div class="clearfix"> </div>


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
				<li><a href="./regForm">Register</a></li>
				<li><a href="./checkout">My Cart</a></li>
				<li><a href="./getAllBill">Bill History</a></li>
				<li><a href="./checkout">Payment</a></li>
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
