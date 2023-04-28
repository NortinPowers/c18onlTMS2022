<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>${product.name}</title>
    <jsp:include page="../include/bootstrap.jsp"/>
</head>
<body>
<jsp:include page="../include/navigate.jsp"/>
<div class="card mr-5 ml-5 mt-5 shadow bg-body-tertiary rounded" style="max-width: 14rem">
    <img class="card-img-top" style="max-height: 20rem"
         src="${pageContext.request.contextPath}/images/${fn:toLowerCase(product.type)}/${product.name}.jpg"
         alt="${product.name}">
    <div class="card-body">
        <h5 class="card-title text-nowrap" style="text-align: -webkit-center">${product.name}</h5>
        <p class="card-text font-italic">${product.info}.</p>
    </div>
    <div class="card-footer text-center">
        <small class="text-muted" style="font-size: 20px">${product.price}$</small>
    </div>
    <c:set var="authorizedUser" value="${sessionScope.get('userAccessPermission')}"/>
    <c:if test="${authorizedUser != null}">
        <div class="btn-group btn-group-sm">
            <a href="/add-cart?id=${product.id}&shop=true&location=none"
               class="btn btn-success active w-75"
               aria-current="page">Buy</a>
            <a href="/add-cart?id=${product.id}&shop=none&location=product-page"
               class="btn btn-success">
                <div class="text-center mt-1">
                    <i class="bi bi-cart-plus"></i>
                </div>
            </a>
            <a href="/add-favorite?id=${product.id}&shop=none&location=product-page"
               class="btn btn-success">
                <div class="text-center mt-1">
                    <i class="bi bi-heart"></i>
                </div>
            </a>
        </div>
    </c:if>
</div>
</body>
</html>