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
<style type="text/css">
.list-group li{
	text-align: center;
	font-size: 18px;
	
}
.list-group li:hover{
	background-color: skyblue;
}
</style>

<script type="text/javascript">
	//给频道一个指定的点击事件
	$(function() {
		$(".list-group a li").click(function() {
			var url = $(this).attr("data");
			//因为这是一个地址 所有我们直接去后台访问
			location = url;
		})
	})
	function goPage(page) {
		var url = "/user/userMainEs?pageNum=" + page+"&key=${key}";
		location = url;
	}
	function showArticle(articleId) {
		//然后去查询一下详情内容
		var url = "/article/showArticle?articleId="+articleId;
		window.open(url);
	}
	function exit() {
		//这就是退出信息
		location = "/loginOrRegister/exit";
	}
	function user() {
		//去后台尽心查询
		location = "/user/getArticleByUserId";
	}
	
</script>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
	    <div class="navbar-header">
	        <a class="navbar-brand" href="#">
	        	<img alt="Main" src="/resource/images/logo.png" >
	        </a>
	        <ul class="nav navbar-nav nav-pills" style="margin-left: 10px; margin-right: 100px">
			   <li class="active"><a href="#">首页 <span class="badge">42</span></a></li>
			   <li><a href="#">简介</a></li>
			   <li><a href="#">消息 <span class="badge">3</span></a></li>
			</ul>
	        
	    </div>
	        <form class="navbar-form navbar-left" role="search" action="/user/searchAll" method="post">
	            <div class="form-group">
	                <input type="text" class="form-control" placeholder="Search" name="key">
	            </div>
	            <button type="submit" class="btn btn-default">全局搜索</button>
	        </form>

	        <c:if test="${USER_SESSION_KEY == null }">
		        <ul class="nav navbar-nav navbar-right">
			      <li><a href="/loginOrRegister/register"><span class="glyphicon glyphicon-user"></span>注册</a></li>
			      <li><a href="/loginOrRegister/login"><span class="glyphicon glyphicon-log-in"></span> 登录</a></li>
			    </ul>
		     </c:if>
	        <c:if test="${USER_SESSION_KEY != null }">
	        <ul class="nav navbar-nav navbar-right">
			   <li class="dropdown">
			      <a class="dropdown-toggle glyphicon glyphicon-user" data-toggle="dropdown" href="#">
			         欢迎您:${USER_SESSION_KEY.username}<span class="caret"></span>
			      </a>
			      <ul class="dropdown-menu">
			      		<!-- 点击个人中心  跳转到用另一个页面 -->
			         <li><a href="javaScript:user()">个人中心</a></li>
			         <li><a href="#">个人信息</a></li>
			         <li><a href="#">设置</a></li>
			         <li class="divider"></li>
			         <li><a href="javaScript:exit()">退出</a></li>
			      </ul>
			   </li>
			</ul>
		     </c:if>
	    </div>
	+
</nav>
<div style=" height: 20px"  >
   <!-- -----------------进度条------------------------ -->
<div class="progress progress-striped">
   <div class="progress-bar progress-bar-info" role="progressbar"
      aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" 	
      style="width: 96%;">
      <span class="sr-only">90% 完成（信息）</span>
   </div>
</div>   
   <!-- -------------------进度条---------------------- -->
</div>

<!-- 调高度 -->
	<div style="height: 8px"></div>
<!-- 调高度 -->
<div class="row">
	<!-- 这个div就是为了让盒子局中一点展示 -->
	<!-- <div class="col-md-1"></div> -->
	<div class="col-md-2" >
	<div class="list-group">
	   <a href="#" class="list-group-item active">
	      <h4 class="list-group-item-heading" align="center">
	         	所有频道
	      </h4>
	   </a>
	  	<ul class="list-group">
	  	<c:forEach items="${list }" var="list">
	  	<a href="#"><li  class="list-group-item" data = "/user/channel?chnId=${list.id }">${list.name }</li></a>
	  	</c:forEach>
		</ul>
	</div>
	<!-- 展示图片   就是优秀毕业人 -->
	  <div >
        <div class="thumbnail" align="center">
            <img src="/resource/images/1.jpg"
            alt="最美歌声">
            <div class="caption">
                <h3 style="color: skyblue">八维优秀毕业生</h3>
                <p>
                    <a href="#" class="btn btn-primary" role="button" style="margin-right: 30px">
                  	    查看详情
                    </a> 
                    <a href="#" class="btn btn-default" role="button">
                  	  不想看她
                    </a>
                </p>
            </div>
        </div>
    </div>
	</div>
<!-- 中间 -->	
<div class="col-md-7">
		<!-- 轮播 -->
<div id="myCarousel" class="carousel slide">
   <!-- 轮播（Carousel）指标 -->
   <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
   </ol>   
   <!-- 轮播（Carousel）项目 -->
   <div class="carousel-inner">
      <div class="item active">
         <img style="height: 500px; width: 1110px"  src="/resource/images/cccc.jpg" alt="First slide">
         <div class="carousel-caption">  </div>
      </div>
      <div class="item">
         <img style="height: 500px; width: 1110px" src="/resource/images/6f0dbc455defeefb9c0319d864c5cf4b.jpg"  alt="Second slide">
         <div class="carousel-caption">   </div>
      </div>
      <div class="item">
         <img  style="height: 500px; width: 1110px"  src="/resource/images/dddd.jpg" alt="Third slide">
         <div class="carousel-caption">    </div>
      </div>
   </div>
   <!-- 轮播（Carousel）导航 -->
   <a class="carousel-control left" href="#myCarousel" 
      data-slide="prev">&lsaquo;</a>
   <a class="carousel-control right" href="#myCarousel" 
      data-slide="next">&rsaquo;</a>
     </div>	
	<!-- 轮播 -->
	<div class="row">
	<!-- 文章开始------------------------------------------------------------------------- -->
	<div class="col-md-7" style="heheoverflow-x:scroll;overflow-y:scroll; height: 430px">
	<c:forEach items="${hotList.list }" var="list" varStatus="index">
	<!-- 左边信息展示 -->
			<div class="bg-light text-dark" style=" margin-left: 18px; margin-top: 5px">
				<div class="media">
				   <a class="pull-left" href="#">
				      <img class="media-object " src="/pic/${list.picture }" style="width: 80px; height: 80px"
				      alt="Media Object">
				   </a>
				   <div class="media-body">
				      <h4 class="media-heading">文章内容</h4>
				      	<a href="javaScript:showArticle(${list.id })">${list.title }</a>
				      	<br>
				      	频道:<a>${list.channel.name }</a>
				      	分类:<a>${list.category.name }</a>
				      	<br>
				      	<br>
				      	${list.user.username }发布于<fmt:formatDate value="${list.created }" pattern="yyyy-MM-dd"/>
				    </div> 
			</div>
		</div>
		<div style="height: 20px">
		
		</div>
		<c:if test="${hotList.list.size() == index.count }">
			<div style=" margin-left: 18px; margin-top: -10px">
			<!-- 分页左边信息展示 -->
				<ul class="pagination">
				  <li> <a href="javascript:goPage(${hotList.prePage })">&laquo;</a> </li>
				  	<c:forEach begin="${hotList.pageNum - 2 > 1?hotList.pageNum - 2 : 1 }" end="${hotList.pageNum + 2 > hotList.pages?hotList.pages:hotList.pageNum + 2 }" varStatus="index">
				  		<li> <a href="javascript:goPage(${index.index })" style="color = ${index.index==hotList.pageNum?'red':'pink' }">${index.index }</a> </li>
				  	</c:forEach>
				  <li> <a href="javascript:goPage(${hotList.nextPage })">&raquo;</a> </li>
				  <li><span>当前${hotList.pageNum } / ${hotList.pages }页</span></li>
				</ul>	
			</div>
		</c:if>
	</c:forEach>
	</div>
		<!-- 文章列表展示结束*--------------------------------------------------------------------- -->
		<div class="col-md-5">
		<div style="margin-top: 10px"></div>
	<div>
			<div class="row">
    <div class="col-sm-6 col-md-3">
        <a href="#" class="thumbnail">
            <img src="/resource/images/324682 - 副本.jpg"
                 alt="通用的占位符缩略图">
        </a>
    </div>
    <div class="col-sm-6 col-md-3">
        <a href="#" class="thumbnail">
            <img src="/resource/images/324682 - 副本.jpg"
                 alt="通用的占位符缩略图">
        </a>
    </div>
    <div class="col-sm-6 col-md-3">
        <a href="#" class="thumbnail">
            <img src="/resource/images/324682 - 副本.jpg"
                 alt="通用的占位符缩略图">
        </a>
    </div>
    <div class="col-sm-6 col-md-3">
        <a href="#" class="thumbnail">
            <img src="/resource/images/324682 - 副本.jpg"
                 alt="通用的占位符缩略图">
        </a>
    </div>
</div>
		</div>
		<div class="progress progress-striped">
		    <div class="progress-bar progress-bar-danger" role="progressbar"
		         aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
		         style="width: 20%;">
		        <span class="sr-only">20% 完成（危险）</span>
		    </div>
		</div>
		<div class="progress progress-striped">
		    <div class="progress-bar progress-bar-warning" role="progressbar"
		         aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
		         style="width: 40%;">
		        <span class="sr-only">40% 完成（警告）</span>
		    </div>
		</div>
		<div class="progress progress-striped">
		    <div class="progress-bar progress-bar-info" role="progressbar"
		         aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
		         style="width: 70%;">
		        <span class="sr-only">70% 完成（信息）</span>
		    </div>
		</div>
		<div class="progress progress-striped">
		    <div class="progress-bar progress-bar-success" role="progressbar"
		         aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
		         style="width: 95%;">
		        <span class="sr-only">95% 完成（成功）</span>
		    </div>
		</div>
		</div>
	</div>
	</div>
	<!-- 右边的上传文章 -->
	
<div class="col-md-3">
	<!-- 输入框 -->
	<div style="padding-right: 80px;">
    <div class="panel panel-danger">
					<div class="panel-heading" style="text-align: center">
						<h3 class="panel-title">图片文章</h3>
					</div>
					<div class="panel-body">
						<c:forEach items="${imgArticles}" var="article" varStatus="index"> 
							<a href="javascript:showArticle(${article.id})">${index.index}. ${article.title}</a>
							<br/>
						</c:forEach>
					</div>
	</div>
</div>
	<!-- 输入框 -->
	<div class="panel panel-primary" style="width: 375px; margin-top: 10px">
    <div class="panel-heading"  style="text-align: center">
        <h3 class="panel-title">最新文章</h3>
    </div>
    <div class="panel-body">
        	<c:forEach items="${newArticles}" var="article" varStatus="index">
							${index.count} . <a href="javaScript:showArticle(${article.id })">${article.title}</a>
							<br/>
			</c:forEach>
    </div>
	</div>
<!-- 右边下面------------------------------------------------------------------------ -->
<div>
	<img alt="" src="/resource/images/1707D.jpg" width="400px" height="330px">
</div>
</div>
</div>
<!-- 底部导航栏....................... -->
<!-- <nav class="navbar navbar-inverse navbar-fixed-bottom" role="navigation">
    <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">CMS教程</a>
    </div>
    <div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">iOS</a></li>
            <li><a href="#">SVN</a></li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    Java <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#">jmeter</a></li>
                    <li><a href="#">EJB</a></li>
                    <li><a href="#">Jasper Report</a></li>
                    <li class="divider"></li>
                    <li><a href="#">分离的链接</a></li>
                    <li class="divider"></li>
                    <li><a href="#">另一个分离的链接</a></li>
                </ul>
            </li>
        </ul>
    </div>
    </div>
</nav> -->
</body>
</html>