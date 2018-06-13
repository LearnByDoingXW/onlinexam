<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=path%>/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="">
		<!-- 因为是增加，所以method="post" -->
		<form action="courseModifyServlet" method="post">
		<!-- 可以写一个新标签来存stuClass的id -->
		<input type="hidden" name="courseid" id="courseid" value="${course.getcId() }"></input>
			<table width="90%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table table-hover table-bordered">
				<tr>
					<td align="right"> 课程名称：</td>
					<td ><input style="width:150px"  class="form-control" type="text" name="courname" id="courname" value="${course.getcName()}"/></td>
				</tr>
				
				<tr>
				    <td></td>
					<td><input type="submit" name="submit" value="修改课程"
						class="btn btn-default btn-success"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>