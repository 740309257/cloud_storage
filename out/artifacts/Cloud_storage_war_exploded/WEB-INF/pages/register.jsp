<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta http-equiv="Pragma" content="no-cache"> 
<meta http-equiv="Cache-Control" content="no-cache"> 
<meta http-equiv="Expires" content="0"> 
<title>用户注册</title>
	<link href="<%=request.getContextPath()%>/css/register.css" type="text/css" rel="stylesheet">
	<script src="<%=request.getContextPath()%>/js/check.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery-ui.min.js.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.md5.js"></script>
	<script>
        function doKeyDown(){
            if(event.keyCode == 13)
            {
                submit_form(this);
            }
        }
	</script>
	<script>
        function md5Encryption(obj) {
            var password=document.getElementById("password").value;
            if(password != null)
            {
                var pwd=$.md5(password).substring(0,20);
                $("#password").val(pwd);
            }

        }
	</script>
	<script>
        function re_md5Encryption(obj) {
            var re_password=document.getElementById("re_password").value;
            if(re_password!=null)
            {
                var re_pwd=$.md5(re_password).substring(0,20);
                $("#re_password").val(re_pwd);
            }



        }
	</script>
    <script>
        function submit_form(obj) {
            $.ajax({
                cache: true,
                type: "POST",
                url:"submit",
                data:$('#register_form').serialize(),// 你的formid
                async: false,
                error: function(res) {
                    alert("Connection error");
                },
                success: function(data) {
                    if(data=="error")
                    {alert("注册失败！");}
                    else
                    {
                        var user_id=data.toString();
                        window.location.href="http://localhost:8080/homepage/"+user_id;
                    }
                }
            });
        }

		$(function() {
			$('#captchaImage').click(function () {
				$('#captchaImage').attr("src", "captcha.form?timestamp=" + (new Date()).valueOf());
			});
		});

    </script>
</head>
<body onkeypress="doKeyDown()">
<div class="register">
    <div class="message">云存储系统-用户注册</div>
    <div id="darkbannerwrap"></div>
    
    <form method="post" action="submit" id="register_form">
		<input id="username" name="username" placeholder="用户名" required="" type="text" onblur="isExists(this)">
		<hr class="hr15">
		<input id="password" name="password" placeholder="密码" required="" type="password" onblur="md5Encryption(this)">
		<hr class="hr15">
		<input id="re_password" name="re_password" placeholder="确认密码" required="" type="password" onblur="re_md5Encryption(this)">
		<hr class="hr15">
		<input id="introduction" name="introduction" placeholder="自我介绍" required="" type="text">
		<hr class="hr15">
		<img id="captchaImage" src="/captcha" style="width: 35%;float: left;margin-right: 7px;height: 30px"/>
		<input type="text" id="verify_code" name="verify_code" class="text" placeholder="请输入验证码" style="width: 60%;float: left;height: 30px" />
		<hr class="hr15">
        <input type="button" value="注册" style="width:100%;" onclick="submit_form(this)"/>
        <hr class="hr20">
		<!-- 帮助 <a onClick="alert('请联系管理员')">忘记密码</a> -->
	</form>

	
</div>

<div class="copyright">© 2016品牌名称 by <a href="http://www.mycodes.net/" target="_blank">源码之家</a></div>

</body>
</html>