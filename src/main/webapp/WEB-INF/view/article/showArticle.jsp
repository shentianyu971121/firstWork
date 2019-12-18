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
</head>
<body>
<!-- 这个界面是管理员 点击我的文章展示的页面    -->

   <div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true"   >
   <div class="modal-dialog">
      <div class="modal-content" >
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;            </button>
            <h4 class="modal-title" id="myModalLabel">
            	<!--这里面写标题 -->
             </h4>
            <h4 class="modal-title" id="author">
            	<!--这里面写标题 -->
             </h4>
            <h4 class="modal-title" id="channel">
            	<!--这里面写标题 -->
             </h4>
         </div>
         <div class="modal-body" id="content1111" style="height:500px;overflow-x:scroll;overflow-y:scroll"> 
         </div>
      </div><!-- /.modal-content -->
       <div class="modal-footer">
         <input type="button" class="btn btn-default btn-success" onclick="apply(1)" data-dismiss="modal" value="审核通过" >
         <input type="button" class="btn btn-default btn-warning" onclick="apply(2)" data-dismiss="modal" value="审核不通过">
         <input type="button" class="btn btn-default btn-danger" onclick="setHot(1)" data-dismiss="modal" value="热门">
         <input type="button" class="btn btn-default btn-warning" onclick="setHot(0)" data-dismiss="modal" value="非热门">
         </div>
      </div>
      <!-- /.modal -->
      </div>
<table class="table table-condensed">
   <caption>所有文章</caption>
   <thead>
      <tr>
         <th>标题</th>
         <th>频道</th>
         <th>分类</th>
         <th>发布日期</th>
         <th>状态
         	<input type="hidden" name="articleId">
         </th>
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
         	<input type="button"  class=" btn btn-warning btn-primary" data-toggle="modal" data-target="#myModal" onclick="showArticle(${list.id })"  value="审核">
         	<input type="button" class= "btn btn-danger" value="删除"   onclick="articleDel(${list.id })">   <!-- 删除 -->
         </td>
      </tr>
      </c:forEach>
   </tbody>
   <tbody>
   		<tr>
      		<td colspan="10">
			共${info.total }条数据,当前${info.pageNum } / ${info.pages }页
			<a href="javaScript:goPage('/article/allArticle?pageNum=1')">首页</a>
			<a href="javaScript:goPage('/article/allArticle?pageNum=${info.prePage }')">上一页</a>
			<a href="javaScript:goPage('/article/allArticle?pageNum=${info.nextPage }')">下一页</a>
			<a href="javaScript:goPage('/article/allArticle?pageNum=${info.pages }')">尾页</a>
      		</td>
      	</tr>
   </tbody>
   </table>
   <script type="text/javascript">
  	function goPage(url) {
	   $("#content").load(url);
	}
  	//删除  就是修改  将deleted的值修改为1
  	function articleDel(id) {
		$.post(
		"/article/articleDel",	
		{id:id},
		function(obj) {
			if(obj.result == 1) {
				alert("删除成功")
				$("#content").load('/article/allArticle')	
			} else if(obj.result == 2) {
				alert("删除失败")
			} else {
				alert(obj.errorMsg)
			}
		},
		"json"
		)
	}
  	
  	/* 点击审核时候需要回显信息  也就是使用ajax回显 */
  	function showArticle(id) {
		//去后台展示信息
		$.post(
		"/article/showArticleById",		
		{id:id},
		function(obj) {
			if(obj.result == 1) {
			alert(JSON.stringify(obj.data.content))
				$("[name=articleId]").val(obj.data.id)
				 $("#myModalLabel").text(obj.data.title)
				  $("#content1111").html(obj.data.content)	
				 $("#channel").text("频道 : " + obj.data.channel.name +  "  分类:" + obj.data.category.name)		
				 $("#author").text("作者 : " + obj.data.user.username)		
				
			} else {
				alert(obj.errorMsg)
			}
				
		}, 
		"json"
		)
	}
  	
  	function apply(status) {
  		var id = $("[name=articleId]").val()
  		//首先获取Id的值   然年去后进行修改
  		$.post(
  		"/article/adminUpdateStatus",
  		{id:id,status:status},
  		function(obj) {
			if(obj.result == 1) {
				alert("审核成功")
				$("#content").load('/article/allArticle?pageNum=${info.pageNum }')
			} else {
				alert(obj.errorMsg)
			}
		},
		"json"
  		)
	}
  	//设置热门 信息
  	function setHot(hot) {
  		var id = $("[name=articleId]").val()
  		$.post(
  		"/article/adminUpdateHot",
  		{id:id,hot:hot},
  		function(obj) {
			if(obj.result == 1) {
				alert("审核成功")
				$("#content").load('/article/allArticle?pageNum=${info.pageNum }')
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