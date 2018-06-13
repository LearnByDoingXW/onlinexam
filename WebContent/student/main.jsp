<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
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
<title></title>
<%-- <link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" /> --%>
<link href="<%=path%>/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />


</head>

<body>
	<div  style="padding: 10px 2px 2px 10px; " class="row">
	  <div  class="col-md-4 ">
	     <button  type="button" class="btn btn-info" title="近期考试"  
			data-container="body" data-toggle="popover" data-placement="right" 
			data-content="显示该学生近期考试信息">近期考试
	   </button>
	  </div>
      <div  class="col-md-8 " >
        <span class="pull-right" ><p class="text-success text-center"><strong>邻近期末，祝大家都能取得好成绩！</strong></></span>
      </div>
	  
	</div>
	<br/>
	<table width="90%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table table-hover table-bordered">
		<tr class="warning" align="center">
			<td><b>考试科目</b></td>
			<td><b>考试名称</b></td>
			<td><b>考试截止时间</b></td>
			<td width="81"><b>进入考试</b></td>
		</tr>

		<c:forEach items="${testsList}" var="test">
			<tr align="center">
				<td width="113">${test.cName }</td>
				<td width="260">${test.testName }</td>
				<td width="220">${test.endDate }</td>
				<td width="81"><a href='studentTest?testId=${test.id}' target="_parent"><button type="button" class="btn btn-warning">开始考试</button></a></td>
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
