<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<style type="text/css">
body {
	background-image: url('https://cdn.crunchify.com/bg.png');
}
</style>
</head>
<body>
	<form action="saveUser" method="post">
		<div
			style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align: left;">
			<label> First Name : <input type="text" name="firstName" />
			</label>
		</div>

		<div
			style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align: left;">
			<label> Last Name : <input type="text" name="lastName" />
			</label>
		</div>

		<div
			style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align: left;">
			<label> Email : <input type="text" name="email" />
			</label>
		</div>

		<div
			style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align: left;">
			<label> User Name : <input type="text" name="userName" />
			</label>
		</div>
		<div
			style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align: left;">
			<label> Password: <input type="password" name="password" />
			</label>
		</div>

		<div
			style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align: left;">
			<label> Phone Number : <input type="text" name="phone" />
			</label>
		</div>

		<div
			style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align: left;">
			<label> Date of Birth : <input type="text" name="dateofBirth"  
			value="<fmt:formatDate value="${User.dateofBirth}" pattern="MM-dd-yyyy" />"/>
			</label>
		</div>

		<div
			style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align: left;">
			<label> Active Indicator: <select name="active">
					<option value="yes">Yes</option>
					<option value="no">No</option>
			</select>
			</label>
		</div>

		<div>
			<input type="submit" value="signup" />
		</div>
	</form>
	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${errors}</td>
		</tr>
	</table>
</body>
</html>