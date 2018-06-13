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
	请仔细填写学生信息 
</h3>
<div class="">
  <form action="<%=path %>/studentAddServlet" method="post" name="form1" id="form1">
    <table width="90%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table table-hover table-bordered">
      <tr>
        <td align="right"><strong>学号：</strong></td>
        <td><label>
          <input type="text" style="width:150px"  class="form-control" name="id" id="id"/>
        </label></td>
      </tr>
      <tr>
        <td align="right"><strong>姓名：</strong></td>
        <td ><label>
          <input type="text" style="width:150px"  class="form-control" name="name" id="name" />
        </label></td>
      </tr>
      <tr>
        <td align="right"><strong>密码：</strong></td>
        <td><label>
          <input type="password" style="width:150px"  class="form-control" name="pwd" id="pwd"/>
        </label></td>
      </tr>
            <tr>
        <td align="right"><strong>性别：</strong></td>
        <td><label  >
          <input  type="radio" value="男"  name="sex"/>男
          <input  type="radio" value="女"  name="sex"/>女
        </label></td>
      </tr>
            <tr>
        <td align="right"><strong>出生日期：</strong></td>
        <td ><label>
          <input type="text" style="width:150px"  class="form-control" name="born" id="born" />
        </label></td>
      </tr>
            <tr>
        <td align="right"><strong>原学院：</strong></td>
        <td ><label>
          <input type="text" style="width:150px"  class="form-control" name="school" id="school" />
        </label></td>
      </tr>
      <tr>
        <td align="right"><strong>课程方向：</strong></td>
        <td><select style="width:150px"  class="form-control" name="deptName"  >
        <c:forEach items="${deptList }" var="deptName">
          <option value='${deptName }'>${deptName }</option>
        </c:forEach>
        </select></td>
      </tr>
      <tr>
        <td align="right"><strong>所在班级：</strong></td>
        <td><select style="width:150px"  class="form-control" name="classId"  >
        <c:forEach items="${classList }" var="c">
          <option value='${c.id }'>${c.className }</option>
        </c:forEach>
        </select></td>
      </tr>
      <tr>
        <td></td>
        <td>
          <input type="submit" name="button" id="button" class="btn btn-default btn-success" value="提交" />
        </td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>