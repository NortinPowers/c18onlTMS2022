<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Favorites</title>
    <jsp:include page="../include/bootstrap.jsp"/>
</head>
<body style="background: #243855">
<jsp:include page="../include/navigate.jsp"/>
<div class="row row-cols-1 row-cols-md-3 mr-5 ml-5 mt-5">
    <c:forEach var="product" items="${applicationScope.favoriteProducts}">
        <div class="card mr-5 ml-5 mt-5 shadow bg-body-tertiary rounded" style="max-width: 14rem">

            <a href="/product/${product.id}">
                <img class="card-img-top" style="max-height: 20rem"
                     src="${pageContext.request.contextPath}/images/${fn:toLowerCase(product.type)}/${product.name}.jpg"
                     alt="${product.name}">

            </a>
                <%--        <img class="card-img-top" style="max-height: 20rem">--%>
                <%--                 src="/img/${fn:toLowerCase(product.type)}/${product.name}.jpg"--%>
                <%--    alt="${product.name}">--%>
            <div class="card-body">
                <h5 class="card-title text-nowrap" style="text-align: -webkit-center">${product.name}</h5>
                <p class="card-text font-italic">${product.info}.</p>
            </div>
            <div class="card-footer text-center">
                <small class="text-muted" style="font-size: 20px">${product.price}$</small>
            </div>
            <c:set var="access" value="${sessionScope.get('userAccessPermission')}"/>
                <%--            <c:set var="buyPath" value="/add-cart?id=${product.id}&shop=true&location=none"/>--%>
                <%--            <c:set var="lazyBuyPath" value="/add-cart?id=${product.id}&shop=none&location=favorite"/>--%>
                <%--            <c:set var="favoriteMarkPath" value="/add-cart?id=${product.id}&shop=none&location=favorite"/>--%>
            <c:if test="${access != null}">
                <%--                <jsp:include page="../include/buy-button-group.jsp"/>--%>
                <div class="btn-group btn-group-sm mb-1">
                    <a href="/add-cart?id=${product.id}&shop=true&location=none"
                        <%--                    <a href="<c:url value="/eshop?command=add-cart&id=${product.id}&shop=true&location=none"/>"--%>
                       class="btn btn-success active w-75"
                       aria-current="page">Buy</a>
                    <a href="/add-cart?id=${product.id}&shop=none&location=favorite"
                        <%--                    <a href="<c:url value="/eshop?command=add-cart&id=${product.id}&shop=none&location=favorite"/>"--%>
                       class="btn btn-success">
                        <div class="text-center mt-1">
                            <i class="bi bi-cart-plus"></i>
                        </div>
                    </a>
                    <a href="/delete-favorite?id=${product.id}" class="btn btn-success">
                            <%--                    <a href="<c:url value="/eshop?command=delete-favorite-product&id=${product.id}"/>" class="btn btn-success">--%>
                        <div class="text-center mt-1">
                            <i class="bi bi-heartbreak"></i>
                        </div>
                    </a>
                </div>
            </c:if>
        </div>
    </c:forEach>
</div>
</body>
</html>