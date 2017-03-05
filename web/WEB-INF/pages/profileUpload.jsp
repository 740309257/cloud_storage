<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/5/2017
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传头像</title>
</head>
<body>
<form enctype="multipart/form-data" method="post" action="/profileUpload/${user_id}">
    <input type="file" name="profile">
    <input type="submit" value="提交">
</form>

</body>
</html>
