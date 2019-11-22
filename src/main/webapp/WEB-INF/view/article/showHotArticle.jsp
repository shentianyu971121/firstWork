<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<!-- Article 
[id=115, title=实打实大苏打, content=<img src="/pic/image/20191101/20191101104037_677.jpeg" alt="" />, 
picture=20191101/adf360da-6280-41bd-99af-b300ade0d7af.jpg, channelId=null, 
channel=Channel [id=3, name=国际, description=null, icon=null], categoryId=null, 
category=Category [id=11, name=欧洲, channelId=null, channel=null], userId=null, 
user=User [id=48, username=e1707D, password=76922b82b1b95b3baf1213e2e279604c, 
nickname=null, birthday=null, gender=A, locked=0, create_time=Fri Nov 01 10:21:12 CST 2019, 
update_time=null, url=null, score=0, role=0], hits=0, hot=1, status=1, deleted=0, 
created=Fri Nov 01 10:40:53 CST 2019, updated=Fri Nov 01 10:40:53 CST 2019, commentCnt=0, 
articleType=0]
 --><!-- 展示点击热门文章后的展示页面 -->
 <div class="container">
<div class="panel panel-success">
    <div class="panel-heading">
        <h3 class="panel-title">${article.title }</h3>
        <h4 class="panel-title">作者: ${article.user.username }</h4>
        <h4 class="panel-title">发布时间 :<fmt:formatDate value="${article.created }" pattern="yyyy-MM-dd"/></h4>
    </div>
    <div class="panel-body">
        	${article.content }
    </div>
    
</div>
	<div style="text-align: center">
        	<input type="button" style="margin-right: 50px"  value="上一篇" class="btn btn-warning" onclick="preArticle(${article.id})" >
        	<input type="button" value="下一篇" class="btn btn-warning" onclick="nextArticle(${article.id})">
    </div>
</div>
<script type="text/javascript">
function preArticle(id) {
	location = "/article/preArticle?id="+id;
}
function nextArticle(id) {
	location = "/article/nextArticle?id="+id;
}
</script>
</body>
</html>