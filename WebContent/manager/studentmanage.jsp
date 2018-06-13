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
	     <button  type="button" class="btn btn-info" title="学生管理"  
			data-container="body" data-toggle="popover" data-placement="right" 
			data-content="可以对学生的信息进行查看，修改和删除">学生管理
	   </button>
	  </div>
      <div  class="col-md-10 " >
        <div class="row">
        <form action="" method = "get">
				<div class="col-md-6">
				<a href="<%=path%>/studentAddServlet"><button type="button" class="btn btn-info" >增加学生</button></a>
				</div>
				
				<div style="padding: 0px; " class="col-md-6">
				  <div class="row">
				  <div class="input-group">	
				    <div class="col-md-4">		    
				   <input class="form-control" type="text" placeholder="学生名称" readonly>
				    
				    </div>
					<div  style="padding:0px; " class="col-md-6"	>
					
					<input type="text"   name="stuname" id="stuname" class="form-control">
					
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
			<td ><p>学生名称</p></td>
			<td ><p>密码</p></td>
			<td ><p>性别</p></td>
			<td ><p>出生日期</p></td>
			<td ><p>学校</p></td>
			<td ><p>班级名称</p></td>
			<td ><p>所属方向</p></td>
			<td ><p>修改操作</p></td>
			<td ><p>删除操作</p></td>
		</tr>
<!-- 页面元素的遍历可以使用jstl
1.导入jar包--jstl.jar,standard.jar
2.在页面导入一行代码
taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"
 -->
 <c:forEach var="stu" items="${stuList}">
 <tr align="center">
 	<td>${stu.stuName}</td>
 	<td>${stu.pwd}</td>
 	<td>${stu.sex}</td>
 	<td>${stu.born}</td>
 	<td>${stu.school}</td>
 	<td>${stu.className}</td>
 	<td>${stu.deptName}</td>
 	<td><a href="<%=path%>/studentModifyServlet?id=${stu.stuId}"><button type="button" class="btn btn-warning">修改</button></a></td>
 	<td><a href="<%=path%>/studentDeleteServlet?id=${stu.stuId}" onclick="javascript: return confirm('确认删除吗？');"><button type="button" class="btn btn-danger">刪除</button></a></td>
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