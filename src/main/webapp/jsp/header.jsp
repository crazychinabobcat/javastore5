<%--
  Created by IntelliJ IDEA.
  User: administratorlynx
  Date: 2019/1/17
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<body>
<head>
</head>
    <title>Lynx网络商城</title>
    <div class="container-fluid">
        <!--
            描述：菜单栏
        -->
        <div class="container-fluid">
            <div class="col-md-4">
                <img src="${pageContext.request.contextPath}/img/logo2.png" />
            </div>
            <div class="col-md-5">
                <img src="${pageContext.request.contextPath}/img/header.png" />
            </div>
            <div class="col-md-3" style="padding-top:20px">
                <ol class="list-inline">
                    <c:if test="${empty loginUser}">
                    <li><a href="UserServlet?method=loginUI">登录</a></li>
                    <li><a href="UserServlet?method=regisUI">注册</a></li>
                    </c:if>

                    <c:if test="${not empty loginUser}">
                        <li>欢迎${loginUser.username}</li>
                    <li><a href="${pageContext.request.contextPath}/jsp/cart.jsp">购物车</a></li>
                    <li><a href="${pageContext.request.contextPath}/OrderServlet?method=findMyOrdersWithPage&num=1">我的订单</a></li>
                        <li><a href="UserServlet?method=loginOut">退出</a></li>
                    </c:if>
                </ol>
            </div>
        </div>
        <!--
            描述：导航条
        -->
        <div class="container-fluid">
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="${pageContext.request.contextPath}/IndexServlet">首页</a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav" id="myUrl">
                          <%--  <li class="active"><a href="jsp/product_list.jsp">手机数码<span class="sr-only">(current)</span></a></li>
                            <li><a href="#">电脑办公</a></li>
                            <li><a href="#">电脑办公</a></li>
                            <li><a href="#">电脑办公</a></li>--%>
                        </ul>
                        <form class="navbar-form navbar-right" role="search">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Search">
                            </div>
                            <button type="submit" class="btn btn-default">Submit</button>
                        </form>

                    </div>
                    <!-- /.navbar-collapse -->
                </div>
                <!-- /.container-fluid -->
            </nav>
        </div>
    </div>
</body>

<script>
    $(function () {
        var url = "/store5/CategoryServlet";
        var obj ={"method":"findAllacts"};
        $.post(url,obj,function(data){
            $.each(data,function(i ,obj){
                    var li = "<li> <a href='/store5/ProductServlet?method=findProductsByCidwithPage&num=1&cid="+obj.cid+"'>"+obj.cname+"</a></li>"
                $("#myUrl").append(li);
                });
            },"json");
    });
</script>
</html>
