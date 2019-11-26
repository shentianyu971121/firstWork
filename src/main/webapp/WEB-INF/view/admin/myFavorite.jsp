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
	        <th>操作</th>
	       </tr>
 		</thead>
 		<tbody>
 			<c:forEach items="${info.list }" var="list">
 				<tr>
 				<th>${list.userid }</th>
		        <th><a href="https://www.baidu.com/">${list.name }</a></th>
		        <th>${list.url }</th>
		        <th>
		        	<fmt:formatDate value="${list.created }" pattern="yyyy-MM-dd"/>
		        </th>
		        <th>
		        	<input type="button" value="取消收藏">
		        </th>
			     </tr>
 			</c:forEach>
 		</tbody>
 	</table>
 </div>
</body>
</html>