<%--
  Created by IntelliJ IDEA.
  User: yf2015
  Date: 2016/12/28
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>


<html>
<script src='http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js'></script>
<script type="text/javascript">
    function fileSelected() {

        var file = document.getElementById('course_file').files[0];
        if (file) {
            var fileSize = 0;
            if (file.size > 1024 * 1024)
                fileSize = (Math.round(file.size * 100 / (1024 * 1024)) / 100).toString() + 'MB';
            else
                fileSize = (Math.round(file.size * 100 / 1024) / 100).toString() + 'KB';

            document.getElementById('fileName').innerHTML = 'Name: ' + file.name;
            document.getElementById('fileSize').innerHTML = 'Size: ' + fileSize;
            document.getElementById('fileType').innerHTML = 'Type: ' + file.type;
        }
    }
    function fileSelected() {

        var file = document.getElementById('up_file').files[0];
        if (file) {
            var fileSize = 0;
            if (file.size > 1024 * 1024)
                fileSize = (Math.round(file.size * 100 / (1024 * 1024)) / 100).toString() + 'MB';
            else
                fileSize = (Math.round(file.size * 100 / 1024) / 100).toString() + 'KB';

            document.getElementById('fileName').innerHTML = 'Name: ' + file.name;
            document.getElementById('fileSize').innerHTML = 'Size: ' + fileSize;
            document.getElementById('fileType').innerHTML = 'Type: ' + file.type;
        }
    }

    function uploadFile() {
        var formobj =  document.getElementById("fileinfo");
        var fd = new FormData(formobj);
        //    fd.append("course_file", document.getElementById('course_file').files[0]);
        var xhr = new XMLHttpRequest();
        xhr.upload.addEventListener("progress", uploadProgress, false);
        xhr.addEventListener("load", uploadComplete, false);
        xhr.addEventListener("error", uploadFailed, false);
        xhr.addEventListener("abort", uploadCanceled, false);
        xhr.open("POST", formobj.action);
        xhr.send(fd);
    }

    function uploadProgress(evt) {
        if (evt.lengthComputable) {
             var percentComplete = Math.round(evt.loaded * 100 / evt.total);
             document.getElementById('progressNumber').innerHTML = percentComplete.toString() + '%';
        }
        else {
            document.getElementById('progressNumber').innerHTML = 'unable to compute';
        }
    }

    function uploadComplete(evt) {
        /* This event is raised when the server send back a response */
        alert(evt.target.responseText);
    }

    function uploadFailed(evt) {
        alert("There was an error attempting to upload the file.");
    }

    function uploadCanceled(evt) {
        alert("The upload has been canceled by the user or the browser dropped the connection.");
    }


</script>



<head>
    <meta charset="UTF-8">
    <title>课程信息页面</title>
    <style>
        #header {
            background-color:black;
            color:white;
            text-align:center;
            padding:5px;
        }
        #infomation {
            float: left;
            margin: 5px;
            padding: 15px;
            width: 300px;
            height: 300px;
            border: 1px solid black;
        }
    </style>


    </head>
<body>

<form id="fileinfo" name="fileinfo" enctype="multipart/form-data" method="post" action="/fileUpload/${id}">

<a href="#" id="AddMoreFileBox" class="btn btn-info">添加文件</a></span></p>
<div id="InputsWrapper">
    <div>
        文件信息：<input type="text" name="filename0">

        <input type="file" name="up_file" id="up_file" placeholder="请输入文件名" onchange="fileSelected();"/>
        <a href="#" class="removeclass"><input type='button' value='删除'></a>
    </div>
</div>
<script>
    $(document).ready(function() {

        var MaxInputs       = 8; //maximum input boxes allowed
        var InputsWrapper   = $("#InputsWrapper"); //Input boxes wrapper ID
        var AddButton       = $("#AddMoreFileBox"); //Add button ID

        var x = InputsWrapper.length; //initlal text box count
        var FieldCount=0; //to keep track of text box added

        $(AddButton).click(function (e)  //on add input button click
        {
            if(x <= MaxInputs) //max input box allowed
            {
                FieldCount++; //text box added increment
                //add input box
                $(InputsWrapper).append('' +
                        '<div>课件信息：<input type="text" name="filename'+ FieldCount +'" id="filename'+ FieldCount +'" />'
                       // + '<a href="#" class="removeclass">'
                        + '<input type="file" name="up_file" id="up_file'+ FieldCount +'" onchange="fileSelected();"/>'
                        + '<input type="button" value="删除"class="removeclass"></a></div>');
                x++; //text box increment
            }
            return false;
        });

        $("body").on("click",".removeclass", function(e){ //user click on remove text
            if( x > 1 ) {
                $(this).parent('div').remove(); //remove text box
                x--; //decrement textbox
            }
            return false;
        })

    });
</script>
    <input type="button" onclick="uploadFile()" value="上传文件" />
</form>
</body>