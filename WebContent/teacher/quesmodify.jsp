<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ page import="java.util.Map.Entry"%>

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
			action='<%=path%>/questionModifyServlet'
			onsubmit="return verInput();">
			<input type="hidden" name = "id" value = "${questionMap.id}"/>
			<table width="462" border="0" align="center" class="table table-hover table-bordered">
				<tr>
					<td align="right"><strong>科目：</strong></td>
					<td><select style="width:110px;" class="form-control"  name="courseId" id="courseId">
							<c:forEach var="course" items="${courseList}">
								<c:choose>
									<c:when test="${course.cId == questionMap.courseId}">
										<option value=${course.cId } selected="selected">${course.cName}</option>
									</c:when>
									<c:otherwise>
										<option value=${course.cId }>${course.cName}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select></td>
			
				</tr>
				<tr>
					<td align="right"><strong>题目类型：</strong></td>
					<td><select style="width:110px;" class="form-control" name="queType" id="queType">
					    <%-- <% Iterator<Entry<String, Object>> it = questionMap.entrySet().iterator();

			             while (it.hasNext()) {
				              Entry<String, Object> entry = it.next();
				             System.out.print(entry.getKey() + "@@@" + entry.getValue() + "\t");
			                        }%> --%>
					        <option value="1" selected="selected">单项选择</option>
					        <option value="2" ">多项选择</option>
					</select></td>
					
				</tr>
				<tr>
					<td align="right"><strong>题目：</strong></td>
					<td ><label> <textarea class="form-control" name="queTitle"
								id="queTitle" style="resize: none;">${questionMap.queTitle}</textarea>
					</label></td>
					
				</tr>
				<tr>
					<td align="right"><strong>选项A：</strong></td>
					<td><label> <input class="form-control" type="text" name="choiceA"
							id="choiceA" value='${questionMap.choiceA}' />
					</label></td>
					
				</tr>
				<tr>
					<td align="right"><strong>选项B：</strong></td>
					<td><label> <input class="form-control" type="text" name="choiceB"
							id="choiceB" value='${questionMap.choiceB}' />
					</label></td>
				
				</tr>
				<tr>
					<td align="right"><strong>选项C：</strong></td>
					<td><label> <input class="form-control" type="text" name="choiceC"
							id="choiceC" value='${questionMap.choiceC}' />
					</label></td>
					
				</tr>
				<tr>
					<td align="right"><strong>选项D：</strong></td>
					<td><label> <input class="form-control" type="text" name="choiceD"
							id="choiceD" value='${questionMap.choiceD}' />
					</label></td>
					
				</tr>
				<tr>
					<td align="right"><strong>正确答案：</strong></td>
					<td><label> <input class="form-control" type="text" name="ans" id="ans"
							value='${questionMap.ans}' />
					</label></td>
					
				</tr>
				<tr>
					<td colspan="3" align="center"><label> <input
							 type="submit" name="button" id="button" class="btn btn-default btn-success"
							value="修改试题" />
					</label></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>