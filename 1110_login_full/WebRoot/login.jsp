<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${msg }</h1>
<c:remove var="msg" scope="session"/>
	<form action="login" method="post">
		<input type="text" name="uname"/>
		<input type="password" name="upwd"/>
		<input type="submit" value="登陆"/>
	</form>
</body>
</html>