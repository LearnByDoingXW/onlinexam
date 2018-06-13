<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %> 
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<%-- <link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" /> --%>
<link href="<%=path%>/js/calendar-blue.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />


</head>

<body>
	<form id="form1" name="form1" role="form" method="post"
		onsubmit="return InputM();"
		action='<%=path%>/testAddServlet'>
		
	
		<div class="">
			<table width="90%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="table table-hover table-bordered">
			<tr >
			<td align="right">
			 <p  ><strong>考试科目为：</strong></p>
			</td>
			<td>
			<p>
				<label > <select class="form-control" name="courseid" id="courseid" >
						<c:forEach var="course" items="${courseList }">
							<option value="${course.cId}">${course.cName}</option>
						</c:forEach>
				</select>
				</label>
			</p>
			</td>
            </tr>
            
            <tr >
			<td align="right">
			 <p><strong>试卷名称为：</strong></p>
			</td>
			<td>
			<p>
				 <label> <input type="text" class="form-control" name="testname"
					id="testname" onblur="isNotNull('testname');" />
				</label>
				 <br/>
			</p>
			</td>
			</tr>
			
		    <tr >
			<td align="right">
			 <p><strong>考试截止时间为：</strong> </p>
			</td>
			<td>
			<p>
				<label><input class="form-control" name="enddate" type="text"
					id="control_date" size="20" maxlength="10" readonly="readonly"
					value='' />
					 </label><br />
			</p>
            </td>
            </tr>
           
            <tr >
			<td align="right">
			 <p><strong>单项选择题 ，</strong></p>
			</td>
			<td>
			<p>
				（共<input  name="sinscores" id="sinscores" type="text" size="1"
					onblur="isNotNull('sinscores');" />分） &nbsp;&nbsp; <label><input
					class="form-control" name="sinnum" type="text" id="sinnum" size="5"
					onblur="isNotNull('sinnum');" /></label> 道小题 <br />
			</p>
	        </td>
	        </tr>
			
		    <tr >
			<td align="right">
			 <p><strong>考试时间： </strong></p>
			</td>
			<td>
			<p>
				<label><input class="form-control" name="testtime" id="testtime" value="45"
					type="text" size="5" onblur="isNotNull('testtime')" /></label>分钟
			</p>
            </td>
            </tr>
            
            <tr >
            <td align="right">
			 <p><strong>面向班级：</strong> </p>
			</td>
			<td>
			
			<p>	
				<c:forEach var="stuclass" items="${classesList}">
					<input type="checkbox"  name="classCheck" value="${stuclass.getId()}" checked="checked"/>${stuclass.getClassName()}
				</c:forEach>
			</p>
	        </td>
	        </tr>
			
		   <tr >
			<td  colspan="2">
			<p align="center">
				<input type="submit" class="btn btn-default btn-success " value="自动出题" />&nbsp;&nbsp;&nbsp;&nbsp;<br />
			</p>
		    </td>
		    </tr>
			</table>
		</div>
		
	</form>
	<p>
<script type="text/javascript" src="<%=path%>/js/calendar.js"></script>
<script>
Calendar.setup({
inputField : "control_date",
ifFormat : "%Y-%m-%d %H:%M:%S",
showsTime : true,
timeFormat : "24"
});
</script>
	</p>
</body>${hint }
</html>