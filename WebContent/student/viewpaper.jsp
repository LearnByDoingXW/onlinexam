<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.hp.onlinexam.po.Questions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- 查看试卷时候使用 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
<style>
p {
	text-indent: 2em;
}
</style>
</head>

<body>
	<div id="main_content">
		<form id="form1" name="form1" method="post" action="<%=path%>/pastTestServlet">
			<h1>
				<center>
					试卷名称：${test.testName}<br />
				</center>
			</h1>
			<h3>
				<center>
					考试科目：${test.cName}<br />
					考试班级：${test.className}<br /> 
					考试截止时间：${test.endDate}<br />
					考试时长：${test.testTime}min<br />
				</center>
			</h3>
			<p>
				<b>单项选择题</b>
			</p>
			<c:forEach var="que" items="${quesList}" varStatus="status">

				<p></p>
				<p class="text">${status.index + 1} .${que.getQueTitle()}</p>
				<p></p>

				<p>A.${que.getChoiceA() }</p>
				<p>B.${que.getChoiceB() }</p>
				<p>C.${que.getChoiceC() }</p>
				<p>D.${que.getChoiceD() }</p>
				<p>
					<font color="blue"> 错误答案：${test.wrongAns }</font>
				</p>
				<p>
					<font color="blue"> 正确答案：${que.getAns() }</font>
				</p>
			</c:forEach>

			<p class="text"></p>
			<p>&nbsp;</p>
			<label>
				<center>
					<input type="submit" name="button" id="button" class="btn_grey"
						value="返回" />
				</center>
			</label>
		</form>
	</div>
</body>
</html>