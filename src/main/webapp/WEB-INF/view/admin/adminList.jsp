<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <!-- 引入bootstrap的css样式 -->
 <link rel="stylesheet" href="/resource/bootstrap/css/bootstrap.css">  
 <!-- 引入平常的js -->
 <script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script> 
 <!-- 引入bootstrap的js -->
 <script type="text/javascript" src="/resource/bootstrap/js/bootstrap.js"></script>
 
 <!-- 首先是导航 -->
 <nav class="navbar navbar-default" role="navigation">
 	<div class="container-fluid">
 	<div class="navbar-header">
 		<a href="#" class="navbar-brand">输入姓名</a>
 	</div>
 	<div>
 		 <!-- navbar-form 应该就是在form里面加样式 -->
 		 <!-- navbar-left就是在导航栏左边  -->
		 <form class="navbar-form navbar-left" role="search">
		 	<div class="form-group">
		 		<input type="text" class="form-control" placeholder="Search" value="${mohu }">
		 	</div> 
		 	<!-- class="btn btn-default"就只是给按钮加上了样式 -->
		 	<input type="button" class="btn btn-default" value="查询"  onclick="search()">
		 </form>	
 	</div>
 	</div>
 </nav>
 
 <div class="table-responsive">
 	<table class="table">
 		<caption>用户列表</caption>
 		<thead>
 		   <tr >
	        <th>用户id</th>
	        <th>用户名称</th>
	        <th>注册日期</th>
	        <th>生日</th>
	        <th>性别</th>
	        <th>角色</th>
	        <th>状态</th>
	        <th>操作</th>
	       </tr>
 		</thead>
 		<tbody>
 			<c:forEach items="${info.list }" var="list">
 				<c:if test="${list.role==1 }">
 				<tr class="active">
 				</c:if>
 				<c:if test="${list.role!=1 }">
 				<tr>
 				</c:if>
			        <td>${list.id }</td>
			        <td>${list.username }</td>
			        <td><fmt:formatDate value="${list.create_time }" pattern="yyyy年MM月dd号"/></td>
			        <td><fmt:formatDate value="${list.birthday }" pattern="yyyy年MM月dd号"/></td>
			        <td>${list.gender.displayName }</td>
			        <td>${list.role==0?"用户":"管理员" }</td>
			        <td>${list.locked==1?"禁用":"正常" }</td>
			        <td>
			        	<c:if test="${list.locked==1 }">
			        		<input type="button" class="btn btn-info" value="正常" onclick="updateLocked(${list.id }, 0)" >
			        	</c:if>
			        	<c:if test="${list.locked!=1 }">
			        		<input type="button" class="btn btn-success" value="禁用" onclick="updateLocked(${list.id }, 1)">
			        	</c:if>
			        </td>
			     </tr>
 			</c:forEach>
 		</tbody>
 	</table>
 </div>
 
<ul class="pagination">
  <li> <a href="javascript:goPage(${info.prePage })">&laquo;</a> </li>
  	<c:forEach begin="${info.pageNum - 2 > 1?info.pageNum - 2 : 1 }" end="${info.pageNum + 2 > info.pages?info.pages:info.pageNum + 2 }" varStatus="index">
  		<li> <a href="javascript:goPage(${index.index })">${index.index }</a> </li>
  	</c:forEach>
  <li> <a href="javascript:goPage(${info.nextPage })">&raquo;</a> </li>
  <li><span>当前${info.pageNum } / ${info.pages }页</span></li>
</ul>
 <script type="text/javascript">	
 	/*第一个参数是用户ID， 第二个参数是需要改变的状态  */
	function updateLocked(userId, status) {
		$.post(
		"/admin/updateStatus",		
		{userId:userId, status:status},
		function(msg) {
			if(msg.result == 1) {
				alert("处理成功")
				$("#content").load("/admin/users?pageNum="+${pageNum}+"&mohu=${mohu}");
			} else {
				alert(msg.errorMsg)
			}
		}
		)
	}	
				
 	function search() {
		var a = $(".form-control").val();
		$("#content").load("/admin/users?mohu="+a)
	}
 
 	function goPage(page) {
		var url = "/admin/users?pageNum=" + page;
		$("#content").load(url)
	}
 	
</script>












 
 
 