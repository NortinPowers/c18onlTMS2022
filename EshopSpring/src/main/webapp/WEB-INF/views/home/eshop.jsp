<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>EShop</title>
    <jsp:include page="../include/bootstrap.jsp"/>
</head>
<body style="background: #243855">
<jsp:include page="../include/navigate.jsp"/>
<div class="card-deck w-25 ml-5 mt-5">
    <div class="card">
        <div class="card-header bg-danger text-white text-center text-nowrap">TV</div>
        <a href="/products-page?type=tv">
            <img class="card-img-top" src="${pageContext.request.contextPath}/images/tv.jpg" alt="TV">
        </a>
    </div>
    <div class="card">
        <div class="card-header bg-danger text-white text-center text-nowrap">Phone</div>
        <a href="/products-page?type=phone">
            <img class="card-img-top" src="${pageContext.request.contextPath}/images/phone.jpg" alt="Phone">
        </a>
    </div>
</div>
</body>
</html>