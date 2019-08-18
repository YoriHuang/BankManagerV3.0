<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>银行管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<jsp:include page="head.jsp"/>
<!--主体内容-->
<section class="publicMian">
    <jsp:include page="left.jsp"/>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>查询余额页面</span>
        </div>
        <div class="search">
            <span>账户余额：${balance} 元</span>
        </div>
    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>
</body>
</html>