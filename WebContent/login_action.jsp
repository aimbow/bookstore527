<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] userlist = {"test01","guest","abcde","hello"};
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录结果</title>
</head>
<body>
<% 
boolean logsuc = false;
String username = request.getParameter("uname");
String userpass = request.getParameter("upass");
for (int i=0; i<userlist.length;i++){
	if(userlist[i].equals(username)){
		logsuc = true;
		break;
	}
}
if(logsuc){
	out.print(username + "登录成功！");
	session.setAttribute("myusername", username);
	response.sendRedirect("index.jsp");
}
else{
	out.print("登陆失败！");
}
%>
</body>
</html>