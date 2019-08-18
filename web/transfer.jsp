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
    <script language="JavaScript">
        function catchException() {
            var money = document.getElementById("transferId").value;
            var id = document.getElementById("toUserId").value;
            var selfId = "${userId}";
            if(/[a-zA-Z]+/.test(money) || money == "" || money <= 0){
                alert("转账金额格式有误，请输入大于0的数字！");
                return false;
            }else if(id == "" || /[a-zA-Z]+/.test(id) || id <= 0){
                alert("账户id格式不正确！");
                return false;
            }else if(selfId == id){
                alert("不能给自己转账！");
                return false;
            }else{
                return true;
            }
        }

        function checkTransferState(){
            var transferInfo = "${transferInfo}";
            if(transferInfo != ""){
                alert(transferInfo);
            }
        }
    </script>
</head>
<body onload="checkTransferState()">
<jsp:include page="head.jsp"/>
<!--主体内容-->
<section class="publicMian ">
    <jsp:include page="left.jsp"/>
    <div class="right">

        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>转账页面</span>

        </div>
        <div class="providerAdd">
            <form action="transfer.do" method="post" onsubmit="return catchException()">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="transferId">转账金额：</label>
                    <!-- <input type="text" name="providerId" id="providerId"/>-->
                    <input type="text" name="money" id="transferId"/>
                     <span>*请输入转账金额</span>
                </div>
                <div>
                    <label for="toUserId">转入账户id：</label>
                    <input type="text" name="toUserId" id="toUserId" required/>
                    <span>*请输入转入账户id</span>
                    <input type="hidden" name="operation" value="transfer"/>
                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="providerList.html">返回</a>-->
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