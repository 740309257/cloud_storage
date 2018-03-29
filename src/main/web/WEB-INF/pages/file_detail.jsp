<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 1/26/2017
  Time: 7:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>${m_file.get("filename")}</p>
<p>SIZE:${m_file.get("size")}</p>
<p>AUTHORITY:${m_file.get("authority")}</p>
<p>TYPE:${m_file.get("type")}</p>
<p>DATE:${m_file.get("date")}</p>
<p>最初由${m_file.get("username")}上传</p>
<br>
<br>
<br>
<p>设置权限:<a href="/set_file_auth?file_id=${m_file.get("file_id")}&auth=1">公开</a>
           <a href="/set_file_auth?file_id=${m_file.get("file_id")}&auth=0">私人</a>
</p>
<br>
<br>
<a href="/download_file/${m_file.get("file_id")}">下载</a>
<br>
<br>
重命名:
<form id="rename" action="/file_rename/${m_file.get("file_id")}" method="post">
    NEWNAME:<input name="new_name" id="new_name" type="text">
    <input type="submit">
</form>
<br>
<br>
<a href="/delete_file/${m_file.get("file_id")}">删除文件</a>
<br>
<br>
SHARE WITH:
<c:forEach items="${l_friend}" var="friend" varStatus="s" begin="0" end="${l_friend.size()}">
    <tr>

        <td>
            <a href="/share_file?id=${id}&target_id=${friend.getUser_id()}&file_id=${m_file.get("file_id")}">${friend.getUsername()}</a>
        </td>

    </tr>
</c:forEach>
</body>
</html>
