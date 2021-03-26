<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>用户注册界面</title>
  <script>
    var checkbox=document.getElementsByClassName('checkbox');
    function reg() {
      if(checkbox[0].checked==true){
        alert("注册成功！");
        document.getElementById("reg").submit();
      }
      else{
        alert("请先阅读并同意《用户注册协议》！")
      }
    }
  </script>
  <style>
    body{
      background: #159f9f;
    }
    input{
      border-radius: 10px;
    }
    .container{
      margin: 0 auto;
      width: 500px;
    }
    form{
      width: 500px;
      margin: 0 auto;
      background: #FFF;
      border-radius: 15px;
      position: relative;
    }
    h1{
      font-size: 28px;
      text-align: center;
      color: #FFF;
    }
    .p{
      color: red;
      margin-left: 33px;
      display: inline-block;
    }
    label{
      font-size: 18px;
      font-weight: bold;
    }
    .register{
      height: 35px;
      width: 300px;
    }
    .q{
      color:red;
      margin-left:17px;
      display:inline-block;
    }
    .checkbox{
      margin-left: 100px;
      display: inline-block;
      width: 15px;
      height: 15px;
    }
    .submit{
      border-radius: 7px;
      margin-left: 150px;
      height: 35px;
      width: 150px;
      background-color: #000;
      border: none;
      display: block;
      padding: 0;
      color: #FFF;
      font-weight: bold;
      cursor: pointer;
    }
    a{
      text-decoration: none;
      font-weight: bold;
    }
    .left,.right{
      position: absolute;
      bottom: 20px;
    }
    .left{
      left: 20px;
    }
    .right{
      right: 20px;
    }
  </style>
</head>
<body>
  <div class="container">
    <h1>新用户注册</h1>
    <form action="Reg.do" method="post" id="reg">
      <br>
      <span class="p">*</span>
      <label for="username">用户名&nbsp;&nbsp;&nbsp;&nbsp;</label>
      <input type="text" name="username" id="username" placeholder="" class="register"><br><br>
      <span class="p">*</span>
      <label for="phonenumber">手机号&nbsp;&nbsp;&nbsp;&nbsp;</label>
      <input type="text" name="phone" id="phonenumber" class="register">
      <br><br>
      <span class="p">*</span>
      <label for="verify">真实姓名&nbsp;</label>
      <input type="text" id="realname" class="register" name="realname"><br><br>

      <span class="p">*</span>
      <label for="verify">学号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
      <input type="text" id="sno" class="register" name="sno"><br><br>
      
      <span class="p">*</span>
      <label for="verify">宿舍号&nbsp;&nbsp;&nbsp;&nbsp;</label>
      <input type="text" id="dormitory" class="register" name="dormitory"><br><br>

      <span class="p">*</span>
      <label for="verify">性别&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
      <input type="text" id="sex" class="register" name="sex"><br><br>

      <span class="q">*</span>
      <label for="pwd">登录密码&nbsp;&nbsp;&nbsp;</label>
      <input type="password" name="password" id="pwd" class="register"><br><br>
      <span class="q">*</span>
      <label for="c_pwd">确认密码&nbsp;&nbsp;&nbsp;</label>
      <input type="password" name="password1" id="c_pwd" class="register"><br><br>

      <input type="checkbox" class="checkbox" name="">
      <span style="font-size:15px">我已阅读并同意《用户注册协议》</span>
      <br><br>
      <a href="javascript:reg();"> <input type="button" name="" value="同意以上协议并注册" class="submit"></a><br>
      <a href="index.jsp" class="left">返回首页</a>
      <a href="Login.jsp" class="right">开始登录</a>
    </form>
  </div>

</body>
</html>