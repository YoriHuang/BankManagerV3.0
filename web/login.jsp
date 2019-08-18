<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
-->
<html>
<head lang="en">
    <meta charset="utf-8" />
    <title>系统登录 - 银行管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <script type="text/javascript" language="JavaScript">
        function checkLoginState() {
            var LoginInfo = "${LoginInfo}";
            if(LoginInfo != ""){
                alert(LoginInfo);
            }
        }
    </script>
</head>
<body class="login_bg" onload="checkLoginState()">
    <section class="loginBox">
        <header class="loginHeader">
            <h1>银行管理系统</h1>
        </header>
        <section class="loginCont">
            <form class="loginForm" action="login.do" method="post">
                <div class="inputbox">
                    <label for="user">用户名：</label>
                    <input id="user" type="text" name="username" placeholder="请输入用户名" required/>
                </div>
                <div class="inputbox">
                    <label for="mima">密码：</label>
                    <input id="mima" type="password" name="password" placeholder="请输入密码" required/>
                </div>
                <div class="subBtn">
                    <input type="submit" value="登录" />
                    <input type="reset" value="重置"/>
                    <input type="button" name="register" value="立即注册" onclick="window.location='register.jsp';" />
                </div>
                <input type="hidden" name="cmd" value="login" />
            </form>
        </section>
    </section>

</body>
</html>