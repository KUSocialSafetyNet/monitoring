<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<%@include file="/WEB-INF/pages/header.jsp" %>
<body>
<div class="container">
    <div class="big_tittle">
        <h1>Welcome to Portal KU"Soczachita"</h1>
        <h2>this page content all services in our system</h2>
    </div>
    <div class="well well-sm">
    </div>
    <div id="products" class="row list-group">
        <div class="item  col-xs-4 col-lg-4">
            <div class="thumbnail">
                <a class="btn btn-success" href="${pageContext.servletContext.contextPath}/backup">
                    <img width="150px"
                         height="auto"
                         class="group list-group-image"
                         src="<c:url value="/resources/images/server.png" ></c:url>"
                         alt="Сервис проверки ежедневного, еженедельного и ежемесячного бэкапирование Баз Данных"/>
                </a>
                <div class="caption">
                    <h4 class="group inner list-group-item-heading">
                        Проверка бэкапирования серверов</h4>
                    <div class="row">

                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>