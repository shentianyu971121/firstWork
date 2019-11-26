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
</head>
<body>
<div class="container">
<div class="panel panel-success">
    <div class="panel-heading">
        <h2 class="panel-title">标题:${article.title }</h2>
        <h4 class="panel-title">作者: ${article.user.username }</h4>
        <h4 class="panel-title">发布时间 :<fmt:formatDate value="${article.created }" pattern="yyyy-MM-dd"/></h4>
    </div>
</div>
		<!-- 轮播 -->
<div id="myCarousel" class="carousel slide">
   <!-- 轮播（Carousel）指标 -->
   <ol class="carousel-indicators">
   <c:forEach items="${article.images }" var="img" varStatus="count">
      <li data-target="#myCarousel" data-slide-to="${count.index }" ${count.index == 0?'class="active"':'' }></li>
      </c:forEach>
   </ol>   
   <!-- 轮播（Carousel）项目 -->
   <div class="carousel-inner">
    <c:forEach items="${article.images }" var="img" varStatus="count">
      <div class="item  ${count.index == 0 ? 'active':'' }">
         <img style="height: 700px; width: 1150px"  src="/pic/${img.url }" alt="First slide" title="${img.desc }">
         <div class="carousel-caption"></div>
      </div>
      </c:forEach>
   </div>
   <!-- 轮播（Carousel）导航 -->
   <a class="carousel-control left" href="#myCarousel" 
      data-slide="prev">&lsaquo;</a>
   <a class="carousel-control right" href="#myCarousel" 
      data-slide="next">&rsaquo;</a>
     </div>	
     </div>
</body>
</html>


