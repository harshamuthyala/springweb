<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Application Website</title>
<style type="text/css">
body {
	background-image: url('https://cdn.crunchify.com/bg.png');
}
</style>

</head>
<body>

	<div style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align: left;">
		<h1>Welcome, ${user} !</h1>
		<p>Click <a href="logout">here</a> to logout.</p>
	</div>
</body>
</html>
