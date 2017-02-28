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
	<%
		ArrayList<Product> productList = (ArrayList<Product>)getServletContext().getAttribute("viewProduct");
	%>
	<table>
		<%
			for (Product product : productList) {
		%>
		<tr>
			<%=product.getName()%>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>