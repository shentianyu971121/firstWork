<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>欢迎登陆</title>
 <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <!-- 引入bootstrap的css样式 -->
 <link rel="stylesheet" href="/resource/bootstrap/css/bootstrap.css">  
 <!-- 引入平常的js -->
 <script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script> 
 <!-- 引入bootstrap的js -->
 <script type="text/javascript" src="/resource/bootstrap/js/bootstrap.js"></script>
 <!-- 引入js的验证插件 validate -->
 <script type="text/javascript" src="/resource/js/jquery.validate.js"></script>
</head>
<body>
<div class="container" style=" background-color:#6fc87e; vertical-align: middle;" align="center">
<div style="boder:1px #ccc solid; width:400px;height:400px;">
<form class="form-horizontal" id="regForm" role="form" method="post">
	  <div class="form-group" style="margin-top: 100px">
	    <label for="firstname" class="col-sm-3 control-label">用户名:</label>
	    <div class="col-sm-9">
	      <input type="text" class="form-control" id="username" 
	      name="username" minlength="2" maxlength="8" 
	      placeholder="请输入用户名">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="lastname" class="col-sm-3 control-label">密码:</label>
	    <div class="col-sm-9">
	      <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <input type="button" class="btn btn-default" value="登录" onclick="login()" />
	    </div>
	  </div>
	</form>
</div>
</div>
<script type="text/javascript">
	function login() {
		$("#regForm").submit();
	}
</script>
</body>
</html>






