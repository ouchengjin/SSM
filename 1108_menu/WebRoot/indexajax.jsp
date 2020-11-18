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
		$.getJSON("menu.sxt", function(result){
			console.info(result);
			var dl = "";
			for(var i = 0;i<result.length ;i++){
				dl+="<dl>"
				dl+="<dt onclick='change(this);'>"+result[i].menu+"</dt>"
				for(var j=0;j<result[i].list.length;j++){
					dl+="<dd>"
					dl+=result[i].list[j].menu
					dl+="</dd>"
				}
				dl+="</dl>"
			}
			$("body").html(dl);
		});
	});
	function change(obj){
		/* 左右收起展开 */
		$(obj).siblings("dd").toggle(300);
		/* 上下收起展开 */
		/* $(obj).siblings("dd").slideToggle(300); */
	}
</script>
<style>
	dt{
		cursor: pointer;
	}
</style>
</head>
<body>
	
</body>
</html>