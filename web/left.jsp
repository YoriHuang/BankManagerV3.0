
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<script language="JavaScript">
    function exit(){
        if(confirm("确认退出吗？")){
            window.location.replace("exit.do?operation=exit");
        }
    }
</script>
<div class="left">
    <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
    <nav>
        <ul class="list">
            <li class="userLi1"><a href="inquiry.do">查询余额</a></li>
            <li class="userLi2"><a href="deposit.jsp">存款</a></li>
            <li class="userLi3"><a href="withdraws.jsp">取款</a></li>
            <li class="userLi4"><a href="transfer.jsp">转账</a></li>
            <li class="userLi5"><a href="log.do">操作明细</a></li>
            <li class="userLi6"><a href="changepwd.jsp">密码修改</a></li>
            <li class="userLi7"><a onclick="exit()">退出系统</a></li>
        </ul>
    </nav>
</div>


