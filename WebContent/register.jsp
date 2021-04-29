<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>>>财大书城**<<</title>
	<style>
	*{font-size:14px;})
	p{ line-height:3em; }
	
	</style>
	<link rel="stylesheet" href="css/style.css">
	<script src="js/jquery-1.4.2.min.js"></script>
	<script>
		$(function(){
			$("#nav ul li").hover(function(){
				$("#nav ul").find(".first").hide();
				$(this).find("ul").slideDown("slow");
			},function(){
				$(this).find("ul").slideUp("slow");
			});
			$("#nav ul").hover(function(){
				
			},function(){
				$(this).find(".first").slideDown("slow");
			});
		});
	</script>
</head>
<body>
	
	<%@ include file = "header.jsp" %>
	
	<div id="banner" class="layout"><img src="images/banner.jpg"></div>
<h2 align="center">用户注册</h2>
<form action="reg.do" method="post" enctype="multipart/from-data">
	用户名：<input name="uname"><br>
	密码：<input name="upass" type="password"><br>
	性别：<input type="radio" value="male" name="gender" checked>男
	<input type="radio" value="female" name="gender">女<br>
	兴趣：<input type="checkbox" value="IT" name="interest">IT
	<input type="checkbox" value="PE" name="interest">体育
	<input type="checkbox" value="FE" name="interest">财经
	<input type="checkbox" value="MI" name="interest">军事
	<input type="checkbox" value="ED" name="interest">教育
	<input type="checkbox" value="SO" name="interest">社会<br>
	<p>头像：<input type="file"></p>
	<% String status = (String)request.getAttribute("status");
		out.print(status==null?"":status);
	%>
	<br>
	<input type="submit" value="登录">
	<input type="reset" value="取消">
</form>
</body>
	<%@ include file = "footer.jsp" %>
</body>
</html>