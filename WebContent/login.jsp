<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
<head>
<base href="<%=basePath%>">

<title>login.jsp</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link href="css/style1.css" type="text/css" rel="stylesheet">

<link href="bootstrap/css/bootstrap.css" rel="stylesheet"
	type="text/css">

<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<!-- <link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous"> -->

<script type="text/javascript">
	if (window != top) {
		top.location.href = location.href;
	}
</script>

<style>
body {
	color: #fff;
	font-family: "微软雅黑";
	font-size: 14px;
}

.wrap1 {
	position: absolute;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	margin: auto
} /*把整个屏幕真正撑开--而且能自己实现居中*/
.main_content {
	background: url(images/main_bg.png) repeat;
	margin-left: auto;
	margin-right: auto;
	text-align: left;
	float: none;
	border-radius: 8px;
}

.form-group {
	position: relative;
}

.login_btn {
	display: block;
	background: #3872f6;
	color: #fff;
	font-size: 15px;
	width: 100%;
	line-height: 50px;
	border-radius: 3px;
	border: none;
}

.login_input {
	width: 100%;
	border: 1px solid #3872f6;
	border-radius: 3px;
	line-height: 40px;
	padding: 2px 5px 2px 30px;
	background: none;
}

.icon_font {
	position: absolute;
	bottom: 15px;
	left: 10px;
	font-size: 18px;
	color: #3872f6;
}

.font16 {
	font-size: 16px;
}

.mg-t20 {
	margin-top: 20px;
}

@media ( min-width :200px) {
	.pd-xs-20 {
		padding: 20px;
	}
}

@media ( min-width :768px) {
	.pd-sm-50 {
		padding: 50px;
	}
}

#grad {
	background: -webkit-linear-gradient(#4990c1, #52a3d2, #6186a3);
	/* Safari 5.1 - 6.0 */
	background: -o-linear-gradient(#4990c1, #52a3d2, #6186a3);
	/* Opera 11.1 - 12.0 */
	background: -moz-linear-gradient(#4990c1, #52a3d2, #6186a3);
	/* Firefox 3.6 - 15 */
	background: linear-gradient(#4990c1, #52a3d2, #6186a3); /* 标准的语法 */
}
</style>
</head>

<body style="background: url(img/bg.jpg) no-repeat ;background-size:cover;">
	<div class="container wrap1" style="height: 450px;">
		<h2 class="mg-b20 text-center">学生在线考试系统登录页面</h2>
		<div
			class="col-sm-8 col-md-5 center-auto pd-sm-50 pd-xs-20 main_content">
			<p class="text-center font16">用户登录</p>
			<form action="loginServlet" method="post">
				<div class="form-group mg-t20">
					<i class="icon-user icon_font"></i> <input type="text"
						name="username" id="username" class="login_input"
						placeholder="请输入用户名" />
				</div>
				<div class="form-group mg-t20">
					<i class="icon-lock icon_font" ></i> <input type="password"
						name="password" id="password" class="login_input"
						placeholder="请输入密码" />
				</div>
				<div>
					<label> <select class="form-control" style="width: 100px" name="role" id="role">
							<option value="admin" selected="selected">管理员</option>
							<option value="teacher">教师</option>
							<option value="student">学生</option>

					</select>
					</label>
				</div>
				<div class="checkbox mg-b25">
					<label> <input type="checkbox" />记住我的登录信息
					</label>
				</div>
				<input type="submit" name="Submit" class="btn btn-default" style="width:100px"  value="登录" />
			   <input type="reset" name="Submit"  class="btn btn-default" style="width:100px" value="重置" />
			</form>
		</div>
		<!--row end-->
	</div>
	<!--container end-->

	<script src="bootstrap/jquery-3.2.1.js"></script>
	<script src="bootstrap/js/bootstrap.min.js">
		
	</script>

</body>
</html>
