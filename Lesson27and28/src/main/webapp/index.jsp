<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Test Bootstrap/JSP</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body style="background: linear-gradient(#0d1723, #243855);">
<jsp:include page="/view/navigate.jsp"/>
<div class="card-deck w-25 ml-5 mt-5">
    <div class="card">
        <div class="card-header bg-danger text-white text-center">TV</div>
        <a href="<c:url value="/view/products?type=tv"/>">
            <img class="card-img-top" src="<c:url value="/img/tv.jpg"/>" alt="TV">
        </a>
    </div>
    <div class="card">
        <div class="card-header bg-danger text-white text-center">Phone</div>
        <a href="<c:url value="/view/products?type=phone"/>">
            <img class="card-img-top" src="<c:url value="/img/phone.jpg"/>" alt="Phone">
        </a>
    </div>
</div>
</body>
</html>