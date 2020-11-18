<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table {
		width: 60%;
		border-collapse: collapse;
		text-align: center;
	}
	td {
		border: 1px solid gray;
	}
</style>
</head>
<body>
	<center>
		<table>
			<tr>
				<td>编号</td>
				<td>姓名</td>
				<td>年龄</td>
			</tr>
			<c:forEach items="${list }" var = "p">
				<tr>
					<td>${p.id1}</td>
					<td>${p.name1}</td>
					<td>${p.age}</td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>