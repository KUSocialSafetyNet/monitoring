<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/WEB-INF/pages/header.jsp" %>
<body>
<%int i = 0;%>
<div class="container">
    <div class="big_tittle">
        <h1>Welcome to FTP backup Page</h1>
        <h2>Select server:</h2>
    </div>
    <div class="well well-sm">
    </div>
    <div id="products" class="row list-group">
        <div class="item  col-xs-4 col-lg-4">
            <c:forEach items="${serverList}" var="serverList">
                <div class="thumbnail">
                    <a class="btn btn-success" href="${pageContext.servletContext.contextPath}${root}?id=<%=i%>"> <img
                            width="150px" height="auto" class="group list-group-image"
                            src="<c:url value="/resources/images/server.png" />"
                            alt="Проверка бэкапирования на сервере ${serverList}"/> </a>
                    <div class="caption">
                        <h4 class="group inner list-group-item-heading">
                            Бэкапирование сервера</h4>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                <h5 class="lead">${serverList}</h5>
                            </div>
                        </div>
                    </div>
                </div>
                <%i++;%>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>