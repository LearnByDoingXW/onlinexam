<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%-- <link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" /> --%>
<link href="<%=path%>/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />

</head>
<body>
  <div  style="padding: 10px 2px 2px 10px; " class="row">
	  <div  class="col-md-1 ">
	     <button  type="button" class="btn btn-info" title="课程管理"  
			data-container="body" data-toggle="popover" data-placement="right" 
			data-content="可以对课程的信息进行查看，修改和删除">课程管理
	   </button>
	  </div>
      <div  class="col-md-10 " >
        <div class="row">
        <form action="" method = "get">
				<div class="col-md-6">
				<a href="<%=path%>/courseAddServlet"><button type="button" class="btn btn-info" >增加课程</button></a>
				</div>
				
				<div style="padding: 0px; " class="col-md-6">
				  <div class="row">
				  <div class="input-group">	
				    <div class="col-md-4">		    
				   <input class="form-control" type="text" placeholder="课程名称" readonly>
				    
				    </div>
					<div  style="padding:0px; " class="col-md-6"	>
					
					<input type="text"   name="coursename" id="coursename" class="form-control">
					
					</div>
					
					<div style="padding:0px; " class="col-md-2">
					<span class="input-group-btn">
						<button class="btn btn-default btn-success" type="submit">
							搜索
						</button>
					</span>
					</div>
				</div><!-- /input-group -->	
				 
				    </div>
						
				</div>	
		</form>
		</div>
      </div>
	  
	</div>
	
	<br />
<table width="90%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table table-hover table-bordered">
		<tr align="center">
			<td ><b>课程ID</b></td>
			<td ><b>课程名称</b></td>
			<td ><b>修改操作</b></td>
			<td ><b>删除操作</b></td>
		</tr>
<!-- 页面元素的遍历可以使用jstl
1.导入jar包--jstl.jar,standard.jar
2.在页面导入一行代码
taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"
 -->
 <c:forEach var="c" items="${cList}">
 <tr align="center">
 	<td>${c.cId}</td>
 	<td>${c.cName}</td>
 	<td><a href="<%=path%>/courseModifyServlet?id=${c.cId}"><button type="button" class="btn btn-warning">修改</button></a></td>
 	<td><a href="<%=path%>/courseDeleteServlet?id=${c.cId}" onclick="javascript: return confirm('确认删除吗？');"><button type="button" class="btn btn-danger">刪除</button></a></td>
 </tr>
 </c:forEach>
</table>
<script src="<%=path%>/bootstrap/jquery-3.2.1.js"></script>
	<script src="<%=path%>/bootstrap/js/bootstrap.js"></script>
	<script>
$(function () { 
	$("[data-toggle='popover']").popover();
});
</script>
</body>
</html>