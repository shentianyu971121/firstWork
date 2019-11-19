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
<!-- 这个是个人 中心点击 点击我的文章嵌入的界面  -->
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
   	<c:forEach items="${info.list }" var="list">
      <tr>
         <td>${list.title }</td>
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
         	<input type="button" value="删除">
         </td>
      </tr>
      </c:forEach>
   </tbody>
   <tbody>
   		<tr>
      		<td colspan="10">
			共${info.total }条数据,当前${info.pageNum } / ${info.pages }页
			<a href="javaScript:goPage('/user/myArticle?pageNum=1')">首页</a>
			<a href="javaScript:goPage('/user/myArticle?pageNum=${info.prePage }')">上一页</a>
			<a href="javaScript:goPage('/user/myArticle?pageNum=${info.nextPage }')">下一页</a>
			<a href="javaScript:goPage('/user/myArticle?pageNum=${info.pages }')">尾页</a>
      		</td>
      	</tr>
   </tbody>
   </table>
   <script type="text/javascript">
   function goPage(url) {
	   $("#contant").load(url);
	}
   </script>
   
</body>
</html>