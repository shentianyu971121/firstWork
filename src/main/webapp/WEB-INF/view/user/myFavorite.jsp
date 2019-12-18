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
<title>我的收藏夹</title>
</head>
<script type="text/javascript">
function openNew(url) {
	window.open(url)
}
function deleteMyFavorite(id) {
	$.post(
	"/user/deleteMyFavorite",		
	{id:id},
	function(obj) {
		if(obj.result == 1) {
			alert("删除成功")
			$("#contant").load("/user/showMyFavorite?pageNum=${info.pageNum}");
		} else {
			alert("删除失败")
		}
	},
	"json"
	)
}

function goPage(url) {
	$("#contant").load(url)
}
</script>
<body>
	<h2>我的收藏夹</h2>
	<hr color="red">
	<c:forEach items="${info.list }" var="list">
	<div>
		<h5><a href="javaScript:openNew('${list.url }')">${list.text }</a></h5>
		<p>时间:
		<fmt:formatDate value="${list.created }" pattern="yyyy-MM-dd HH:dd:mm"/>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp; <a  href="javaScript:deleteMyFavorite(${list.id })">删除</a></p>
	</div>
	<hr>
	</c:forEach>
	<div>
		共${info.total }条数据, 第 ${info.pageNum } / ${info.pages }页&nbsp;&nbsp;
		<a href="javaScript:goPage('/user/showMyFavorite?pageNum=1')">首页</a>
		<a href="javaScript:goPage('/user/showMyFavorite?pageNum=${info.prePage }')">上一页</a>
		<a href="javaScript:goPage('/user/showMyFavorite?pageNum=${info.nextPage }')">下一页</a>
		<a href="javaScript:goPage('/user/showMyFavorite?pageNum=${info.pages }')">尾页</a>
	</div>
</body>
</html>