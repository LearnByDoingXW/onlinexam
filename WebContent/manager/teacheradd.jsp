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
<title>增加教师</title>
<link href="<%=path%>/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<div class="">
		<!-- 因为是增加，所以method="post" -->
		<form action="teacherAddServlet" method="post">
			<table width="90%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table table-hover table-bordered">
				<tr>
					<td align="right">教师名称：</td>
					<td ><input type="text" style="width:150px"  class="form-control" name="teaname" id="teaname"/></td>
				</tr>
				<tr>
					<td align="right">初始密码：</td>
					<td ><input type="text" style="width:150px"  class="form-control" name="tpwd" id="tpwd"/></td>
				</tr>
				<tr>
					<td align="right">所属方向</td>
					<td><select style="width:150px"  class="form-control" name="depInfo">
							<c:forEach var="dept" items="${depList}">
								<option value=${dept}>${dept}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td colspan="2" align="center" ><input type="submit" name="submit" class="btn btn-default btn-success" value="增加教师"
						class="btn_grey"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>