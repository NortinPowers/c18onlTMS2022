<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Products</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body style="background: #243855;">
<jsp:include page="/view/navigate.jsp"/>
<div class="card-deck mr-5 ml-5 mt-5">
    <c:forEach var="product" items="${applicationScope.products}">
        <div class="card">
            <img class="card-img-top" style=" height: 25rem"
                 src="/img/${fn:toLowerCase(product.type)}/${product.name}.jpg"
                 alt="${product.name}">
            <div class="card-body">
                <h5 class="card-title" style="text-align: -webkit-center;">${product.name}</h5>
                <p class="card-text font-italic">${product.info}.</p>
            </div>
            <div class="card-footer text-center">
                <small class="text-muted" style="font-size: 20px;">${product.price}</small>
            </div>
            <div class="btn-group btn-group-sm">
                <a href="<c:url value="/add-cart?id=${product.id}&shop=true&location=none"/>"
                   class="btn btn-success active w-75"
                   aria-current="page">Buy</a>
                <a href="<c:url value="/add-cart?id=${product.id}&shop=none&location=none"/>" class="btn btn-success">
                    <div class="text-center mt-1">
                        <i class="bi bi-cart-plus"></i>
                    </div>
                </a>
                <a href="<c:url value="/add-favorite?id=${product.id}&shop=none&location=none"/>"
                   class="btn btn-success">
                    <div class="text-center mt-1">
                        <i class="bi bi-heart"></i>
                    </div>
                </a>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>