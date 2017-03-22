

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!-- <script>
	$(document).ready(function() {
		$("#vc").click(function() {
			
			$("#div1").load("viewcategories.jsp");
		});
		$("#ap").click(function() {
		/* 	$("#div1").innerHTML="<jsp:include page="addcategory.jsp" />  "; */
		
		 $("#div1").load("addproduct.jsp"); 
		});
		$("#ac").click(function() {
			$("#div1").load("addcategory.jsp");
		});
		$("#rc").click(function() {
			$("#div1").load("removecategory.jsp");
		});
		$("#rp").click(function() {
			$("#div1").load("removeproduct.jsp");
		});
		$("#bh").click(function() {
			$("#div1").load("BillHistory");
		});
		$("#up").click(function() {
			$("#div1").load("updateproduct.jsp");
		});
		$("#vp").click(function() {
			$("#div1").load("ViewProducts");
		});
		$("#upwd").click(function() {
			$("#div1").load("updatepassword.jsp");
		});
	});

</script> -->

<body>

	<c:if test="${sessionScope.email != null}">
		<div class="log"
			style="background-color: black; color: white; font-size: 30px;">
			<a href="./Logout">LOGOUT</a>
		</div>
	</c:if>
<h4>${message }</h4>
	<table border="2">

		<tr height="50px" style="width:1500px; border: 1px" bordercolor="black">

			<td colspan="2"
				style="background-color: black; color: white; font-size: 40px;">
				<center>
					<b>ADMIN PANEL</b>
				</center>
			</td>
		</tr>
		<tr style="height=700px; width=1500px;">
			<td height="700px" width="300px"
				style="background-color: orange; color: black; font-size: 30px;">
				<form:form action="./adminEntry" style="text-align: center;">
					<input type="submit" name="button" id="vc" value="View Category"/><br>
					<br> <input type="button" name="button" id="ap"
						value="Add  Product"><br>
					<br> <input type="submit" name="button" id="ac"
						value="Add Category"><br>
					<br> <input type="submit" name="button" id="rc"
						value="Remove Category"><br>
					<br> <input type="submit" name="button" id="rp"
						value="Remove Product"><br>
				
					<br> <input type="submit" name="button" id="up"
						value="Update Product"><br>
					<br> <input type="submit" name="button" id="vp"
						value="View Products"><br>
					<br>


				</form:form>

			</td>
			<td height="700px" width="1500px"
				style="background-color: #FAEBD7; color: black; text-align: center;"><c:if
					test="${sessionScope.admin == null}">
					<div id="div1" style="text-align: center;">
						<p>Your Session has Failed!</p>
					</div>
				</c:if> <c:if test="${sessionScope.admin != null}">
					<div id="div1" style="text-align: center;">
						<p>Your Session has Started!</p>
					</div>
				</c:if></td>
		</tr>

	</table>




</body>
</html>