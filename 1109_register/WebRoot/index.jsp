<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		var f1 = false;
		var f2 = false;
		var f3 = false;
		/* blur:丢失焦点 */
		$(":text").blur(function(){
			/* $(this).val():取里面的值 */
			if($(this).val() != "") {
				$(this).next().css("color","green").html("√");
				f1 = true;
			}else{
				$(this).next().css("color","red").html("×");
				f1 = false;
				
			};
		});
		
		$(":password:eq(0)").blur(function(){
			/* 正则表达式在js中写到两个斜杠当中 */
			var regex = /^\w{6,12}$/;
			/* 匹配 */
			if($(this).val().match(regex)){
				$(this).next().css("color","green").html("√");
				f2 = true;
			}else{
				$(this).next().css("color","red").html("×");
				f2 = false;
			}
		});
		$(":password:eq(1)").blur(function(){
			/* 匹配 */
			
			if($(this).val() != "" && $(this).val() == $(":password:eq(0)").val()){
				$(this).next().css("color","green").html("√");
				f3 = true;
			}else{
				$(this).next().css("color","red").html("×");
				f3 = false;
			}
		});
		/* 选中整个表单 */
		$("form").submit(function(){
			return f1 && f2 && f3; 
		});
	});
</script>
</head>
<body>
<center>
	<!-- form>table>tr*5>td+td>input -->
	<form action="register" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="uname" /><span></span></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="upwd"/><span></span></td>
			</tr>
			<tr>
				<td>确认密码</td>
				<td><input type="password" /><span></span></td>
			</tr>
			<tr>
				<td>头像</td>
				<td><input type="file" name="file"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="注册"/>
				</td>
			</tr>
		</table>
	</form>
</center>
</body>
</html>