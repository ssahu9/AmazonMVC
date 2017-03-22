<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script> function validateForm() {
    var x = document.forms["removeCategory"]["cname"].value;
    if (x == "") {
        alert("Name must be filled out");
        return false;
    }
}</script>
<title>Insert title here</title>
</head>
<body>
<h2>REMOVE CATEGORY</h2>
	<form:form commandName="category" name="removeCategory" action="./removeCategory" onsubmit="return validateForm()" method="post">
	<table border="1">
	
			<tr>
			
			<td><form:label path="CategoryName"><spring:message code="label.CategoryName"></spring:message></form:label></td>
				<td><form:input type="text" required="true" path="CategoryName"/></td>
					<td><form:errors path="CategoryName"></form:errors></td>
			
			</tr>
			<tr>
				<td colspan="3"><input type="submit" name="submit"
					value="Remove Category"></td>
			</tr>
		
	</table>
	</form:form>
</body>
</html>