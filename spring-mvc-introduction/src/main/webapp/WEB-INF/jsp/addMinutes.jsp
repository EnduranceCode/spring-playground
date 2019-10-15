<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Minutes Page</title>

<script type="text/javascript" src="jquery-3.4.1.js"></script>

<script type="text/javascript">
	$(document).ready(
		function() {
		$.getJSON(window.location.origin + '/FitnessTracker/activities.json', {
			ajax : true
		}, function(data) {
			var html = '<option value="">-- Please select one --</option>';
			var len = data.length;
			for(var i = 0; i < len; i++){
				html += '<option value="' + data[i].description + '">' + data[i].description + '</option>';
			}
			html += '</option>';
			$('#activities').html(html);
		});
	});
</script>
</head>

<body>
	<h1>Add Minutes Exercised</h1>

	<p>
		Language: <a href="?language=en">English</a> | <a href="?language=es">Spanish</a>
	</p>

	<!-- The commandName attribute links the form to an object with the name of its value -->
	<form:form commandName="exercise">
		<table>
			<tr>
				<td><spring:message code="goal.text" /></td>
				<!--
				The path value corresponds to a field of the object referenced by 
				the commandName attribute that has corresponding getters and setters methods
				-->
				<td><form:input path="minutes" /></td>
				<td><form:select id="activities" path="activity"></form:select></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" value="Enter Exercise"></td>
			</tr>
		</table>
	</form:form>

	<p>
		<strong>Our goal for the day is: ${goal.minutes}</strong>
	</p>
</body>
</html>
