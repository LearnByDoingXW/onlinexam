<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%-- <link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" /> --%>
<link href="<%=path%>/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
<title>教师班级评估</title>
<style>
</style>
 
</head>

<body>
	<div  style="padding: 10px 2px 2px 10px; " class="row">
	  <div  class="col-md-4 ">
	     <button  type="button" class="btn btn-info" title="班级成绩汇总"  
			data-container="body" data-toggle="popover" data-placement="right" 
			data-content="统计每个考试各班级的考试情况">班级成绩汇总
	   </button>
	  </div>
      <div  class="col-md-8 " >
        <span class="pull-right" ><p class="text-success text-center"><strong>邻近期末，祝老师身体健康！</strong></></span>
      </div>
	  
	</div>
	
	
	<br />
	<table width="90%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table table-hover table-bordered">
		<tr class="warning" align="center">
			<td><b>班级</b></td>
			<td><b>考试科目</b></td>
			<td><b>考试名称</b></td>
			<td><b>考试截止时间</b></td>
			<td><b>方向</b></td>
			<td><b>班级平均分</b></td>
		</tr>
		<c:forEach var="paper" items="${paperList }">
			<tr align="center">
				<td>${paper.className }</td>
				<td>${paper.courseName }</td>
				<td>${paper.testName }</td>
				<td>${paper.endDate }</td>
				<td>${paper.deptName }</td>
				<td>${paper.avgScore }</td>
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