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
<link href="<%=path%>/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<div class="">
		<form action="<%=path%>/teacherCourseAddServlet" method="post">
			<table width="90%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table table-hover table-bordered">
				<tr>
					<td align="right">课程名称</td>
					<td><select style="width:150px"  class="form-control" name="course">
							<c:forEach var="course" items="${courseList}">
								<option value="${course.cId}">${course.cName}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td align="right">讲师姓名</td>
					<td><select style="width:150px"  class="form-control" name="teacher">
							<c:forEach var="tea" items="${teaList}">
								<option value="${tea.tId}">${tea.tName}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td align="right">负责班级</td>
					<td><select style="width:150px"  class="form-control" name="stuclass">
							<c:forEach var="stucl" items="${stuclList}">
								<option value="${stucl.id}">${stucl.className}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
				    <td></td>
					<td ><input type="submit"  class="btn btn-default btn-success"
						value="提交班级排课信息"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>