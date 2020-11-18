<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<style type="text/css">
*{
	padding: 0;
	margin:0;
}


</style>

</head>
<body> 
	<font color="red">${msg }</font>
	<!-- form>table>tr*4>td+td>input -->
	<form action="login.sxt" method="post">
		<table>
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="uname"/></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="text" name="upwd"/></td>
			</tr>
			
			<tr>
				<td colspan="2">
				<input type="submit" value="登陆"/>
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>