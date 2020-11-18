<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
	table {
		width: 60%;
		text-align: center;
		border-collapse: collapse;
	}
	td {
		border: 1px solid;
	}
</style>
</head>
<body>
	<center>
		<!-- form>table>tr*6>td+td>input -->
		<form action="account.sxt" method="post">
			<table>
				<tr>
					<td>转账账户：</td>
					<td><input type="text" name="outId"/></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="text" name="pwd"/></td>
				</tr>
				<tr>
					<td>金额：</td>
					<td><input type="text" name="balance"/></td>
				</tr>
				<tr>
					<td>收款账户：</td>
					<td><input type="text" name="inId"/></td>
				</tr>
				<tr>
					<td>收款人姓名：</td>
					<td><input type="text" name="name"/></td>
				</tr>
				<tr>
					<td colspan="2" >
						<input type="submit" value="转账">
					</td>
				</tr>
			</table>
		</form>
		
	
	</center>

</body>
</html>