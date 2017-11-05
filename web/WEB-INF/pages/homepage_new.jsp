<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
	<title>Title</title>
	<link href="../../css/homepage_new.css" type="text/css" rel="stylesheet">
</head>

<body>
<%@ include file="header_new.jsp" %>
<div class="left_box">
	<div id="folder_head">
		<p>文件夹列表</p>
	</div>
	<ul id="folder_list">
		<li>
			<div class="folder_li">
				<img src=""/>
				<a>默认</a>
			</div>
		</li>

		<li>
			<div class="folder_li">
				<img src=""/>
				<a>Folder1</a>
			</div>
		</li>

		<li>
			<div class="folder_li">
				<img src=""/>
				<a>我的文件夹和他的dqdqwdqdqwdqdwqd</a>
			</div>
		</li>
	</ul>
</div>
<div class="right_box">
	<p id="current_pos">当前位置</p>
	<div class="upload_btn">
		<a>
			<img src=""/>
			<span>上传文件</span>
		</a>
	</div>
</div>
</body>
</html>
