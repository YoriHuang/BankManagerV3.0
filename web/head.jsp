
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script language="JavaScript">
    function exit(){
        if(confirm("确认退出吗？")){
            window.location.replace("exit.do");
        }
    }
</script>
<!--头部-->
<header class="publicHeader">
    <h1>银行管理系统</h1>

    <div class="publicHeaderR">
        <p><span style="color: #fff21b"> ${username}</span>  , <span id="hours"></span>!</p>
        <a onclick="exit()">退出</a>
    </div>

</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>