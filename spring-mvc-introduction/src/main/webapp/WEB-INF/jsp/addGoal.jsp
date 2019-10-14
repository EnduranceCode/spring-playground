<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Goal</title>

<style>
.error {
	color: #ff0000;
}

.errorblock {
	background-color: #ffeeee;
	border: 3px solid #ff0000;
	color: #000000;
	margin: 16px;
	padding: 8px;
}
</style>
</head>

<body>

	<!-- The commandName attribute links the form to an object with the name of its value -->
	<form:form commandName="goal">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td>Enter Minutes</td>
				<!--
				The path value corresponds to a field of the object referenced by 
				the commandName attribute that has corresponding getters and setters methods
				-->
				<td><form:input path="minutes" /></td>
				<td><form:errors path="minutes" cssClass="error" /></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" value="Enter Goal Minutes"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>