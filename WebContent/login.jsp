<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
<form action="login_action.jsp" method="get">
	用户名:<input name="uname"><br>
	密码:<input name="upass" type="password"><br>
	<input type="submit" value="登录">
	<input type="reset" value="取消">
</form>
</body>
</html>