<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table {
		width: 50%;
		border-collapse: collapse;
		text-align: center;
	}
	td {
		border: 1px solid red;
	}
</style>
</head>
<body>
	<center>
		<table>
			<tr>
				<td>转账账号</td>
				<td>收款账号</td>
				<td>转账金额</td>
			</tr>
			<c:forEach items="${p.list }" var = "log">
				<tr>
					<td>${log.outId}</td>
					<td>${log.inId}</td>
					<td>${log.balance}</td>
				</tr>
			</c:forEach>
		</table>
		<a href="log.sxt?page=${p.prevPage}&size=${p.size}" onclick = "return ${p.hasPrev};">上一页</a> |
		<a href="log.sxt?page=${p.nextPage}&size=${p.size}" onclick = "return ${p.hasNext};">下一页</a>
	</center>
</body>
</html>