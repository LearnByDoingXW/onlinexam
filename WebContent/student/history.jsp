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
<title>以往试卷成绩查询</title>
<%-- <link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" /> --%>
<link href="<%=path%>/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <div  style="padding: 10px 2px 2px 10px; " class="row">
	  <div  class="col-md-4 ">
	     <button  type="button" class="btn btn-info" title="以往试卷成绩查询"  
			data-container="body" data-toggle="popover" data-placement="right" 
			data-content="显示该学生以往试卷成绩信息">${user.stuName }，以往试卷成绩查询
	   </button>
	  </div>
	  <div class="col-md-4 ">
	  </div>
      <div  class="col-md-4 " >
        <form action="<%=path%>/pastTestServlet" method = "post">
				<div class="input-group">
				    <span class="input-group-addon">课程名称</span>
					<input type="text"  name= "courseSearch" class="form-control">
					<span class="input-group-btn">
						<button class="btn btn-default" type="submit">
							搜索
						</button>
					</span>
				</div><!-- /input-group -->	
				
		</form>
      </div>
	  
	</div>
	
	<br />
	<table width="90%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table table-hover table-bordered">
		<tr class="warning" align="center">
			<td width="138" >考试科目</td>
			<td width="162">试卷名称</td>
			<td width="162">考试时长</td>
			<td width="162">考试时间</td>
			<td width="162">考试得分</td>
		</tr>
		<c:forEach var="paper" items="${paperList}">
			<tr align="center">
				<td>${paper.cName}</td>
				<td><a href = '<%=path%>/paperDatilServlet?id=${paper.testId}'>${paper.testName}</a></td>
				<td>${paper.time}</td>
				<td>${paper.createDate}</td>
				<td>${paper.score}</td>
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