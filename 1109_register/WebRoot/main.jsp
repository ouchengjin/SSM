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
		$.getJSON("selRes",function(result){
			console.info(result);
			var tr="";
			for(var i=0;i<result.length;i++){
				tr +="<tr>";
				tr +="<td>"+result[i].rname+"</td>";
				tr +="<td>"+result[i].dcount+"</td>";
				//这里的this指的是,谁点击就把谁扔过来
				tr +="<td><a onclick = 'updCount(this)' href= 'download?id="+result[i].id+"&rname="+result[i].rname+"'>下载</a></td>";
				tr +="</tr>";		
			} 
			$("#tb").html(tr);
		});
	});
	
	function updCount(obj){
		/* jquery对象一般加个$,以区别js对象.不加也行 */
		var num = $(obj).parent().prev().html();
		/* JS中的parseInt,将字符串转为整数 */
		$(obj).parent().prev().html(parseInt(num) + 1);
	}

</script>
<style type="text/css">
	table{
		width: 40%;
		text-align: center;
		border-collapse: collapse;
	}
	td{
		border: 1px solid;
	}
</style>
</head>
<body>
	<center>
		<table>
			<tr>
				<td>资料名称</td>
				<td>下载次数</td>
				<td>操作</td>
			</tr>
			<tbody id="tb"></tbody>
		</table>
		
	</center>
</body>
</html>