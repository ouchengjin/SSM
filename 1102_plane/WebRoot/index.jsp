<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HOME</title>
<style type="text/css">
table {
	width: 60%;
	text-align: center;
	border-collapse: collapse;
}
td{
	border: 1px solid orange;
	
}
</style>
</head>
<body>
	<center>
		<!-- form>select*2+input -->
		<form action="plane.sxt" method="post">
			起飞机场<select name="sid">
				<option value="-1">请选择</option>
				<c:forEach items="${list }" var="a">
					<option value="${a.id }" ${sid==a.id?'selected':'' }>${a.name }</option>
				</c:forEach>
			</select>
			降落机场<select name="eid">
				<option value="-1">请选择</option>
				<c:forEach items="${list }" var="a">
					<option value="${a.id }" ${eid==a.id?'selected':'' }>${a.name }</option>
				</c:forEach>
			</select>
			<input type="submit" value="查询"/>
		</form>
		<table>
			<tr>
				<td>飞机编号</td>
				<td>起飞机场</td>
				<td>起飞城市</td>
				<td>降落机场</td>
				<td>降落城市</td>
				<td>航行时间</td>
				<td>票价(元)</td>
			</tr>
			<c:forEach items="${plist }" var = "p">
				<tr>
					<td>${p.ptype }</td>
					<td>${p.startPort.name }</td>
					<td>${p.startPort.city }</td>
					<td>${p.endPort.name }</td>
					<td>${p.endPort.city }</td>
					<td>
						<c:if test="${p.time/60>=1 }">
							<fmt:formatNumber value="${p.time/60 }" pattern="###"></fmt:formatNumber>小时
						</c:if>
						<c:if test="${p.time%60>0 }">
							${p.time%60 }小时
						</c:if>
					</td>
					<td>
					<fmt:formatNumber value="${p.price }" pattern="￥###,###,###.00"/>
					</td>
				</tr>
			</c:forEach>
		</table>
	
	</center>
</body>
</html>