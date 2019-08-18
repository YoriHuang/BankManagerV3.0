<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!--<!DOCTYPE html>-->
<html>
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>银行管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>

</head>
<body>
<jsp:include page="head.jsp"/>
<!--主体内容-->
    <section class="publicMian ">
       <jsp:include page="left.jsp"/>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>操作明细页面</span>
            </div>

            <!--账单表格 样式和供应商公用-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">操作序号</th>
                    <th width="15%">操作类型</th>
                    <th width="10%">操作金额</th>
                    <th width="10%">账户余额</th>
                    <th width="15%">操作时间</th>
                </tr>
                <c:forEach items="${logs}" var="log">
                <tr>
                    <td>${log.log_id}</td>
                    <td>${log.log_type}</td>
                    <td>${log.money}元</td>
                    <td>${log.user_balance}元</td>
                    <td>${log.time}</td>
                </tr>
                </c:forEach>

            </table>
        </div>
    </section>

    <footer class="footer">
    </footer>

<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>

</body>
</html>