<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Goal</title>
</head>

<body>

	<!-- The commandName attribute links the form to an object with the name of its value -->
	<form:form commandName="goal">
		<table>
			<tr>
				<td>Enter Minutes</td>
				<!--
				The path value corresponds to a field of the object referenced by 
				the commandName attribute that has corresponding getters and setters methods
				-->
				<td><form:input path="minutes" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Enter Goal Minutes"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>