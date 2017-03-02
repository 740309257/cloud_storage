<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 1/25/2017
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${l_comment}" var="comment" varStatus="s" begin="0" end="${l_comment.size()}">
    <tr>
        <td>
            <div>
                <p>${comment.getUsername()}</p>
            </div>
        </td>
        <td>
            <div class="tt">
                <p>${comment.getText()}</p>
            </div>
        </td>

    </tr>
</c:forEach>
<br>
<br>
<br>

<form action="/publish_comment/${sessionScope.get("USERID")}" method="post">
    <input name="message_id" id="message_id" value="${message_id}" type="text" hidden>
    <input name="text" id="text" type="text">
    <input type="submit" value="PUBLISH">
</form>

</body>
</html>
