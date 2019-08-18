<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>银行管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <script language="JavaScript">
        function catchMoneyException() {
            var money = document.getElementById("depositId").value;
            if(/[a-zA-Z]+/.test(money) || money == "" || money <= 0){
                alert("格式有误！请输入大于0的数字！");
                return false;
            }else{
                return true;
            }
        }
        function checkDepositState(){
            var depositInfo = "${depositInfo}";
            if(depositInfo != ""){
                alert(depositInfo);
            }
        }
    </script>
</head>
<body onload="checkDepositState()">
<jsp:include page="head.jsp"/>
<!--主体内容-->
<section class="publicMian ">
    <jsp:include page="left.jsp"/>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>存款页面</span>
        </div>
        <div class="providerAdd">
            <form action="deposit.do" method="post" onsubmit="return catchMoneyException()">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="depositId">存入金额：</label>
                    <input type="text" name="money" id="depositId"/>
                     <span>*请输入存款金额</span>
                    <input type="hidden" name="operation" value="deposit"/>
                 </div>

                <div class="providerAddBtn">
                    <input type="submit" value="确定"/>
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>
    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>