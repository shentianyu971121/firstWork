<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
<title>添加管理员收藏</title>
</head>
<body>
<form:form action="/admin/addFavorite" method="post" modelAttribute="adminFavorite">
<table class="table">
	<tr>
		<td>名称:</td>
		<td>
			<form:input path="name"/><form:errors path="name" />
		</td>
	</tr>	
	<tr>
		<td>地址:</td>
		<td>
			<form:input path="url"/><form:errors path="url" />
		</td>
	</tr>	
	<tr>
		<td colspan="10">
			<form:button>收藏</form:button>
		</td>
	</tr>	
</table>
</form:form>
</body>
</html>