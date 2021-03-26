<%@ page import="com.shopping.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.shopping.model.Commodit" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>校园二手市场主页</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/shopping.css" rel="stylesheet">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/shopping.js"></script>
</head>
<%
    User user=(User)session.getAttribute("user");
    int uid=0;
    if(user!=null){
        uid=user.getUid();
    }
    List<Commodit> list=(List<Commodit>)request.getAttribute("list");

%>
<script>
    function addCart() {
        <% if(uid!=0){%>
        alert("添加成功！");
        <%}else {%>
        alert("您还未登录哦~");
        <%}%>
    }
</script>
<body>
<%@  include file="inbody.jsp"%>
<!--中间部分-->
<div class="center">
    <!--左侧导航栏-->
    <div class="center-left">

        <div class="navbar navbar-default" id="mycollapse">

            <ul class="nav nav-pills nav-stacked" style="background-color: rgb(241, 240, 238);">

                <li style="border: 1px solid rgb(202, 202, 202);">
                    <a href="#second-level-1" class="second-level accordion-toggle"
                       data-toggle="collapse"
                       data-parent="#mycollapse">
                        <p style="font-size: 18px;font-family: 微软雅黑;text-align: center;">数码科技</p>
                    </a>
                    <ul class="nav collapse" id="second-level-1" style="background-color: rgba(248, 255, 253, 0.952);">
                        <br>
                        <a href="findCommoditBySort.do?sort=手机" style="position: relative;margin-left: 30px;font-size: 15px;"><input type="button" value="手机" id="手机" ></a>
                        <a href="findCommoditBySort.do?sort=电脑" style="position: relative;margin-left: 30px;font-size: 15px;"><input type="button" value="电脑" id="电脑"></a>
                        <a href="findCommoditBySort.do?sort=相机" style="position: relative;margin-left: 30px;font-size: 15px;"><input type="button" value="相机" id="相机"></a><br>
                        <a href="findCommoditBySort.do?sort=智能设备" style="position: relative;margin-left: 30px;font-size: 15px;"><input type="button" value="智能设备" id="智能设备"></a>
                        <a href="findCommoditBySort.do?sort=手机配件" style="position: relative;margin-left: 30px;font-size: 15px;"><input type="button" value="手机配件" id="手机配件"></a>
                        <br><br>
                    </ul>
                </li>
                <li >
                    <a href="#second-level-2" class="second-level accordion-toggle"
                       data-toggle="collapse"
                       data-parent="#mycollapse">
                        <p style="font-size: 18px;font-family: 微软雅黑;text-align: center;">音影家电</p>
                    </a>
                    <ul class="nav collapse" id="second-level-2" style="background-color: rgba(248, 255, 253, 0.952);">
                        <br>
                        <a href="findCommoditBySort.do?sort=生活电器" style="position: relative;margin-left: 30px;font-size: 15px;"><input type="button" value="生活电器" id="生活电器"></a>
                        <a href="findCommoditBySort.do?sort=个护电器" style="position: relative;margin-left: 30px;font-size: 15px;"><input type="button" value="个护电器" id="个护电器"></a><br>
                        <a href="findCommoditBySort.do?sort=生活家电" style="position: relative;margin-left: 30px;font-size: 15px;"><input type="button" value="生活家电" id="生活家电"></a>
                        <a href="findCommoditBySort.do?sort=影音娱乐" style="position: relative;margin-left: 30px;font-size: 15px;"><input type="button" value="影音娱乐" id="影音娱乐"></a>
                        <br><br>
                    </ul>
                </li>

                <li style="border: 1px solid rgb(202, 202, 202);">
                    <a href="#second-level-3" class="second-level accordion-toggle"
                       data-toggle="collapse" data-parent="#mycollapse">
                        <p style="font-size: 18px;font-family: 微软雅黑;text-align: center;">鞋服配饰</p>
                    </a>
                    <ul class="nav collapse" id="second-level-3" style="background-color: rgba(248, 255, 253, 0.952);">
                        <br>
                        <a href="#" style="position: relative;margin-left: 30px;font-size: 15px;"><input type="button" value="女装:"></a><br>
                        <a href="findCommoditBySort.do?sort=女装:(上装)" style="position: relative;margin-left: 30px;font-size: 15px;"><input type="button" value="上衣" id="女上衣"></a>
                        <a href="findCommoditBySort.do?sort=女装:(套装)" style="position: relative;margin-left: 30px;font-size: 15px;"><input type="button" value="外套" id="女外套"></a>
                        <a href="findCommoditBySort.do?sort=女装:(下装)" style="position: relative;margin-left: 30px;font-size: 15px;"><input type="button" value="女裤" id="女裤"></a><br>
                        <a href="findCommoditBySort.do?sort=女装:(套装)" style="position: relative;margin-left: 30px;font-size: 15px;"><input type="button" value="裙子" id="裙子"></a>
                        <a href="findCommoditBySort.do?sort=女装:(套装)" style="position: relative;margin-left: 30px;font-size: 15px;"><input type="button" value="套装" id="套装"></a>
                        <a href="findCommoditBySort.do?sort=女鞋" style="position: relative;margin-left: 30px;font-size: 15px;"><input type="button" value="鞋子" id="女鞋"></a><br><br>

                        <a href="#" style="position: relative;margin-left: 30px;font-size: 15px;"><input type="button" value="男装:"></a><br>
                        <a href="#" style="position: relative;margin-left: 30px;font-size: 15px;"><input type="button" value="上衣" id="上衣"></a>
                        <a href="#" style="position: relative;margin-left: 30px;font-size: 15px;"><input type="button" value="外套" id="男外套"></a>
                        <a href="#" style="position: relative;margin-left: 30px;font-size: 15px;"><input type="button" value="男裤" id="男裤"></a><br>
                        <a href="#" style="position: relative;margin-left: 30px;font-size: 15px;"><input type="button" value="卫衣" id="男卫衣"></a>
                        <a href="#" style="position: relative;margin-left: 30px;font-size: 15px;"><input type="button" value="运动" id="运动衣"></a>
                        <a href="findCommoditBySort.do?sort=男鞋" style="position: relative;margin-left: 30px;font-size: 15px;"><input type="button" value="鞋子" id="男鞋"></a><br><br>

                        <a href="findCommoditBySort.do?sort=袜子" style="position: relative;margin-left: 30px;font-size: 15px;"><input type="button" value="袜子" id="袜子"></a>
                        <a href="findCommoditBySort.do?sort=配饰" style="position: relative;margin-left: 30px;font-size: 15px;"><input type="button" value="配饰" id="配饰"></a>
                        <a href="findCommoditBySort.do?sort=帽子" style="position: relative;margin-left: 30px;font-size: 15px;"><input type="button" value="帽子" id="帽子"></a>
                        <br><br>
                    </ul>
                </li>

                <li >
                    <a href="#second-level-4" class="second-level accordion-toggle"
                       data-toggle="collapse"
                       data-parent="#mycollapse">
                        <p style="font-size: 18px;font-family: 微软雅黑;text-align: center;">图书文具</p>
                    </a>
                    <ul class="nav collapse" id="second-level-4" style="background-color: rgba(248, 255, 253, 0.952);">
                        <br>
                        <a href="findCommoditBySort.do?sort=文具" style="position: relative;margin-left: 50px;font-size: 15px;"><input type="button" value="文具" id="文具">&nbsp;&nbsp;&nbsp;</a>
                        <a href="findCommoditBySort.do?sort=教具" style="position: relative;margin-left: 30px;font-size: 15px;"><input type="button" value="教具" id="教具"></a><br>
                        <a href="findCommoditBySort.do?sort=图书" style="position: relative;margin-left: 50px;font-size: 15px;"><input type="button" value="图书" id="图书">&nbsp;&nbsp;&nbsp;</a>
                        <a href="findCommoditBySort.do?sort=教材" style="position: relative;margin-left: 30px;font-size: 15px;"><input type="button" value="教材" id="教材"></a>
                        <br><br>
                    </ul>
                </li>

                <li style="border: 1px solid rgb(202, 202, 202);">
                    <a href="#second-level-5" class="second-level accordion-toggle"
                       data-toggle="collapse"
                       data-parent="#mycollapse">
                        <p style="font-size: 18px;font-family: 微软雅黑;text-align: center;">其他</p>
                    </a>
                    <ul class="nav collapse" id="second-level-5" style="background-color: rgba(248, 255, 253, 0.952);">
                        <br>
                        <a href="findCommoditBySort.do?sort=手表" style="position: relative;margin-left: 50px;font-size: 15px;"><input type="button" value="手表" id="手表">&nbsp;&nbsp;&nbsp;</a>
                        <a href="findCommoditBySort.do?sort=眼镜" style="position: relative;margin-left: 30px;font-size: 15px;"><input type="button" value="眼镜" id="眼镜"></a><br>
                        <a href="findCommoditBySort.do?sort=潮搭" style="position: relative;margin-left: 50px;font-size: 15px;"><input type="button" value="潮搭" id="潮搭">&nbsp;&nbsp;&nbsp;</a>
                        <a href="findCommoditBySort.do?sort=服配" style="position: relative;margin-left: 30px;font-size: 15px;"><input type="button" value="服配" id="服配"></a>
                        <br><br>
                    </ul>
                </li>

            </ul>
        </div>

    </div>
    <!--右侧物品展示-->
    <div class="center-right">
<%--        <%--%>
<%--        if(list.size()!=0){}--%>
<%--        %>--%>
        <!--此处从数据库读取物品信息-->
        <%
            for(int i=0;i<list.size();i++){
                Commodit commodit=list.get(i);
                pageContext.setAttribute("commodit",commodit);
        %>
        <div class="center2-1">
            <a href="commodit.do?sid=${commodit.sid}"><div class="center2-1-1"><!--此处放照片--><img src="img/${commodit.image}" width="120px" height="100px"></div></a>
            <div class="center2-1-2">
                <!--此处放物品信息-->
                <!--名字-->
                <p style="font-size: 13px;text-align: center;">${commodit.name}</p><br>
                <!--价格-->
                <p style="font-size: 18px;text-align: center;">￥${commodit.price}元</p>
            </div>
            <div class="center2-1-3">
                <a href="addCartSort.do?id=<%=commodit.getSid()+","+uid+","+commodit.getSort()%>" style="font-size: 13px;color: rgb(136, 135, 135);">
                    <input type="button" value="加入购物车" class="center-input" onclick="addCart()">
                </a>
            </div>
        </div>
        <%
            }
        %>
        <br><br>
        <div class="center3" style="border: 0px solid red;
                                            width: 100%;
                                            height: 50px;
                                            position: relative;
                                            float: left;
                                            margin-top: 10px;">
            <ul class="pager">
                <li class="previous" style="position: relative;
                                            float: left;
                                            margin-top: -15px;
                                            margin-left: 160px;">
                    <a href="#">&larr;上一页</a></li>
                <li class="next" style="position: relative;
                                            float: right;
                                            margin-top: -15px;
                                            margin-right: 160px;">
                    <a href="#">下一页&rarr;</a></li>
            </ul>
        </div>
<%--    <%--%>
<%--        }--%>
<%--    %>--%>
<%--//        <%--%>
<%--//           if(list.size()==0){--%>
<%--//        %>--%>
<%--//            <div class="center2-1">--%>
<%--//             <span>该商品还未有人发布哦~</span>--%>
<%--//            </div>--%>
<%--//        <%--%>
<%--//            }--%>
<%--//        %>--%>
    </div>
</div>
</body>
</html>

