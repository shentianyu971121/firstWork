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
	
	function gotoCat(categoryId) {
		var url = "/user/channel?chnId=${chnId}&categoryId="+categoryId;
		location = url;
	}
	
	function goPage(page) {
		var url = "/user/channel?pageNum=" + page + "&chnId=${chnId}&categoryId=${categoryId} ";
		location = url;
	}
	
	
	function showArticle(articleId) {
		//然后去查询一下详情内容
		var url = "/article/showArticle?articleId="+articleId;
		window.open(url);
	}
	
	
	
	
</script>

</head>
<body>

<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
	    <div class="navbar-header">
	        <a class="navbar-brand" href="/user/userMain">
	        	<img alt="Main" title="返回主界面" src="/resource/images/logo.png" >
	        </a>
	        <ul class="nav navbar-nav nav-pills" style="margin-left: 10px; margin-right: 100px">
			   <li class="active"><a href="/user/userMain">首页 <span class="badge">32</span></a></li>
			   <li><a href="#">简介</a></li>
			   <li><a href="#">消息 <span class="badge">1</span></a></li>
			</ul>
	    </div>
	    <div>
	        <form class="navbar-form navbar-left" role="search">
	            <div class="form-group">
	                <input type="text" class="form-control" placeholder="Search">
	            </div>
	            <button type="submit" class="btn btn-default">提交按钮</button>
	        </form>
	        <button type="button" class="btn btn-default navbar-btn">
	            	导航栏按钮
	        </button>
	        <ul class="nav navbar-nav navbar-right">
		      <li><a href="#"><span class="glyphicon glyphicon-user"></span> 注册</a></li>
		      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> 登录</a></li>
		    </ul>
	        
	    </div>
	</div>
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
	  	<a href="#"><li  class="list-group-item ${list.id == chnId?"active":"" }" data = "/user/channel?chnId=${list.id }">${list.name }</li></a>
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

<!-- 中间 ------------------------------------------------------- -->	


<div class="col-md-7">
<div>
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div>
				<ul class="nav navbar-nav">
					<li class = ${categoryId == 0?"active":"" }><a href="javaScript:gotoCat(0)">全部</a></li>
					<c:forEach items="${categoryList }" var="cat">
						<li class = ${cat.id == categoryId?"active":"" }><a href="javaScript:gotoCat(${cat.id })">${cat.name }</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</nav>
</div>
<!-- 展示信息 -->

<!-- Article [id=117, title=文章图片,
 content=[{"desc":"篮球","picUrl":"20191101/1225d76a-e68f-46cf-b12e-f7e4b14c329d.jpeg"},
 {"desc":"小红花","picUrl":"20191101/ddf4b23d-7858-4dea-b24c-1eced5dd43fc.jpg"},
 {"desc":"小白花","picUrl":"20191101/eb029344-1c5c-4e5b-b8e4-9e7eb39a3549.jpg"}], 
 picture=20191101/4a7aeec1-c6b7-4471-ba97-b92f8ec02b74.jpeg, channelId=null, channel=Channel 
 [id=1, name=科技, description=null, icon=null], categoryId=null, 
 category=Category [id=2, name=软件, channelId=null, channel=null], userId=null, 
 user=User [id=48, username=e1707D, password=76922b82b1b95b3baf1213e2e279604c, nickname=null, 
 birthday=null, gender=A, locked=0, create_time=Fri Nov 01 10:21:12 CST 2019, update_time=null, 
 url=null, score=0, role=0], hits=0, hot=0, status=1, deleted=0, created=Fri Nov 01 10:50:47 CST 2019, 
 updated=Fri Nov 01 10:51:06 CST 2019, commentCnt=0, articleType=1] -->
 <c:forEach items="${info.list }" var="list">
<div class="panel panel-success">
   <div class="panel-heading">
      <h3 class="panel-title">${list.title }</h3>
   </div>
   <div class="panel-body">
		<a href="javaScript:showArticle(${list.id })">${list.title }</a>
      	<br>
      	频道:<a>${list.channel.name }</a>
      	分类:<a>${list.category.name }</a>
      	<br>
      	<br>
      	${list.user.username }发布于<fmt:formatDate value="${list.created }" pattern="yyyy-MM-dd"/>
   </div>
 </div>
 
 
</c:forEach>
<div style=" margin-left: 18px; margin-top: -10px">
<!-- 分页左边信息展示 -->
	<ul class="pagination">
	  <li> <a href="javascript:goPage(${info.prePage })">&laquo;</a> </li>
	  	<c:forEach begin="${info.pageNum - 2 > 1?info.pageNum - 2 : 1 }" end="${info.pageNum + 2 > info.pages?info.pages:info.pageNum + 2 }" varStatus="index">
	  		<li> <a href="javascript:goPage(${index.index })">${index.index }</a> </li>
	  	</c:forEach>
	  <li> <a href="javascript:goPage(${info.nextPage })">&raquo;</a> </li>
	  <li><span>当前${info.pageNum } / ${info.pages }页</span></li>
	</ul>	
</div>
</div>
	<!-- 中间结束 ----------------------------------------------------------------------------->
	
<div class="col-md-3">
	<!-- 输入框 -->
	<div style="padding-right: 80px;">
    <form class="bs-example bs-example-form" role="form">
        <div class="input-group">
            <span class="input-group-addon">@</span>
            <input type="text" class="form-control" placeholder="请输入邮箱">
        </div>
        <br>
        <div class="input-group">
        	<span class="input-group-addon">*</span>
            <input type="text" class="form-control">
            <span class="input-group-addon">账号</span>
        </div>
        <br>
        <div class="input-group">
            <span class="input-group-addon">*</span>
            <input type="text" class="form-control">
            <span class="input-group-addon">密码</span>
        </div>
    </form>
    <button type="button" class="btn btn-success" style="margin-left: 107px; margin-top: 20px">登录</button>
    <button type="button" class="btn btn-info" style="margin-left: 50px; margin-top: 20px">注册</button>
</div>
	<!-- 输入框 -->
	<div class="panel panel-primary" style="width: 375px; margin-top: 10px">
    <div class="panel-heading">
        <h3 class="panel-title">最新文章</h3>
    </div>
    <div class="panel-body">
        	<c:forEach items="${newArticles}" var="article" varStatus="index">
							${index.index+1} . <a href="#">${article.title}</a>
							<br/>
			</c:forEach>
    </div>
</div>
<div>
	<img alt="" src="/resource/images/1707D.jpg" width="400px" height="330px">
</div>

</div>
</div>
	
<!-- 底部导航栏....................... -->
<nav class="navbar navbar-inverse navbar-fixed-bottom" role="navigation">
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
</nav>
	
	
	
	
</body>
</html>