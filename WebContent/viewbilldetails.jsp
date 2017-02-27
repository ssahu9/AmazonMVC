<%@page import="java.util.ArrayList"%>
<%@page import="com.project.bean.BillHistory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% ArrayList<BillHistory> billList=(ArrayList<BillHistory>)session.getAttribute("billList"); %>
<table>
<%for( BillHistory blist:billList){ %>
<tr>
<%= blist. getBillId()+" "+ blist. getProductId()+" "+blist. getQuantity()+" "+blist. getDiscount()+" "+blist. getProductPrice()%>
</tr>
<%}%>

</table>
</body>
</html>