<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
	function validateForm() {
		var x = document.forms["updateProduct"]["pid"].value;
		if (x == "") {
			alert("Product Id can not be empty");
			return false;
		}
		if (isNaN(x)) {
			alert("Product ID should be a number");
			return false;
		}

		var x = document.forms["addProduct"]["prodquantity"].value;
		if (x == "") {
			alert("Product Quantity can not be empty");
			return false;
		}
		if (isNaN(x)) {
			alert("Product Quantity should be a number");
			return false;
		}

		var x = document.forms["addProduct"]["prodprice"].value;
		if (x == "") {
			alert("Product Price can not be empty");
			return false;
		}
		if (isNaN(x)) {
			alert("Product Price should be a number");
			return false;
		}
		var x = document.forms["addProduct"]["pdiscount"].value;
		if (x == "") {
			alert("Product Discount can not be empty");
			return false;
		}
		if (isNaN(x)) {
			alert("Product Discount should be a number");
			return false;
		}
		var x = document.forms["addProduct"]["pname"].value;
		if (x == "") {
			alert("Product Name can not be empty");
			return false;
		}
		if (!isNaN(x)) {
			alert("Product Name should only be String");
			return false;
		}
		var x = document.forms["addProduct"]["cname"].value;
		if (x == "") {
			alert("Product Category can not be empty");
			return false;
		}
		if (!isNaN(x)) {
			alert("Product Category should only be String");
			return false;
		}
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<form name="updateProduct" action="UpdateProductServlet"
		onsubmit="return validateForm()" method="post">
		<table border="1">


			<tr>
				<td>Enter Product id of product you want to update:</td>
				<td><input type="text" name="pid"></td>
			</tr>
			<tr>
				<td>Enter Product Name:</td>
				<td><input type="text" name="pname"></td>
			</tr>
			<tr>
				<td>Enter Category Name:</td>
				<td><input type="text" name="cname"></td>
			</tr>

			<tr>
				<td>Enter Product Price:</td>
				<td><input type="text" name="prodprice"></td>
			</tr>
			<tr>
				<td>Enter Product Quantity:</td>
				<td><input type="text" name="prodquantity"></td>
			</tr>
			<tr>
				<td>Enter Product Discount:</td>
				<td><input type="text" name="pdiscount"></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" name="submit"
					value="Submit"></td>
			</tr>

		</table>
	</form>

</body>
</html>