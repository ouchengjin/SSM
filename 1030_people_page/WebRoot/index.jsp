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
			<c:forEach items="${p.list }" var = "peo">
				<tr>
					<td>${peo.id}</td>
					<td>${peo.name}</td>
					<td>${peo.age}</td>
				</tr>
			</c:forEach>
		</table>
		<a href="query.sxt?page=${p.firstPage}&size=${p.size}">首页</a> |
		<a href="query.sxt?page=${p.prevPage}&size=${p.size}" onclick = "return ${p.hasPrev};">上一页</a> |
		<a href="query.sxt?page=${p.nextPage}&size=${p.size}" onclick = "return ${p.hasNext};">下一页</a> |
		<a href="query.sxt?page=${p.lastPage}&size=${p.size}">尾页</a>
	</center>
</body>
</html>