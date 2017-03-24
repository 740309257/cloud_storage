<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 1/24/2017
  Time: 10:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <script src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
    <script>
        function isDone(obj,url,id,date) {
            $.ajax({
                type:"post",
                url:url,
                data: {"id":id,"date":date},
                success: function (res) {
                    if (res== "true"){
                        alert("成功");
                        window.location.href="http://localhost:8080/homepage/"+${user.getUser_id()};
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
<img src="/get_profile/${user.getUser_id()}" height="50px" width="50px">
<a href="/profile_upload_page/${user.getUser_id()}">更改头像</a>
<br>
<a href="/file_upload_page/${user.getUser_id()}">上传文件</a>
<br>
<p>有无分享</p>
<c:forEach items="${l_file_share}" var="file_share" varStatus="s" begin="0" end="${l_file_share.size()}">
    <tr>
        <td>
            <div class="tt">
                <p>${file_share.get("username")}想要与你分享文件：]${file_share.get("filename")}</p>
                <p>${file_share.get("date")}</p>
            </div>
        </td>
        <td>
            <input type="button" value="转存" onclick="isDone(this,'/grant_file','${file_share.get("file_id")}','${file_share.get("date")}')"/>
            <input type="button" value="忽略" onclick="isDone(this,'/deny_file','${file_share.get("file_id")}','${file_share.get("date")}')"/>
            <!--<a href="/grant_file?file_id=${file_share.get("file_id")}&date=${file_share.get("date")}">转存</a>
            <a href="/deny_file?file_id=${file_share.get("file_id")}&date=${file_share.get("date")}">忽略</a>
            -->
        </td>
    </tr>
</c:forEach>
<br>
<br>
<br>
<p>有无好友添加请求</p>
<c:forEach items="${l_friend_applier}" var="friend_applier" varStatus="s" begin="0" end="${l_friend_applier.size()}">
    <tr>
        <td>
            <div class="tt">
                <p>${friend_applier.get("username")}请求加你为好友</p>
                <p>${friend_applier.get("date")}</p>
            </div>
        </td>
        <td>
            <input type="button" value="同意" onclick="isDone(this,'/grant_friend','${friend_applier.get("user_id")}','${friend_applier.get("date")}')"/>
            <input type="button" value="拒绝" onclick="isDone(this,'/deny_friend','${friend_applier.get("user_id")}','${friend_applier.get("date")}')"/>
            <!--<a href="/grant_friend?applier_id=${friend_applier.get("user_id")}&date=${friend_applier.get("date")}">接受</a>
            <a href="/deny_friend?applier_id=${friend_applier.get("user_id")}&date=${friend_applier.get("date")}">拒绝</a>-->
        </td>

    </tr>
</c:forEach>

<p>我的文件</p>
<c:forEach items="${l_file}" var="file" varStatus="s" begin="0" end="${l_file.size()}">
    <tr>

        <td>
            <a href="/file_detail/${file.getFile_id()}">${file.getFilename()}</a>
        </td>
        <td>
            <p>${file.getDate()}</p>
        </td>
        <td>
            <p>${file.getSize()}</p>
        </td>

    </tr>
</c:forEach>
<p>我的朋友</p>
<c:forEach items="${l_friend}" var="friend" varStatus="s" begin="0" end="${l_friend.size()}">
    <tr>

        <td>
            <a href="/userpage/${friend.getUser_id()}">${friend.getUsername()}</a>
        </td>

    </tr>
</c:forEach>

<br>
<br>
<br>
<br>


<a href="/my_message/${user.getUser_id()}">我的动态</a>
<a href="/zone/${user.getUser_id()}">朋友圈</a>

</body>
</html>
