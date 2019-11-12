<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="/resource/bootstrap/css/bootstrap.css">  
 <script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script> 
 <script type="text/javascript" src="/resource/bootstrap/js/bootstrap.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>${info }</h1>
	<div class="container" style="background-color: skyblue">
		container
	</div>
	<div class="container-fluid" style="background-color: red">
		contaner-fluid
		<div class="row">
			<!-- md的大小长度为12 -->
			<div class="col-md-6 row" style="background: url(/resource/images/1.jpg) no-repeat; height: 300px">
				<div class="col-md-4"  style="background: url(/resource/images/2.jpg) no-repeat; height: 100px"></div>
				<div class="col-md-4"  style="background: url(/resource/images/2.jpg) no-repeat; height: 200px"></div>
				<div class="col-md-4"  style="background: url(/resource/images/2.jpg) no-repeat; height: 300px"></div>
			</div>
			<div class="col-md-6" style="background: url('/resource/images/3.jpg') no-repeat; height: 300px"></div>
		</div>
		
	</div>
</body>
</html>