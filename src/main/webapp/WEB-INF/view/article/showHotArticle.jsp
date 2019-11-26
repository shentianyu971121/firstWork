<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<!-- 展示点击热门文章后的展示页面 -->
 <div class="container">
 <nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
	    <div class="navbar-header">
	        <div class="panel-heading">
		        <h2 class="panel-title">标题:       ${article.title }</h2>
		        <h4 class="panel-title">作者:        ${article.user.username }</h4>
		        <h4 class="panel-title">发布时间 :     <fmt:formatDate value="${article.created }" pattern="yyyy-MM-dd"/></h4>
		    </div>
	    </div>
	        <ul class="nav navbar-nav navbar-right">
			   <li class="dropdown">
			   	<button type="button" class="btn btn-default btn-sm" style="margin-top: 19px; margin-right: 19px" onclick="favorite(${article.id},${article.user.id },  '${article.title }'  )" >
			        <span class="glyphicon glyphicon-star">&nbsp;收藏</span>
			    </button>
				</li>
			</ul>
	    </div>

</nav>
 
<div class="panel panel-success">
    
    <div class="panel-body">
    	<input type="hidden" name="userId" value="${article.user.id }">
    	<input type="hidden" name="articleId" value="${article.id }">
        	${article.content }
    </div>
</div>
	<div style="text-align: center">
        	<input type="button" style="margin-right: 50px"  value="上一篇" class="btn btn-warning" onclick="preArticle(${article.id})" >
        	<input type="button" value="下一篇" class="btn btn-warning" onclick="nextArticle(${article.id})">
        	<input type="button" data-toggle="modal" data-target="#myModal" value="我要评论" class="btn btn-primary btn-lg btn-waring" style="margin-left: 72px" onclick="">
    </div>
</div>
<div class="container" id="content" >
	
</div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">${article.title }</h4>
                <h6 class="modal-title" id="myModalLabel"><span style="color: skyblue; font-size: 24px">${article.user.username } </span>&nbsp;你好  请发布你的评论</h6>
            </div>
            <div class="modal-body">
            	<textarea rows="10" cols="70" name="content">
            	
            	</textarea>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">我在想想</button>
                <button type="button" class="btn btn-primary" onclick="upSpeak()">提交评论</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<script type="text/javascript">
$(function() {
	$("#content").load("/articleContent/hotSpeak?articleId=${article.id }")
})

//发布评论
function upSpeak() {
	var content = $("[name=content]").val()
	var userId = $("[name=userId]").val()
	var articleId = $("[name=articleId]").val()
	$.post(
		"/articleContent/upSpeak",	
		{content:content, userId:userId, articleId:articleId},
		function(obj) {
			if(obj.result == 1) {
				alert("评论成功")
				location = "/article/showArticle?articleId="+articleId;
			} else {
				alert(obj.errorMsg)
			}
		},
		"json"
	)
}

function preArticle(id) {
	location = "/article/preArticle?id="+id;
}
function nextArticle(id) {
	location = "/article/nextArticle?id="+id;
}
function favorite(articleId, userId, comment) {
	$.post(
	"/article/favorite",		
	{articleId:articleId, userId:userId, comment:comment},
	function(obj) {
		if(obj.result == 1) {
			alert("收藏成功")
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