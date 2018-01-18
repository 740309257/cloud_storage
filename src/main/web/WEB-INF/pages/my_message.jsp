<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 1/25/2017
  Time: 10:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/publish_message/${id}" method="post">
    <input name="text" id="text" type="text">
    <input type="submit" value="PUBLISH">
</form>

<c:forEach items="${l_message}" var="post" varStatus="s" begin="0" end="${l_message.size()}">
    <tr>
        <td>
            <div>
                <p>${post.getPublisher_name()}</p>
            </div>
        </td>
        <td>
            <div class="tt">
                <p>${post.getText()}</p>
            </div>
        </td>
        <td>
            <a href="/comment/${post.getMessage_id()}">评论${post.getComment_num()}</a>
            <p>${post.getTime()}</p>
        </td>

    </tr>
</c:forEach>
</body>
</html>
