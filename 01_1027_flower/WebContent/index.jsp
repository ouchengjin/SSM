<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	a {
		text-decoration: none;
		color: black;
	}
	
	a:hover {
		color: red;
	}
</style>
</head>
<body>
	<center>
		<table border="1">
			<tr>
				<th>花卉编号</th>
				<th>花卉名称</th>
				<th>价格(元)</th>
				<th>原产地</th>
			</tr>
			<c:forEach items="${list }" var="f">
				<tr>
					<td>${f.id }</td>
					<td>${f.name }</td>
					<td>${f.price }</td>
					<td>${f.production }</td>
				</tr>
			</c:forEach>
		</table>
		<a href="addFlower.jsp">添加花卉信息</a>
	</center>
</body>
</html>