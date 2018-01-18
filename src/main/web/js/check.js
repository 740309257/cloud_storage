/**
 * Created by dell on 2/28/2017.
 */

    function isExists(obj) {

        var username = document.getElementById("username").value;
        var is_exists = true;

        $.ajax({
            type:"post",
            url:"is_exist",
            data: {"username":username},
            success: function (res) {
                if (res== "true"){
                    alert("用户名"+username+"已经存在");
                }else{
                    alert("恭喜,该用户名可以使用");
                }
            }
        })

    }

