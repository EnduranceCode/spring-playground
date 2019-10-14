<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Minutes Page</title>
</head>

<body>
	<h1>Add Minutes Exercised</h1>

	<!-- The commandName value links the form to the @ModelAttribute with the same value -->
	<form:form commandName="exercise">
		<table>
			<tr>
				<td>Minutes Exercise for Today</td>
				<td><form:input path="minutes" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Enter Exercise"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
