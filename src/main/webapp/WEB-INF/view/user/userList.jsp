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
<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
	    <div class="navbar-header">
	        <a class="navbar-brand" href="#">
	        	<img alt="Main" src="/resource/images/logo.png" >
	        </a>
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
<div class="progress progress-striped">
   <div class="progress-bar progress-bar-success" role="progressbar" 
      aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" 	
      style="width: 90%;">
      <span class="sr-only">90% 完成（成功）</span>
   </div></div>
</div>

<!-- 调高度 -->
	<div style="height: 10px"></div>
<!-- 调高度 -->

<div class="row">
	<!-- 这个div就是为了让盒子局中一点展示 -->
	<!-- <div class="col-md-1"></div> -->
	
	
	<div class="col-md-2" >
	<div class="list-group">
	   <a href="#" class="list-group-item active">
	      <h4 class="list-group-item-heading">
	         	大数据
	      </h4>
	   </a>
	   <a href="#" class="list-group-item">
	      <h4 class="list-group-item-heading">
	         	用户设置
	      </h4>
	      <p class="list-group-item-text">
	         	个人信息
	      </p>
	   </a>
	   <a href="#" class="list-group-item">
	      <h4 class="list-group-item-heading">
	         	详情操作
	      </h4>
	      <p class="list-group-item-text">
	      		可根据ID 姓名
	      </p>
	   </a>
	</div>
	<div class="list-group">
	   <a href="#" class="list-group-item active">
	      <h4 class="list-group-item-heading">
	       	  1707D
	      </h4>
	   </a>
	   <a href="#" class="list-group-item">
	      <h4 class="list-group-item-heading">
	     	    班级人员
	      </h4>
	      <p class="list-group-item-text">
	      	   人员操作
	      </p>
	   </a>
	   <a href="#" class="list-group-item">
	      <h4 class="list-group-item-heading">
	      	公告
	      </h4>
	      <p class="list-group-item-text">
	      	公告详情
	      </p>
	   </a>
	</div>
	</div>

<!-- 中间 -->	
<div class="col-md-7" >
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
         <img src="/resource/images/cccc.jpg" alt="First slide">
         <div class="carousel-caption">  </div>
      </div>
      <div class="item">
         <img src="/resource/images/6f0dbc455defeefb9c0319d864c5cf4b.jpg"  alt="Second slide">
         <div class="carousel-caption">   </div>
      </div>
      <div class="item">
         <img src="/resource/images/dddd.jpg" alt="Third slide">
         <div class="carousel-caption">    </div>
      </div>
   </div>
   <!-- 轮播（Carousel）导航 -->
   <a class="carousel-control left" href="#myCarousel" 
      data-slide="prev">&lsaquo;</a>
   <a class="carousel-control right" href="#myCarousel" 
      data-slide="next">&rsaquo;</a></div>	
	<!-- 轮播 -->
	</div>
	
	<!-- 右边的上传文章 -->
	
<div class="col-md-3">
	<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">公告</h3>
    </div>
    <div class="panel-body">
        	请直接在下方发表文章! ! !
    </div>
</div>
</div>
	
</div>


	

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