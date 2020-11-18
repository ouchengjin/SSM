<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<style type="text/css">
	table {
		width: 50%;
		border-collapse: collapse;
		text-align: center;
	}
	td {
		border: 1px solid blue;
	}
</style>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(":radio").bind("click",function(){
			$("form").submit();
		});
	});
</script>


</head>
<body>
	<center>
		<form action="StudentServlet" method="post">
			<input type="radio" name="size" value="2" ${p.size==2?'checked':'' }/>2
			<input type="radio" name="size" value="3" ${p.size==3?'checked':'' }/>3
			<input type="radio" name="size" value="4" ${p.size==4?'checked':'' }/>4<br/>
			学生姓名<input type="text" name="sname" value="${p.sname}"/>
			老师姓名<input type="text" name="tname" value="${p.tname}"/>
			<input type="submit" value="查询 " />
		</form>
		<table>
			<tr>
				<td>编号</td>
				<td>学生姓名</td>
				<td>年龄</td>
				<td>任课老师</td>
			</tr>
		<c:forEach items="${p.list }" var="s">
			<tr>
				<td>${s.id }</td>
				<td>${s.name }</td>
				<td>${s.age }</td>
				<td>${s.teacher.name }</td>
			</tr>
		
		</c:forEach>
		</table>
		<a href="StudentServlet?page=${p.prevPage }&size=${p.size }&sname=${p.sname}&tname=${p.tname}" onclick="return ${p.hasPrev};">上一页</a>|
		<a href="StudentServlet?page=${p.nextPage }&size=${p.size }&sname=${p.sname}&tname=${p.tname}" onclick="return ${p.hasNext}">下一页</a>
	</center>
</body>
</html>