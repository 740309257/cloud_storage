<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
	<title>Title</title>
	<link href="../../css/homepage_new.css" type="text/css" rel="stylesheet"/>
	<script type="text/javascript" src="../../js/lib/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="../../js/homepage_new.js"></script>
</head>

<body>
<%@ include file="header_new.jsp" %>
<div class="container" style="display: none">
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

		<div class="file_nav">
			<a href="">最近上传</a>
			<a href="">我的收藏</a>
			<a href="">垃圾箱</a>
		</div>

		<div class="search_bar">
			<form id="search_file" action="search_file" method="post">
				<select id="searchType" name="searchType">
					<option value="1">按名称</option>
					<option value="2">按时间</option>
					<option value="3">按大小</option>
				</select>
				<input id="searchContent" name="searchContent" type="text" placeholder="输入搜索内容">
				<input id="search_btn" type="button" value="提交">
			</form>
		</div>

		<div class="file_list">
			<table class="file_table">

				<tr>
					<th class="fname">文件名称</th>
					<th class="fsize">大小</th>
					<th class="ftype">类型</th>
					<th class="fupTime">上传时间</th>
					<th class="foper">操作</th>
				</tr>

				<tr>
					<td class="fname"><a href="">文件名称</a></td>
					<td class="fsize">大小</td>
					<td class="ftype">类型</td>
					<td class="fupTime">上传时间</td>
					<td class="foper"><a href="">下载</a>&nbsp;&nbsp;<a href="">更多</a></td>
				</tr>
				<tr>
					<td class="fname"><a href="">文件名称</a></td>
					<td class="fsize">大小</td>
					<td class="ftype">类型</td>
					<td class="fupTime">上传时间</td>
					<td class="foper"><a href="">下载</a>&nbsp;&nbsp;<a href="">更多</a></td>
				</tr>
				<tr>
					<td class="fname"><a href="">文件名称</a></td>
					<td class="fsize">大小</td>
					<td class="ftype">类型</td>
					<td class="fupTime">上传时间</td>
					<td class="foper"><a href="">下载</a>&nbsp;&nbsp;<a href="">更多</a></td>
				</tr>
				<tr>
					<td class="fname"><a href="">文件名称</a></td>
					<td class="fsize">大小</td>
					<td class="ftype">类型</td>
					<td class="fupTime">上传时间</td>
					<td class="foper"><a href="">下载</a>&nbsp;&nbsp;<a href="">更多</a></td>
				</tr>
				<tr>
					<td class="fname"><a href="">文件名称</a></td>
					<td class="fsize">大小</td>
					<td class="ftype">类型</td>
					<td class="fupTime">上传时间</td>
					<td class="foper"><a href="">下载</a>&nbsp;&nbsp;<a href="">更多</a></td>
				</tr>
				<tr>
					<td class="fname"><a href="">文件名称</a></td>
					<td class="fsize">大小</td>
					<td class="ftype">类型</td>
					<td class="fupTime">上传时间</td>
					<td class="foper"><a href="">下载</a>&nbsp;&nbsp;<a href="">更多</a></td>
				</tr>
				<tr>
					<td class="fname"><a href="">文件名称</a></td>
					<td class="fsize">大小</td>
					<td class="ftype">类型</td>
					<td class="fupTime">上传时间</td>
					<td class="foper"><a href="">下载</a>&nbsp;&nbsp;<a href="">更多</a></td>
				</tr>
				<tr>
					<td class="fname"><a href="">文件名称</a></td>
					<td class="fsize">大小</td>
					<td class="ftype">类型</td>
					<td class="fupTime">上传时间</td>
					<td class="foper"><a href="">下载</a>&nbsp;&nbsp;<a href="">更多</a></td>
				</tr>
				<tr>
					<td class="fname"><a href="">文件名称</a></td>
					<td class="fsize">大小</td>
					<td class="ftype">类型</td>
					<td class="fupTime">上传时间</td>
					<td class="foper"><a href="">下载</a>&nbsp;&nbsp;<a href="">更多</a></td>
				</tr>
				<tr>
					<td class="fname"><a href="">文件名称</a></td>
					<td class="fsize">大小</td>
					<td class="ftype">类型</td>
					<td class="fupTime">上传时间</td>
					<td class="foper"><a href="">下载</a>&nbsp;&nbsp;<a href="">更多</a></td>
				</tr>
				<tr>
					<td class="fname"><a href="">文件名称</a></td>
					<td class="fsize">大小</td>
					<td class="ftype">类型</td>
					<td class="fupTime">上传时间</td>
					<td class="foper"><a href="">下载</a>&nbsp;&nbsp;<a href="">更多</a></td>
				</tr>
				<tr>
					<td class="fname"><a href="">文件名称</a></td>
					<td class="fsize">大小</td>
					<td class="ftype">类型</td>
					<td class="fupTime">上传时间</td>
					<td class="foper"><a href="">下载</a>&nbsp;&nbsp;<a href="">更多</a></td>
				</tr>
				<tr>
					<td class="fname"><a href="">文件名称</a></td>
					<td class="fsize">大小</td>
					<td class="ftype">类型</td>
					<td class="fupTime">上传时间</td>
					<td class="foper"><a href="">下载</a>&nbsp;&nbsp;<a href="">更多</a></td>
				</tr>
				<tr>
					<td class="fname"><a href="">文件名称</a></td>
					<td class="fsize">大小</td>
					<td class="ftype">类型</td>
					<td class="fupTime">上传时间</td>
					<td class="foper"><a href="">下载</a>&nbsp;&nbsp;<a href="">更多</a></td>
				</tr>
				<tr>
					<td class="fname"><a href="">文件名称</a></td>
					<td class="fsize">大小</td>
					<td class="ftype">类型</td>
					<td class="fupTime">上传时间</td>
					<td class="foper"><a href="">下载</a>&nbsp;&nbsp;<a href="">更多</a></td>
				</tr>
				<tr>
					<td class="fname"><a href="">文件名称</a></td>
					<td class="fsize">大小</td>
					<td class="ftype">类型</td>
					<td class="fupTime">上传时间</td>
					<td class="foper"><a href="">下载</a>&nbsp;&nbsp;<a href="">更多</a></td>
				</tr>
				<tr>
					<td class="fname"><a href="">文件名称</a></td>
					<td class="fsize">大小</td>
					<td class="ftype">类型</td>
					<td class="fupTime">上传时间</td>
					<td class="foper"><a href="">下载</a>&nbsp;&nbsp;<a href="">更多</a></td>
				</tr>
				<tr>
					<td class="fname"><a href="">文件名称</a></td>
					<td class="fsize">大小</td>
					<td class="ftype">类型</td>
					<td class="fupTime">上传时间</td>
					<td class="foper"><a href="">下载</a>&nbsp;&nbsp;<a href="">更多</a></td>
				</tr>
				<tr>
					<td class="fname"><a href="">文件名称</a></td>
					<td class="fsize">大小</td>
					<td class="ftype">类型</td>
					<td class="fupTime">上传时间</td>
					<td class="foper"><a href="">下载</a>&nbsp;&nbsp;<a href="">更多</a></td>
				</tr>
				<tr>
					<td class="fname"><a href="">文件名称</a></td>
					<td class="fsize">大小</td>
					<td class="ftype">类型</td>
					<td class="fupTime">上传时间</td>
					<td class="foper"><a href="">下载</a>&nbsp;&nbsp;<a href="">更多</a></td>
				</tr>
				<tr>
					<td class="fname"><a href="">文件名称</a></td>
					<td class="fsize">大小</td>
					<td class="ftype">类型</td>
					<td class="fupTime">上传时间</td>
					<td class="foper"><a href="">下载</a>&nbsp;&nbsp;<a href="">更多</a></td>
				</tr>
				<tr>
					<td class="fname"><a href="">文件名称</a></td>
					<td class="fsize">大小</td>
					<td class="ftype">类型</td>
					<td class="fupTime">上传时间</td>
					<td class="foper"><a href="">下载</a>&nbsp;&nbsp;<a href="">更多</a></td>
				</tr>


			</table>

			<div class="pages">
				<p>共<span>5</span>页&nbsp;&nbsp;&nbsp;&nbsp;跳至第&nbsp;
					<input type="text" id="targetPage" name="targetPage"/>
					&nbsp;页&nbsp;&nbsp;
					<input id="targetPage_btn" type="button" value="走起"/>
				</p>
			</div>
		</div>
	</div>
	<div style="clear: both"></div>
</div>


<%@ include file="footer_new.jsp" %>

</body>
</html>
