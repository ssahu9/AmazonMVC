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
	Website Template | Home :: w3layouts</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary JavaScripts plugins) -->
<script type='text/javascript' src="js/jquery-1.11.1.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
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
<jsp:include page="/AvailableCategory.jsp" />

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
						<a href="index.jsp"><img src="images/logo.png"
							class="img-responsive" alt="" /> </a>
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
												<form id="loginForm" action=".\LoginServlet">
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
								<div class="log">
									<a href="./Logout">LOGOUT</a>
								</div>
								<!--  Link for profile information updation  -->
								<div class="log" style="margin-left: 0px;">
									<a href="UpdateCustomerProfile.jsp">UPDATE PROFILE</a>
								</div>
							</c:if>
							<div class="create_btn">
								<a href="checkout.jsp" style="margin-left: 50px;">CHECKOUT</a>
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
							<form action="#">
								<input type="text" value="" placeholder="search by product name"
									name="searchProduct"> <input type="submit" value="">
							</form>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="clearfix"></div>
				</div>


				<!-- start header menu -->
				<ul class="megamenu skyblue">
					<li class="active grid"><a class="color1" href="index.jsp">Home</a></li>

					<c:forEach items="${applicationScope['categoryList']}"
						var="category">
						<form action="./GetProducts">
							
							<li><input type="submit" class="color2"
								name="selectedCategory" value="${category.CategoryName}">
							</li>

						</form>
					</c:forEach>

				</ul>
				<!-- End of Header Menu -->
				
				<!-- start header menu -->
				<ul class="megamenu skyblue">
					<li class="active grid"><a class="color1" href="index.jsp">Home</a></li>

					<!-- getting category name from list and displaying it in list -->
					<%--  	
			<% ArrayList<Category> categoryList=(ArrayList<Category>)session.getAttribute("categoryList"); --%>

					<%--	<%for(Category category:categoryList){ %>
		
			<li><a class="color2" href="#" name=<%=category.getCategoryName()%>></a><%=category.getCategoryName()%></a>				
				</li>	
		<% } %>
		 --%>
					<li class="grid"><a class="color2" name="category" href="#">Category</a>
					</li>
					<li><a class="color5" href="women.jsp" name="category">Category3</a>

					</li>
					<li><a class="color6" href="#">Category4</a></li>

					<li><a class="color8" href="#">categor6y</a></li>
					<li><a class="color9" href="#">Category7</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="arriv">
		<div class="container">
			<div class="arriv-top">
				<div class="col-md-6 arriv-left">
					<img src="images/1.jpg" class="img-responsive" alt="">
					<div class="arriv-info">
						<h3>NEW ARRIVALS</h3>
						<p>REVIVE YOUR WARDROBE WITH CHIC KNITS</p>
						<div class="crt-btn">
							<a href="details.jsp">Category</a>
						</div>
					</div>
				</div>
				<div class="col-md-6 arriv-right">
					<img src="images/2.jpg" class="img-responsive" alt="">
					<div class="arriv-info">
						<h3>TUXEDO</h3>
						<p>REVIVE YOUR WARDROBE WITH CHIC KNITS</p>
						<div class="crt-btn">
							<a href="details.jsp">Category</a>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="arriv-bottm">
				<div class="col-md-8 arriv-left1">
					<img src="images/3.jpg" class="img-responsive" alt="">
					<div class="arriv-info1">
						<h3>SWEATER</h3>
						<p>REVIVE YOUR WARDROBE WITH CHIC KNITS</p>
						<div class="crt-btn">
							<a href="details.jsp">Category</a>
						</div>
					</div>
				</div>
				<div class="col-md-4 arriv-right1">
					<img src="images/4.jpg" class="img-responsive" alt="">
					<div class="arriv-info2">
						<a href="details.jsp"><h3>
								Category<i class="ars"></i>
							</h3></a>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="arriv-las">
				<div class="col-md-4 arriv-left2">
					<img src="images/5.jpg" class="img-responsive" alt="">
					<div class="arriv-info2">
						<a href="details.jsp"><h3>
								Category<i class="ars"></i>
							</h3></a>
					</div>
				</div>
				<div class="col-md-4 arriv-middle">
					<img src="images/6.jpg" class="img-responsive" alt="">
					<div class="arriv-info3">
						<h3>FRESH LOOK T-SHIRT</h3>
						<div class="crt-btn">
							<a href="details.jsp">Category</a>
						</div>
					</div>
				</div>
				<div class="col-md-4 arriv-right2">
					<img src="images/7.jpg" class="img-responsive" alt="">
					<div class="arriv-info2">
						<a href="details.jsp"><h3>
								category<i class="ars"></i>
							</h3></a>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<div class="special">
		<div class="container">
			<h3>Special Offers</h3>
			<div class="specia-top">
				<ul class="grid_2">
					<li><a href="details.jsp"><img src="images/8.jpg"
							class="img-responsive" alt=""></a>
						<div class="special-info grid_1 simpleCart_shelfItem">
							<h5>Lorem ipsum dolor</h5>
							<div class="item_add">
								<span class="item_price"><h6>ONLY $40.00</h6></span>
							</div>
							<div class="item_add">
								<span class="item_price"><a href="#">add to cart</a></span>
							</div>
						</div></li>
					<li><a href="details.jsp"><img src="images/9.jpg"
							class="img-responsive" alt=""></a>
						<div class="special-info grid_1 simpleCart_shelfItem">
							<h5>Consectetur adipis</h5>
							<div class="item_add">
								<span class="item_price"><h6>ONLY $60.00</h6></span>
							</div>
							<div class="item_add">
								<span class="item_price"><a href="#">add to cart</a></span>
							</div>
						</div></li>
					<li><a href="details.jsp"><img src="images/10.jpg"
							class="img-responsive" alt=""></a>
						<div class="special-info grid_1 simpleCart_shelfItem">
							<h5>Commodo consequat</h5>
							<div class="item_add">
								<span class="item_price"><h6>ONLY $14.00</h6></span>
							</div>
							<div class="item_add">
								<span class="item_price"><a href="#">add to cart</a></span>
							</div>
						</div></li>
					<li><a href="details.jsp"><img src="images/11.jpg"
							class="img-responsive" alt=""></a>
						<div class="special-info grid_1 simpleCart_shelfItem">
							<h5>Voluptate velit</h5>
							<div class="item_add">
								<span class="item_price"><h6>ONLY $37.00</h6></span>
							</div>
							<div class="item_add">
								<span class="item_price"><a href="#">add to cart</a></span>
							</div>
						</div></li>
					<div class="clearfix"></div>
				</ul>
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
	<div class="footer">
		<div class="container">
			<div class="col-md-3 cust">
				<h4>CUSTOMER CARE</h4>
				<li><a href="#">Help Center</a></li>
				<li><a href="#">FAQ</a></li>
				<li><a href="buy.jsp">How To Buy</a></li>
				<li><a href="#">Delivery</a></li>
			</div>
			<div class="col-md-2 abt">
				<h4>ABOUT US</h4>
				<li><a href="#">Our Stories</a></li>
				<li><a href="#">Press</a></li>
				<li><a href="#">Career</a></li>
				<li><a href="contact.jsp">Contact</a></li>
			</div>
			<div class="col-md-2 myac">
				<h4>MY ACCOUNT</h4>
				<li><a href="register.jsp">Register</a></li>
				<li><a href="#">My Cart</a></li>
				<li><a href="#">Order History</a></li>
				<li><a href="buy.jsp">Payment</a></li>
			</div>
			<div class="col-md-5 our-st">
				<div class="our-left">
					<h4>OUR STORES</h4>
				</div>
				<div class="our-left1">
					<div class="cr_btn">
						<a href="#">SOLO</a>
					</div>
				</div>
				<div class="our-left1">
					<div class="cr_btn1">
						<a href="#">BOGOR</a>
					</div>
				</div>
				<div class="clearfix"></div>
				<li><i class="add"> </i>Jl. Haji Muhidin, Blok G no.69</li>
				<li><i class="phone"> </i>025-2839341</li>
				<li><a href="mailto:info@example.com"><i class="mail">
					</i>info@sitename.com </a></li>

			</div>
			<div class="clearfix"></div>
			<p>
				Copyrights © 2015 Gretong. All rights reserved | Template by <a
					href="http://w3layouts.com/">W3layouts</a>
			</p>
		</div>
	</div>
</body>
</html>