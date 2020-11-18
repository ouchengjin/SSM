<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("form").submit(function() {
			if($(":text:eq(0)").val()=="" || $(":text:eq(1)").val()=="" ||$(":text:eq(2)").val()=="") {
				alert("请添加完整信息!");
				return false;
			}
		});
	});
</script>
</head>
<body>
<center>
	<h1>花卉信息</h1>
	<form action="flower.sxt" method="post">
		<input type="hidden" name="method" value="addFlower" />
		<table>
			<tr>
				<th>花卉名称:</th>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<th>花卉价格:</th>
				<td><input type="text" name="price" /></td>
			</tr>
			<tr>
				<th>原产地:</th>
				<td><input type="text" name="production" /></td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="submit" value="提交" />
					<input type="reset" value="重置" />
				</th>
			</tr>
		</table>
	</form>
</center>
</body>
</html>