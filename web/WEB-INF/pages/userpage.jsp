<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 1/24/2017
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${user.getUsername()}
<p>他的动态</p>
<c:forEach items="${l_message}" var="message" varStatus="s" begin="0" end="${l_message.size()}">
    <tr>
        <td>
            <div class="tt">
                <p>${message.getText()}</p>
            </div>
        </td>
        <td>
            <a href="/comment/${message.getMessage_id()}">评论${message.getComment_num()}</a>
            <p>${message.getTime()}</p>
        </td>

    </tr>
</c:forEach>
<br>
<br>
<br>
<br>
<p>他的文件</p>
<c:forEach items="${l_file}" var="file" varStatus="s" begin="0" end="${l_file.size()}">
    <tr>

        <td>
            <p>${file.getFilename()}</p>
            <a href="/fork_file/${file.getFile_id()}">Fork</a>
        </td>

    </tr>
</c:forEach>
<br>
<br>

<p>他的好友</p>
<c:forEach items="${l_friend}" var="friend" varStatus="s" begin="0" end="${l_friend.size()}">
    <tr>

        <td>
            <a href="/userpage/${friend.getUser_id()}">${friend.getUsername()}</a>
        </td>

    </tr>
</c:forEach>
<br>
<br>

<a href="/apply_friend/${user.getUser_id()}">添加好友</a>

</body>
</html>
