<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 1/23/2017
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <a  href="/register">注册</a>
  <br><br>
  <form  action="/search_user" method="post">
    搜索用户:<input id="search_user" name="search_user" type="text">
    <input type="submit">
  </form>

  <form  action="/search_file" method="post">
    搜索文件:<input id="search_file" name="search_file" type="text">
    <input type="submit">
  </form>


  <br><br>
  <form action="/verify" method="post">
    用户名：<input id="login_username" name="login_username" type="text">
    密码：<input id="login_password" name="login_password"  type="password">
    <input type="submit">
  </form>
  </body>
</html>
