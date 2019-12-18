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
 <!-- 设置validate插件 -->
 <script type="text/javascript" src="/resource/js/jquery.validate.js"></script>
<title>欢迎加入管理系统</title>
</head>
<body>
<div class="container" style=" background-color:#6fc87e; vertical-align: middle;" align="center">
<div style="boder:1px #ccc solid; width:400px;height:400px;">
			
<form class="form-horizontal" id="regForm" role="form" method="post">
	  <div class="form-group" style="margin-top: 100px">
	    <label for="firstname" class="col-sm-3 control-label">用户名:</label>
	    <div class="col-sm-9">
	      <input type="text" class="form-control" id="username" 
	      name="username" minlength="2" maxlength="8"  remote="/loginOrRegister/getUsername"
	      placeholder="请输入用户名">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="lastname" class="col-sm-3 control-label">密码:</label>
	    <div class="col-sm-9">
	      <input type="password" maxlength="6" class="form-control" id="password" name="password" placeholder="请输入密码">
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <input type="button" class="btn btn-default" value="注册" onclick="register()" />
	    </div>
	  </div>
	</form>
	
</div>
	<div>
		<p>已有帐号?&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a  style="font-size: 24px" href="/loginOrRegister/login">去登录</a></p>
	</div>

</div>
<script type="text/javascript">
//reForm需要校验的话 校验规则可以在函数内部  页可以直接卸载标签的属性上
	$("#regForm").validate();

function register() {
	$("#regForm").submit();
}

</script>




</body>
</html>