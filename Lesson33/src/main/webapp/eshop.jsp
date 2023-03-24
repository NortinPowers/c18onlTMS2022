<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>EShop</title>
    <jsp:include page="/view/bootstrap.jsp"/>
</head>
<body style="background: linear-gradient(#0d1723, #243855)">
<jsp:include page="/view/navigate.jsp"/>
<div class="card-deck w-25 ml-5 mt-5">
    <div class="card">
        <div class="card-header bg-danger text-white text-center text-nowrap">TV</div>
        <a href="<c:url value="/eshop?command=products&type=tv"/>">
            <img class="card-img-top" src="<c:url value="/img/tv.jpg"/>" alt="TV">
        </a>
    </div>
    <div class="card">
        <div class="card-header bg-danger text-white text-center text-nowrap">Phone</div>
        <a href="<c:url value="/eshop?command=products&type=phone"/>">
            <img class="card-img-top" src="<c:url value="/img/phone.jpg"/>" alt="Phone">
        </a>
    </div>
    <div class="card">
        <div class="card-header bg-danger text-white text-center text-nowrap">Search</div>
        <a href="<c:url value="/view/search.jsp"/>">
            <img class="card-img-top" src="<c:url value="/img/search.jpg"/>" alt="Phone">
        </a>
    </div>
</div>
</body>
</html>