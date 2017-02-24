
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>




<table border="2">

<tr height="50px" width="1500px" border="1" bordercolor="black" >

<td colspan="2">
<center >ADMIN PANEL</center>
</td>
</tr>
<tr height="700px" width="1500px">
<td height="700px" width="300px">
<form action="">
<a href="viewcategory">VIEW CATEGORIES</a>
<a href="addproduct.JSP" onclick="">ADD PRODUCT</a><br>
<a href="addcategory.JSP">ADD CATEGORY</a><br>
<a href="removecategory.JSP">REMOVE CATEGORY</a><br>
<a href="removeproduct.JSP">REMOVE PRODUCT</a><br>
<a href="billhistory.JSP">BILL HISTORY</a><br>
<a href="updateproduct.JSP">UPDATE PRODUCT</a><br>
<a href="viewproduct.JSP">VIEW PRODUCT</a><br>
<a href="updatePassword.JSP">UPDATE PASSWORD</a>



</form>

</td>
<td height="700px" width="1500px">


<c:if test="${sessionScope.adminemail == null}">  
<div> 
<p>You Session ahs Failed!</p>
</div>
</c:if>
<c:if test="${sessionScope.email != null}"> 











</c:if>
</td>
</tr>

</table>




</body>
</html>