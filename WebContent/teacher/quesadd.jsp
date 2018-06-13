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
<%-- <link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" /> --%>
<link href="<%=path%>/js/calendar-blue.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />

<script>
	function anscheck(eeId) {
		var a = document.getElementById("ans").value;
		var re = /^[A-D]{1,4}$/;
		if (re.test(a)) {
			return true;
		} else {
			var msg = "正确答案只能为大写英文！";
			showErrorMsg(msg, eeId);
			return false;
		}
	}
	function isNotNull(uuid) {
		var value = document.getElementById(uuid).value;
		if (value == null || value == "") {
			return false;
		} else {
			return true;
		}
	}
	function showErrorMsg(msg, eeId) {
		document.getElementById(eeId).style.display = "";
		document.getElementById(eeId).innerHTML = msg;
	}
	//当获得焦点 错误信息就不显示
	function clearErrorMsg(eId) {
		document.getElementById(eId).style.display = "none";
	}

	function verInput() {
		var obj = document.getElementById("type");
		var value = obj.selectedIndex;
		if (value == 2) {
			if (anscheck('ans_hint') && isNotNull('ques')
					&& isNotNull('choice_A') && isNotNull('choice_B')) {
				return true;
			} else {
				alert("添加失败，请将信息填写完整、正确！");
				return false;
			}
		} else {
			if (anscheck('ans_hint') && isNotNull('ques')
					&& isNotNull('choice_A') && isNotNull('choice_B')
					&& isNotNull('choice_C') && isNotNull('choice_D')) {
				return true;
			} else {
				alert("添加失败，请将信息填写完整、正确！");
				return false;
			}
		}
	}
	function selectChoice() {
		var obj = document.getElementById("type");
		var value = obj.selectedIndex;
		if (value == 2) {
			document.getElementById("choice_C").style.display = "none";
			document.getElementById("choice_D").style.display = "none";
		}
		if (value == 0 || value == 1) {
			document.getElementById("choice_A").style.display = "block";
			document.getElementById("choice_B").style.display = "block";
			document.getElementById("choice_C").style.display = "block";
			document.getElementById("choice_D").style.display = "block";
		}
	}
</script>
</head>

<body>
	<div class="">
		<form id="form1" name="form1" method="post"
			action="questionAddServlet" onsubmit="return verInput();">
			
			<table width="90%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table table-hover table-bordered">
				
				<tr>
					<td align="right"><Strong>科目：</Strong></td>
					<td><select  style="width:100px;" class="form-control" name="courseId" id="courseId">
							<c:forEach var="course" items="${courseList}">
								<option value="${course.cId}">${course.cName}</option>
							</c:forEach>
					</select></td>
					
				</tr>
				
				<tr>
					<td align="right"><strong>题目类型：</strong></td>
					<td><select style="width:110px;" class="form-control" name="queType" id="queType"
						onclick="selectChoice();">
							<option value="1" selected="selected">单项选择</option>
							<option value="2">多项选择</option>
                            <!-- <option value="3">判断对错</option> -->
					</select></td>
					
				</tr>
				<tr>
					<td align="right"><strong>题目：</strong></td>
					<td><label  > <textarea class="form-control" name="queTitle" id="queTitle"
								style="resize: none;"></textarea>
					</label></td>
					
				</tr>
				<tr>
					<td align="right"><strong>选项A：</strong></td>
					<td><label  > <input class="form-control" type="text" name="choiceA"
							id="choiceA" />
					</label></td>
					
				</tr>
				<tr>
					<td align="right"><strong>选项B：</strong></td>
					<td><label  > <input class="form-control" type="text" name="choiceB"
							id="choiceB" />
					</label></td>
					
				</tr>
				<tr>
					<td align="right"><strong>选项C：</strong></td>
					<td><label  > <input class="form-control" type="text" name="choiceC"
							id="choiceC" />
					</label></td>
				</tr>
				<tr>
					<td align="right"><strong>选项D：</strong></td>
					<td><label > <input class="form-control" type="text" name="choiceD"
							id="choiceD" />
					</label></td>
				</tr>
				<tr>
					<td align="right"><strong>正确答案：</strong></td>
					<td><label  > <input class="form-control" type="text" name="ans" id="ans" />
					</label></td>
					
				</tr>
				<tr>
					<td colspan="2" align="center"><label> <input
							type="submit" name="button" class="btn btn-default btn-success" id="button"
							value="增加试题" />
					</label></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>