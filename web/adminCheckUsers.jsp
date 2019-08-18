<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>银行管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>

    <script language="JavaScript">
        function confirmFreeze(id, username) {
            if(confirm("确认冻结账户"+ username + "吗？")){
                window.location.replace("freeze.do?userId=" + id);
            }
        }
        function confirmThaw(id,username) {
            if(confirm("确认解冻账户"+ username + "吗？")){
                window.location.replace("thaw.do?userId=" + id);
            }
        }
        function checkFreezeThawInfo() {
            var freezeThawInfo = "${freezeThawInfo}";
            if(freezeThawInfo != ""){
                alert(freezeThawInfo);
            }

        }
    </script>
</head>
<body onload="checkFreezeThawInfo()">
<jsp:include page="adminHead.jsp"/>
<!--主体内容-->
<section class="publicMian">
    <jsp:include page="adminLeft.jsp"/>
    <div class="right">

            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>查看系统用户页面</span>
            </div>

            <!--账单表格 样式和供应商公用-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">用户id</th>
                    <th width="13%">用户名</th>
                    <th width="15%">账户余额</th>
                    <th width="20%">注册时间</th>
                    <th width="10%">操作</th>
                </tr>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.userid}</td>
                        <td>${user.username}</td>
                        <td>${user.balance}元</td>
                        <td>${user.registime}</td>
                        <td><c:if test="${user.flag == 1}"><button class="freeze" onclick="confirmFreeze('${user.userid}','${user.username}')">冻结</button></c:if>
                            <c:if test="${user.flag == 0}"><button class="thaw" onclick="confirmThaw('${user.userid}','${user.username}')">解冻</button></c:if>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>

</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>
</body>
</html>