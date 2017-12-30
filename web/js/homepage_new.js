// $(document)
// $("button")
// $("p")
// $("#id1")
// $(".class1")
// $(this)
// $("[href]")
// $("[href='#']")
// $("[href$='.jpg']")
// $("a").css("background-color","red")
// $("div #id2 .class2")
// $("#button1").click(function () {
//     $(".class2").xxx
// // });
// Event 函数	绑定函数至
// $(document).ready(function)	将函数绑定到文档的就绪事件（当文档完成加载时）
// $(selector).click(function)	触发或将函数绑定到被选元素的点击事件
// $(selector).dblclick(function)	触发或将函数绑定到被选元素的双击事件
// $(selector).focus(function)	触发或将函数绑定到被选元素的获得焦点事件
// $(selector).mouseover(function)	触发或将函数绑定到被选元素的鼠标悬停事件
// $(document).ready(function () {
//         $("#header").click(
//             function () {
//                 $(".header_right").hide()
//             }
//         );
//     }
// );
// $("button").click(function(){
//     $("#w3s").attr({
//         "href" : "http://www.w3school.com.cn/jquery",
//         "title" : "W3School jQuery Tutorial"
//     });
// });


$(document).ready(function () {
        $("#header").slideDown(function () {
            $("#up_btn").show();
        });

        $(".container").fadeIn("1000");
        $(".footer").fadeIn("1000");

        $("#folder_head").animate({left: '0'});
        $("#folder_list").animate({
            left: '4rem'
        }, "slow");


        $("#up_btn").click(function () {
            $(this).hide();
            $("#header").slideUp(function () {
                $("#down_btn").show();
            });
        });
        $("#down_btn").click(function () {
            $(this).hide();
            $("#header").slideDown(function () {
                $("#up_btn").show();
            });
        });
    }
);
