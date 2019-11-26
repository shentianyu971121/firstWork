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
<!-- 这个是个人 中心点击 点击我的文章嵌入的界面   全部的界面-->
</head>
<body>
<table class="table table-condensed">
   <caption>我的文章</caption>
   <thead>
      <tr>
         <th>编号</th>
         <th>标题</th>
         <th>收藏时间</th>
         <th>操作</th>
      </tr>
   </thead>
   <tbody>
   	<c:forEach items="${info.list }" var="list">
      <tr>
         <td>${list.id }</td>
         <td><a href="javaScript:showArticle(${list.articleId })">
         ${list.comment }</a></td>
         <td><fmt:formatDate value="${list.created }" pattern="yyyy-MM-dd HH:dd:ss"/></td>
         <td>
         	<%-- <input type="button" onclick="modifyArticle(${list.id})" value="> --%>
         	<button type="button" class="btn btn-default btn-sm" onclick="deleteFavorite(${list.id})">
			    <span class="glyphicon glyphicon-star-empty"></span> 取消收藏
			</button>
			
         </td>
      </tr>
      </c:forEach>
   </tbody>
   <tbody>
   		<tr>
      		<td colspan="10">
			共${info.total }条数据,当前${info.pageNum } / ${info.pages }页
			<a href="javaScript:goPage('/user/myFavorite?pageNum=1')">首页</a>
			<a href="javaScript:goPage('/user/myFavorite?pageNum=${info.prePage }')">上一页</a>
			<a href="javaScript:goPage('/user/myFavorite?pageNum=${info.nextPage }')">下一页</a>
			<a href="javaScript:goPage('/user/myFavorite?pageNum=${info.pages }')">尾页</a>
      		</td>
      	</tr>
   </tbody>
   </table>
   <script type="text/javascript">
   function goPage(url) {
	   $("#contant").load(url);
	}
   
   function showArticle(id) {
	 //然后去查询一下详情内容
		var url = "/article/showArticle?articleId="+id;
		window.open(url);
	}
   
   function deleteFavorite(id) {
	   $.post(
		"/user/deleteFavorite",
		{id:id},
		function(obj) {
			if(obj.result == 1) {
				alert("已取消")
				$("#contant").load("/user/myFavorite?pageNum=${info.pageNum}");
			} else {
				alert(obj.errorMsg)
			}
		},
		"json"
	   )
   }
   //修改信息
   function modifyArticle(articleId){
		var url="/user/updateArticle?id="+articleId;
		$("#contant").load(url);
	}
   
   </script>
</body>
</html>