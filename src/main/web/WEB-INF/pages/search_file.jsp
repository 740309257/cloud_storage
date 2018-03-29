<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 1/24/2017
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${l_file}" var="one_file" varStatus="s" begin="0" end="${l_file.size()}">
    <tr>
        <td>
            <div class="tt">
                <p><a href=/download_file/${one_file.getFile_id()}>${one_file.getFilename()}</a></p>
            </div>
        </td>
    </tr>
</c:forEach>
</body>
</html>
