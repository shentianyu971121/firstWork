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
<title>CMS管理平台</title>
</head>
<body>
<!-- 在导航栏里面添加navbar-inverse   
	。 -->
<nav class="navbar navbar-inverse" role="navigation">  <!-- 向上面的元素添加 role="navigation"，有助于增加可访问性。 -->
	<!-- container (固定宽度)    这个可以设置一些内边距和外边距 -->
	<div class="container-fluid">
		<!-- navbar-header就是类似于logo标志  里面有个navbar-brand就是logo实现 -->
		<div class="navbar-header">
				<!-- 这个就是logo  -->
				<a class="navbar-brand" href="#">CMS系统</a>
		</div>
		<div>
			<!-- navbar-right就是在右面显示信息 -->
			<ul class="nav navbar-nav navbar-right">
				<!-- dropdown是一个下拉菜单 也就类似于点击事件 所以需要在li里面设置dropdown来隐藏li 的内容 -->
				<li class="dropdown">
					<!-- a标签就是一个类似的触发器  点击就显示下拉内容  也就是将下面的ul li隐藏，点击之后就进行展示 -->
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" >
						用户<b class="caret"></b>
					</a>
					<!-- 这个就是隐藏的ul.li就当前面的a标签点击之后进行展示 -->
					<ul class="dropdown-menu">
						<li><a href="#">用户设置</a></li>
						<li><a href="#">个人信息</a></li>
						<!-- divider就是一个横线 -->
						<li class="divider"></li>
						<li><a href="#">退出</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>
<!-- 开始创建主题导航栏 也就是在侧面点击会 执行的一些操作 -->
<div class="row"><!-- 这个就是bootstarp的网格系统讲一个页面分为12px  -->
	<div class="col-md-2"> <!-- col就是将row的12份分开   格式为col-md-占比 -->
		<div style="margin-left:20px ">
			<ul class="nav nav-pills nav-stacked">
			  <li class="active"><a href="javascript:showFuction('/admin/articles')">文章列表</a></li>
			  <li><a href="javascript:showFuction('/user/hello')">测试</a></li>
			  <li><a href="#">发布文章</a></li>
			  <li>投票管理
			  	<ul class="nav nav-pills nav-stacked">
			  		<li><a href="#">投票列表</a></li>
			  		<li><a href="#">新建投票</a></li>
			  	</ul>
			  </li>
			  <li class="divider"></li>
			  <li><a href="javascript:showF('/user/hellow')">用户管理</a></li>
			</ul>
		</div>
	</div>
	<div class="col-md-10"  style=" min-height:500px; border-left: solid">
		<div id="content"></div>
	</div>
</div>

<nav class="navbar navbar-inverse navbar-fixed-bottom" 
role="navigation">
	<div align="center"> <font color="blue" size="5"> ----八维大数据学院1707D--- </font> </div>
</nav>

<script type="text/javascript">
	function showF(url){
		$("#content").load(url)
	}
</script>



</body>
</html>