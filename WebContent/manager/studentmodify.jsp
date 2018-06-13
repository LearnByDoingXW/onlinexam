<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=path%>/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />

</head>

<body>
<h3 align="center">
	修改学生信息 &nbsp;&nbsp;&nbsp;&nbsp;学生编号${student.getStuId() }
</h3>

<div class="">
  <form action="<%=path %>/studentModifyServlet" method="post" name="form1" id="form1">
   <table width="90%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table table-hover table-bordered">
      <input type="hidden" readonly="readonly" name="id" id="id" value="${student.getStuId() }"/>
      <tr>
        <td align="right" ><strong>姓名：</strong></td>
        <td><label>
          <input type="text" style="width:150px"  class="form-control" name="name" id="name" value="${student.getStuName() }"/>
        </label></td>
      </tr>
      <tr>
        <td align="right"><strong>密码：</strong></td>
        <td><label>
          <input type="text" style="width:150px"  class="form-control" name="pwd" id="pwd" value="${student.getPwd() }" />
        </label></td>
      </tr>
            <tr>
        <td align="right"><strong>性别：</strong></td>
        <td ><label>
          <input type="radio" value="男"  name="sex"  <c:if test="${student.getSex() =='男' }">checked="checked"</c:if>/>男
          <input type="radio" value="女"  name="sex"  <c:if test="${student.getSex() =='女' }">checked="checked"</c:if>/>女
        </label></td>
      </tr>
            <tr>
        <td align="right"><strong>出生日期：</strong></td>
        <td ><label>
          <input type="text" style="width:150px"  class="form-control" name="born" id="born" value="${student.getBorn() }"/>
        </label></td>
      </tr>
            <tr>
        <td align="right"><strong>原学院：</strong></td>
        <td ><label>
          <input type="text" style="width:150px"  class="form-control" name="school" id="school" value="${student.getSchool() }"/>
        </label></td>
      </tr>
      <tr>
        <td align="right"><strong>课程方向：</strong></td>
        <td><select style="width:150px"  class="form-control" name="deptName"  >
        <c:forEach items="${deptList }" var="deptName">
          <option value='${deptName }'  <c:if test="${deptName ==student.getStuDeptName() }">selected="selected"</c:if> >${deptName }</option>
        </c:forEach>
        </select></td>
      </tr>
      <tr>
        <td align="right"><strong>所在班级：</strong></td>
        <td><select style="width:150px"  class="form-control" name="classId"  >
        <c:forEach items="${classList}" var="c">
          <option value='${c.id }'  <c:if test="${c.id==student.getClassId() }">selected="selected"</c:if> >${c.className }</option>
        </c:forEach>
        </select></td>
      </tr>
      <tr>
        <td></td>
        <td >
          <input type="submit" name="button" id="button" class="btn btn-default btn-success" value="提交" />
        </td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>