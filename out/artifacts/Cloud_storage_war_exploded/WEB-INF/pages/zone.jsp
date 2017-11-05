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

<form action="/publish_message/${user_id}" method="post">
    <input name="text" id="text" type="text">
    <input type="submit" value="PUBLISH">
</form>

 <c:forEach items="${l_message}" var="message" varStatus="s" begin="0" end="${l_message.size()}">
    <tr>
        <td>
            <div>
                <p>${message.getPublisher_name()}</p>
            </div>
        </td>
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
</body>
</html>
