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
		<form
			action="<%=path%>/teacherCourseModifyServlet?teaCourId=<%=request.getAttribute("teaCourId")%>"
			method="post">
			<table width="90%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table table-hover table-bordered">
				<tr>
					<td colspan="2" align="center" ><h4>课程名称不允许修改,只能修改课程和老师班级之间的关联</h4></td>
				</tr>
				<input type="hidden" name="id" id="id" value="${tc.getId() }"></input> 
				<tr>
					<td align="right"><strong>课程名称</strong></td>
					<td><select style="width:150px"  class="form-control" name="course">
						<c:forEach var="cour" items="${courList}">
							<c:choose>
								<c:when test="${cour.cId==tc.getCourseId()}">
									<option value="${cour.cId}" selected="selected">${cour.cName}</option>
								</c:when>
								<c:otherwise>
									<option value="${cour.cId}">${cour.cName}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td align="right"><strong>讲师姓名</strong></td>
					<td><select style="width:150px"  class="form-control" name="teacher">
							<c:forEach var="tea" items="${teaList}">
								<c:choose>
									<c:when test="${tea.tId==tc.gettId()}">
										<option value="${tea.tId}" selected="selected">${tea.tName}</option>
									</c:when>
									<c:otherwise>
										<option value="${tea.tId}">${tea.tName}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td align="right"><strong>负责班级</strong></td>
					<td><select style="width:150px"  class="form-control" name="stuclass">
							<c:forEach var="stucl" items="${stuclList}">
								<c:choose>
									<c:when test="${stucl.id==tc.getClassId()}">
										<option value="${stucl.id}" selected="selected">${stucl.className}</option>
									</c:when>
									<c:otherwise>
										<option value="${stucl.id}">${stucl.className}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						class="btn btn-default btn-success" value="修改课程关联"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>