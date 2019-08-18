<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
-->

<html>
<head lang="en">
    <meta charset="utf-8" />
    <title>系统注册 - 银行管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <script language="JavaScript">
        function catchRePasswordException(){
            var password = document.getElementById("pwd").value;
            var repassword = document.getElementById("repwd").value;
            if(password != repassword){
                alert("两次密码输入不一致！请重新输入");
                return false;
            }else{
                return true;
            }
        }

        function checkRegisterState() {
            var RegisterInfo = "${RegisterInfo}";
            if(RegisterInfo != ""){
                alert(RegisterInfo);
            }
        }
    </script>
</head>
<body class="login_bg" onload="checkRegisterState()">
    <section class="loginBox">
        <header class="loginHeader">
            <h1>银行管理系统</h1>
        </header>
        <section class="loginCont">
            <form class="loginForm" action="register.do" method="post" onsubmit="return catchRePasswordException()">
                <div class="inputbox">
                    <label for="user">用户名：</label>
                    <input id="user" type="text" name="username" placeholder="请输入用户名" required/>
                </div>
                <div class="inputbox">
                    <label for="pwd">密码：</label>
                    <input id="pwd" type="password" name="password" placeholder="请输入密码" required/>
                </div>
				<div class="inputbox">
                    <label for="repwd">确认密码：</label>
                    <input id="repwd" type="password" name="repassword" placeholder="请再次输入密码" required/>
                </div>
                <div class="subBtn">
                    <input type="submit" value="注册" />
                    <input type="reset" value="重置"/>
                    <input type="button" value="已有账号？" onclick="window.location='login.jsp';"/>
                </div>
                <input type="hidden" name="cmd" value="register" />
            </form>
        </section>
    </section>

</body>
</html>