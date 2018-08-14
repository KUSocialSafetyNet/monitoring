<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10.08.2018
  Time: 16:15
  To change this template use File | Settings | File Templates.
  <a href="${pageContext.request.contextPath}/res">Hello</a>
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Главная</title>
    <style>
        <%@include file="/resources/css/style.css"%>
    </style>
    <script src="/graid.js"></script>
</head>
<body>
<div class="container">
    <div class = "big_tittle">
        <h1>Welcome to Service Page</h1>
        <h2>this page content all servisec in our system</h2>
    </div>
    <div class="well well-sm">
    </div>
    <div id="products" class="row list-group">
        <div class="item  col-xs-4 col-lg-4">
            <div class="thumbnail">
                <a class="btn btn-success" href="${pageContext.servletContext.contextPath}/ftp154"> <img width = "150px" height = "auto" class="group list-group-image" src="<c:url value="resources/images/server.png" ></c:url>" alt="Сервис проверки ежедневного, еженедельного и ежемесячного бэкапирование Баз Данных" /> </a>
                <div class="caption">
                    <h4 class="group inner list-group-item-heading">
                        Бэкапирование сервера</h4>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <h5 class="lead">
                                10.13.25.154</h5>
                        </div>
                    </div>
                </div>
            </div>
            <div class="thumbnail">
                <a class="btn btn-success" href="${pageContext.servletContext.contextPath}/ftp214"> <img width = "150px" height = "auto" class="group list-group-image" src="<c:url value="resources/images/server.png" ></c:url>" alt="Сервис проверки ежедневного, еженедельного и ежемесячного бэкапирование Баз Данных" /> </a>
                <div class="caption">
                    <h4 class="group inner list-group-item-heading">
                        Бэкапирование сервера</h4>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <h5 class="lead">
                                10.13.0.214</h5>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>