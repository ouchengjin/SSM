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

img{	
	cursor: pointer;
}
</style>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("a,img").click(function() {
			$("img").attr("src","vcode.jpg?s="+ new Date().getTime());
		});
	});
</script>
</head>
<body> 
	<font color="red" size="7">${msg }</font>
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
				<td>验证码:</td>
				<td>
					<input type="text" name="code" size="4">
					<img src="vcode.jpg" width="100"/>
					<a href="javascript:void(0);">看不清</a>
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="登陆"/>
				<input type="reset" value="重置"/>
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>