<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<form action="loginPost" method="post">
		<div style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align: left;">
			<label> User Name : <input type="text" name="username" />
			</label>
		</div>
		<div style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align: left;">
			<label> Password: <input type="password" name="password" />
			</label>
		</div>
		<div>
			<input type="submit" value="Login" />
		</div>
	</form>
</body>
</html>