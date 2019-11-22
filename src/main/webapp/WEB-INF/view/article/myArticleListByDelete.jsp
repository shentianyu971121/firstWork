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
<title>我的文章列表</title>
<!-- 这个是个人 中心点击 点击我的文章嵌入的界面   这个是未审核的界面       -->
</head>
<body>
<table class="table table-condensed">
   <caption>我的文章</caption>
   <thead>
      <tr>
         <th>标题</th>
         <th>频道</th>
         <th>分类</th>
         <th>发布日期</th>
         <th>状态</th>
         <th>操作</th>
      </tr>
   </thead>
   <tbody>
   	<c:forEach items="${list }" var="list">
      <tr>
         <td><a href="javaScript:showArticle(${list.id })">${list.title }</a></td>
         <td>${list.channel.name }</td>
         <td>${list.category.name }</td>
         <td><fmt:formatDate value="${list.created }" pattern="yyyy-MM-dd"/></td>
         <td>
         <c:choose>
         	<c:when test="${list.status==0 }">待审核</c:when>
         	<c:when test="${list.status==1 }">审核通过</c:when>
         	<c:when test="${list.status==2 }">审核未通过</c:when>
         </c:choose>
         </td>
         <td>
         	<input type="button" value="修改">
         	<input type="button" value="删除" onclick="delArticleByUser(${list.id })">
         </td>
      </tr>
      </c:forEach>
   </tbody>
   </table>
   <script type="text/javascript">
	function showArticle(id) {
		 //然后去查询一下详情内容
			var url = "/article/showArticle?articleId="+id;
			window.open(url);
	}
	//去后台进行删除
	function delArticleByUser(id) {
		$.post(
		"user/delArticleByUser",		
		{id:id},
		function(obj) {
			if(obj.result == 1) {
				alert("删除成功")
			} else {
				alert(obj.errorMsg)
			}
		},
		"json"
		)
	}
   
   </script>
</body>
</html>