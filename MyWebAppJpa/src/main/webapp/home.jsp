<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<form action="addStudent">
		<label>Student id:</label>
		<input type="text" name="sid" /> <br>
		<label>Student name:</label>
		<input type="text" name="sname" /> <br>
		<label>Technology:</label>
		<input type="text" name="tech" /> <br>
		<input type="submit" value="Submit"/>
	</form>
	
	<br>
	<a href="searchId.jsp">Search using id</a>
	<a href="searchTech.jsp">Search using technology</a>
	
	<a href="getStudents">Get All students</a>
</body>
</html>