
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>登录界面</title>
    <style>
        html,body{
            height: 100%;
        }
        body{
            background: #159f9f;
        }
        h1{
            color: #FFF;
            text-align: center;
        }
        .container{
            margin: 100px auto;
            width: 30%;
        }
        form{
            background: #FFF;
            height: 300px;
            width: 100%;
            border-radius: 10px;
            position: relative;
        }
        label{
            color: #000;
            font-weight: bold;
            font-size: 20px;
            margin-left: 40px;
        }
        input{
            text-align: left;
            margin: 10px;
            border-radius: 10px;
        }
        .input{
            width: 80%;
            height: 35px;
            margin-left: 40px;
        }
        .checkbox{
            margin-left: 30px;
        }
        a{
            text-decoration: none;
            font-weight: bold;
        }
        .submit{
            display: inline-block;
            margin-top: 0;
            margin-left:145px;
            background: #000;
            border: none;
            color: #FFF;
            height: 35px;
            width: 100px;
            text-align: center;
            font-weight: bold;
            border-radius: 5px;
        }
        .left{
            margin: 20px;
        }
        .right{
            position: absolute;
            right: 30px;
        }
    </style>
</head>
<%
    String msg=(String)request.getAttribute("msg");
%>
<script>
    function login() {
        document.getElementById("loginF").submit();
    }
</script>

<body >
<div class="container">

    <h1>用户登录</h1>
    <form id="loginF" action="user.do?method=userLogin" method="post">
        <br>
        <label for="username">用户名</label><br>
        <input type="text" name="username" id="username" class="input" value="" placeholder="请输入账号"><br>
        <label for="pwd">密码</label><br>
        <input type="password" name="password" id="pwd" class="input" value="" placeholder="请输入密码">
        <div class="checkbox">
            <input type="checkbox" name="">
                <span>记住密码</span>&nbsp;&nbsp;&nbsp;&nbsp;
            <c:if test="${msg!=null}">
                <span style="color: red">${msg}</span>
            </c:if>
        </div>
        <a href="javascript:login();">
            <input type="button" class="submit" value="开始登录">
        </a>
        <br>
        <a href="index.jsp" class="left">返回首页</a>
        <a href="reg.jsp" class="right">注册账号</a>
    </form>
</div>
</body>
</html>