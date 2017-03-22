<%@page import="java.util.ArrayList"%>
<%@page import="com.project.bean.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%int i=1;
		ArrayList<Product> productList = (ArrayList<Product>)getServletContext().getAttribute("viewProducts");
	%>
	<table border="1">
	<tr><th>S.No</th><th>Product Name</th><th>Category</th><th>Price</<th><th>Quantity</<th><th>Discount</th></tr>
		<%
			for (Product product : productList) {
		%>
		
		<tr>
		<td><%= i++ %></td>
		<td>
			<%=product.getName()%>
		</td>
		<td><%=product.getCategory()%></td>
		<td><%=product.getPrice()%></td>
		<td><%=product.getQuantity()%></td>
		<td><%=product.getDiscount()%></td>
		
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>