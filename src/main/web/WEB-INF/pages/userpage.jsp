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
    <script src="<%=request.getContextPath()%>/js/lib/jquery-1.8.2.min.js"></script>
    <script>
        function is_ok(obj,url,id) {
            $.ajax({
                cache: true,
                type: "POST",
                url:url,
                data: {"id":id},

                success: function(res) {
                    if (res== "true"){
                        alert("成功");
                    }else{
                        alert("操作失败");
                    }
                }
            });
        }
        </script>
</head>
<body>
${user.getUsername()}
<p>他的动态</p>
<c:forEach items="${l_message}" var="post" varStatus="s" begin="0" end="${l_message.size()}">
    <tr>
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
<br>
<br>
<br>
<br>
<p>他的文件</p>
<c:forEach items="${l_file}" var="file" varStatus="s" begin="0" end="${l_file.size()}">
    <tr>

        <td>
            <p>${file.getFilename()}</p>
            <input type="button" value="FORK" onclick="is_ok(this,'/fork_file','${file.getFile_id()}')"/>
        </td>

        <td>
            <p>${file.getDate()}</p>
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

<input type="button" value="请求添加好友" onclick="is_ok(this,'/apply_friend','${user.getUser_id()}')"/>

</body>
</html>
