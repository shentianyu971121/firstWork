<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <!-- 引入bootstrap的css样式 -->
 <link rel="stylesheet" href="/resource/bootstrap/css/bootstrap.css">  
 <!-- 引入平常的js -->
 <script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script> 
 <!-- 引入bootstrap的js -->
 <script type="text/javascript" src="/resource/bootstrap/js/bootstrap.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
function goUrl(url) {
	location="/"+url 
}
function addAdminFavorite() {
	//收藏之后去另外一个页面进行添加
	location = "/admin/addAdminFavorite";
		
}

//取消收藏
function noFavorite(id) {
	$.post(
	"/admin/noFavorite",		
	{id:id},
	function(obj) {
		if(obj.result == 1) {
			alert("已取消")
			$("#content").load("/article/myFavorite");
		} else if(obj.result == 2) {
			alert("取消失败")
		} else {
			alert(obj.errorMsg)
		}
	},
	"json"
	)
}


</script>
</head>
<body>


<div class="table-responsive">
 	<table class="table">
 		<caption>${USER_SESSION_KEY.username }收藏</caption>
 		<thead>
 		   <tr >
	        <th>用户id</th>
	        <th>名称</th>
	        <th>地址</th>
	        <th>收藏时间</th>
	        <th>操作
	        	<input type="button" value="添加" class="btn btn-primary" onclick="addAdminFavorite()">
	        </th>
	       </tr>
 		</thead>
 		<tbody>
 			<c:forEach items="${info.list }" var="list">
 				<tr>
 				<th>${list.userid }</th>
		        <th><a href="${list.url }">${list.name }</a></th>
		        <th>${list.url }</th>
		        <th>
		        	<fmt:formatDate value="${list.created }" pattern="yyyy-MM-dd"/>
		        </th>
		        <th>
		        	<input type="button" value="取消收藏" onclick="noFavorite(${list.id})">
		        </th>
			     </tr>
 			</c:forEach>
 			<tr>
 				<td colspan="10">
 					共${info.total }条数据,当前${info.pageNum } / ${info.pages }页
					<a href="javaScript:goPage('/article/myFavorite?pageNum=1')">首页</a>
					<a href="javaScript:goPage('/article/myFavorite?pageNum=${info.prePage }')">上一页</a>
					<a href="javaScript:goPage('/article/myFavorite?pageNum=${info.nextPage }')">下一页</a>
					<a href="javaScript:goPage('/article/myFavorite?pageNum=${info.pages }')">尾页</a>
 				</td>
 			</tr>
 		</tbody>
 	</table>
 </div>
 <script type="text/javascript">
 function goPage(url) {
	$("#content").load(url);
}
 
 </script>
 
</body>
</html>