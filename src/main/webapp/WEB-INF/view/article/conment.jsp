<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
<c:forEach items="${info.list }" var="list">

<div class="panel panel-danger">
    <div class="panel-heading">
        <h4  class="panel-title"><button type="button" class="btn btn-default btn-xs">
   	 <span class="glyphicon glyphicon-user"></span> User
</button>:${list.user.username }</h4>
        <h5>评论时间 :${list.created }</h5>
    </div>
    <div class="panel-body">
    ${list.user.username }说:${list.content }
    </div>
</div>
</c:forEach>
		共${info.total }条数据,当前${info.pageNum } / ${info.pages }页
		<a href="javaScript:goPage('/articleContent/hotSpeak?pageNum=1&articleId=${articleId }')">首页</a>
		<a href="javaScript:goPage('/articleContent/hotSpeak?pageNum=${info.prePage }&articleId=${articleId }')">上一页</a>
		<a href="javaScript:goPage('/articleContent/hotSpeak?pageNum=${info.nextPage }&articleId=${articleId }')">下一页</a>
		<a href="javaScript:goPage('/articleContent/hotSpeak?pageNum=${info.pages }&articleId=${articleId }')">尾页</a>

</div>
<!-- <div class="container" style="text-align: center; margin-top: 10px">

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid"> 
    <div class="navbar-header">
        
    </div>
    <form class="navbar-form navbar-left" role="search">
        <div class="form-group row" style="margin-top: 10px; margin-left:20px; font-size: 18px">
            <div class="col-md-11" >
            	
            </div>
        </div>
    </form>
    </div>
</nav>


<div> -->
<script type="text/javascript">
function goPage(url) {
	$("#content").load(url)
}
</script>
