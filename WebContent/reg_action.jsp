<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册结果</title>
</head>
<body>
<% 
request.setCharacterEncoding("utf-8");
String username = request.getParameter("uname");
String userpass = request.getParameter("upass");
String usergender = request.getParameter("gender");
//获取兴趣数组
String[] userinter = request.getParameterValues("interest");

String ipaddr = request.getRemoteAddr();
out.print("IP地址为：" + ipaddr + "<br>");
String header = request.getHeader("User-agent");
out.print("注册成功！<br>用户名："+username+"<br>密码："+userpass+"<br>性别："+usergender);
out.print("你的兴趣：");
for(int i=0; i<userinter.length;i++){
	out.print(userinter[i] + "");
}
if(usergender.equals("male")){
	out.print("recomend you electronic product");
}
else{
	out.print("recomend you mac");
}
%>
</body>
</html>