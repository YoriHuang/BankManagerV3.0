
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<script language="JavaScript">
    function exit(){
        if(confirm("确认退出吗？")){
            window.location.replace("exit.do");
        }
    }
</script>
<div class="left">
    <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
    <nav>
        <ul class="list">
            <li class="adminLi1"><a href="adminCheckUsers.do">查看系统用户</a></li>
            <li class="adminLi2"><a href="changepwd.jsp">密码修改</a></li>
            <li class="adminLi3"><a onclick="exit()">退出系统</a></li>
        </ul>
    </nav>
</div>


