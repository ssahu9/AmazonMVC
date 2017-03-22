<%@page import="java.util.ArrayList"%>
<%@page import="com.project.bean.Category"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% int i=1;
		ArrayList<Category> categoryList = (ArrayList<Category>)request.getAttribute("categoryList");
	%>
	<table border="1">
	<tr><th>S.No</th><th>Category Name</th></tr>
		<%
			for (Category category : categoryList) {
		%>
		<tr>
			<td><%= i++ %></td><td><%=category.getCategoryName()%></td>
		</tr>
		<%
			}
		%>
	</table>


</body>
</html>