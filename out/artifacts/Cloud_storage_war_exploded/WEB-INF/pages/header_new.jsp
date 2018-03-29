<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/4 0004
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
	<style>
		html {
			font-size: 10px;
		}

		a {
			cursor: pointer;
		}

		* {
			margin: 0;
			padding: 0;
			border: 0;
			text-align: center;
		}

		#header {
			width: 100%;
			min-width: 100rem;
			height: 5.0rem; 
			color: #676262;
			border-radius: 0.2rem;
			background-color: #E8E7E3;
			display: none;
		}

		.header_left {
			width: 20rem;
			height: 100%;
			float: left;
		}

		.header_left img {
			position: absolute;
			width: 10rem;
			height: 4rem;
			top: 0.5rem;
			left: 1rem;
		}

		.header_nav {
			height: 100%;
			float: left;
		}

		.header_nav ul {
			height: 100%;
			list-style-type: none;
			float: left;
			font-size: 1.8rem;
		}

		.header_nav ul li {
			height: 100%;
			margin: 0 0.3rem;
			float: left;
		}

		.header_nav ul li a {
			height: 100%;
			width: auto;
			display: block;
			line-height: 5.0rem;
			text-align: center;
			padding: 0 1rem;
			box-sizing: border-box;
			color: #27A9E3;
		}

		.header_nav ul li a:hover, .header_nav ul li a:active {
			background-color: darkgrey;
			border-bottom: 0.3rem solid #5a5757;
			color: black;
		}

		.header_right {
			height: 60%;
			width: 8rem;
			float: right;
			margin-right: 2rem;
			margin-top: 1.2rem;
			margin-bottom: 0.8rem;
			background-color: #c5c0c0;
			border-radius: 0.6rem;
		}

		.header_right a {
			height: 100%;
			line-height: 3rem;
			display: block;
			font-size: 1.6rem;
			text-decoration: none;
			color: white;
			border-radius: 0.6rem;
		}

		.header_right a:hover{
			background-color: #5a5757;
			color: black;
		}

		#up_btn{
			position: absolute;
			width: 1rem;
			height: 1rem;
			right: 0.3rem;
			top: 4rem;
			cursor: pointer;
			display: none;
		}

		#down_btn{
			position: absolute;
			width: 1rem;
			height: 1rem;
			right: 0.3rem;
			top: 0;
			cursor: pointer;
			display: none;
		}
	</style>
</head>
<body>
<div id="header">
	<div class="header_left">
		<a href="" target="_blank">
			<img src="../../images/aiwrap.png" alt="fuck">
		</a>
	</div>
	<div class="header_nav">
		<ul class="nav_ul">
			<li><a href="">首页</a></li>
			<li><a href="">文件管理</a></li>
			<li><a href="">营销中心</a></li>
			<li><a href="">财务中心</a></li>
			<li><a href="">设置中心</a></li>
		</ul>
	</div>

	<div class="header_right">
		<a class="logout" href="">退出登录</a>
	</div>


</div>
<img id="down_btn" src="../../images/down.jpg">
<img id="up_btn"   src="../../images/up.jpg"/>
</body>
</html>
