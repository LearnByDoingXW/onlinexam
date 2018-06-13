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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>增加试题</title>
<%-- <link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" /> --%>
<link href="<%=path%>/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.text2 {
	width: 700px;
	line-height: 40px;
	font-size: 16px;
	font-family: Arial, "宋体";
	margin: 0 auto;
	margin-top: 20px;
}

.paging {
	font-family: Arial, "宋体";
	font-size: 12px;
}
-->
</style>
</head>

<body>
     <div  style="padding: 10px 2px 2px 10px; " class="row">
	  <div  class="col-md-1 ">
	     <button  type="button" class="btn btn-info" title="题库管理"  
			data-container="body" data-toggle="popover" data-placement="right" 
			data-content="题库管理">题库管理
	   </button>
	  </div>
      <div  class="col-md-10 " >
        <div class="row">
        <form action="<%=path%>/questionQueryServlet" method = "get">
				<div class="col-md-6">
				<a href='<%=path%>/questionAddServlet'><button type="button" class="btn btn-info" >增加试题</button></a>
				</div>
				
				<div style="padding: 0px; " class="col-md-6">
				  <div class="row">
				  <div class="input-group">	
				    <div class="col-md-4">		    
				    <select name="selectk" id="selectk" class="form-control">
					<option selected="selected" value="cName">课程科目</option>
					<option value="queTitle">试题题目</option>
				    </select> 
				    </div>
					<div  style="padding:0px; " class="col-md-6"	>
					
					<input type="text"  name="searchName" id="searchName" class="form-control">
					
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
	
	
	
	<table width="90%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table table-hover table-bordered">
		<tr align="center">
			<td><b>题号</b></td>
			<td><b>考试科目</b></td>
			<td><b>题型</b></td>
			<td><b>题干</b></td>
			<td><b>选项</b></td>
			<td><b>答案</b></td>
			<td><b>操作</b></td>
		</tr>
		<c:forEach var="que" items="${queList}">
			<tr align="left">
				<td width="10">${que.id}</td>
				<td width="20">${que.cName}</td>
				<c:choose>
				  <c:when test="${que.queType==1}">
				    <td width="20"></>单选题</td>
				  </c:when>
				  <c:otherwise>
				    <td width="20"></>多选题</td>
				  </c:otherwise>
				</c:choose>
				<td width="40">${que.queTitle}</td>
				<td width="150"><p>A. ${que.choiceA}
						&nbsp;&nbsp;&nbsp;&nbsp; B. ${que.choiceB}</p>
					<p>C. ${que.choiceC} &nbsp;&nbsp;&nbsp;&nbsp; D. ${que.choiceD}</p></td>
				<td width="30" align="center">${que.ans}</td>
				<td width="30"><a
					href='<%=path%>/questionModifyServlet?id=${que.id}'><button type="button" class="btn btn-warning">修改</button></a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a href='<%=path%>/questionDeleteServlet?id=${que.id}'onclick="javascript: return confirm('确认删除试题吗？');"><button type="button" class="btn btn-danger">刪除</button></a></td>
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