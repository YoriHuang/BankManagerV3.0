<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
-->

<html xmlns="http://www.w3.org/1999/xhtml">
<head lang="en">
    <meta charset="utf-8" />
    <title>银行管理系统</title>
    <c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
    <link rel="stylesheet" href="${path}/css/public.css"/>
    <link rel="stylesheet" href="${path}/css/style.css"/>
    <script language="JavaScript" type="text/javascript">
        function exit(){
            if (confirm("确认退出吗？")) {
                window.location.replace("exit.do");
            }
        }

    </script>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>银行管理系统</h1>
    <div class="publicHeaderR">
        <p><span style="color: #fff21b"> ${username}</span>  , 欢迎您!</p>
        <a onclick="exit()">退出</a>
    </div>
</header>

<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11 星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>

<!--主体内容-->
<section class="publicMian">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li class="userLi1"><a href="inquiry.do">查询余额</a></li>
                <li class="userLi2"><a href="${path}/deposit.jsp">存款</a></li>
                <li class="userLi3"><a href="${path}/withdraws.jsp">取款</a></li>
                <li class="userLi4"><a href="${path}/transfer.jsp">转账</a></li>
                <li class="userLi5"><a href="log.do">操作明细</a></li>
                <li class="userLi6"><a href="${path}/changepwd.jsp">密码修改</a></li>
                <li class="userLi7"><a onclick="exit()">退出系统</a></li>
            </ul>
        </nav>
    </div>

    <div class="right">
        <img class="wColck" src="${path}/img/clock.jpg" alt=""/>
        <div class="wFont">
            <h2>${username}</h2>
            <p>欢迎来到银行管理系统!</p>
			<span id="hours"></span>!
        </div>
    </div>
</section>
<footer class="footer">
</footer>
<script src="${path}/js/time.js" type="text/javascript"></script>
</body>
</html>