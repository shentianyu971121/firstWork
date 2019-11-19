<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>个人中心</title>
<script type="text/javascript">
	function maArticle() {
		//点击此处加载文章 就是去后台进行查询的文章
		$("#contant").load("/user/myArticle");
	}
</script>
</head>
<body>
<div class="page-header row" >
	<div class="col-md-5">
	<ul class="nav nav-pills" style="margin-left: 50px">
	        <li class="active">
	                <a href="#">首页
	                        <span class="badge">42</span>
	                </a>
	        </li>
	        <li>
	                <a href="#">简介</a>
	        </li>
	        <li>
	                <a href="#">消息
	                        <span class="badge">3</span>
	                </a>
	        </li>
	</ul>
	</div>
	<div class="col-md-7">
	<h1 style="color: skyblue;">个人中心
                <small  style="color: #ccc">当前用户:${USER_SESSION_KEY.username}</small>
        </h1>
	</div>
</div>
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-2">
		<div class="panel panel-success"  style="text-align: center">
		   <div class="panel-heading">
		      <h2 class="panel-title">个人中心</h2>
		   </div>
		   <div class="panel-body">
		   	 <ul class="nav nav-pills nav-stacked">
			  <li><a href="javaScript:maArticle()">我的文章</a></li>
			  <li><a href="#">发布文章</a></li>
			  <li><a href="#">待审核</a></li>
			  <li><a href="#">已删除</a></li>
			  <li><a href="#">设置</a></li>
			  <li><a href="#">浏览历史</a></li>
			</ul>
		   </div>
		</div>
		</div>
		<div class="col-md-9" id="contant">
		</div>
	</div>
</body>
</html>

      
  
      
      
  





