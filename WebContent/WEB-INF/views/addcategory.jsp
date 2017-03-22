<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
	function validateForm() {
		var x = document.forms["addCategory"]["cname"].value;
		if (x == "") {
			alert("Category can not be empty");
			return false;
		}
		if (isNaN(x)) {
			alert("Category should be a number");
			return false;
		}
	}
</script>
<title>Admin</title>
</head>
<body>
<c:if test="${empty sessionScope.admin}"></<c:redirect url="/./"></c:redirect></c:if>
<h2>ADD CATEGORY</h2>
	<form:form name="addCategory" action="./addCategory"
		onsubmit="return validateForm()" method="post"
		style="text-align: center;" modelAttribute="category">
		<table border="1">
			<tr>
				<td><form:label path="CategoryName"><spring:message code="label.CategoryName"></spring:message></form:label></td>
				<td><form:input type="text" required="true" path="CategoryName"/></td>
					<td><form:errors path="CategoryName"></form:errors></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="submit"
					value="Add Category"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>