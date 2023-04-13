<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--<c:set var="access" value="${sessionScope['userAccessPermission']}"/>--%>
<%--<c:set var="access" value="${sessionScope.get('userAccessPermission')}"/>--%>
<%--<c:if test="${not empty access}">--%>
<%--<c:if test="${access != null}">--%>
<div class="btn-group btn-group-sm mb-1">
    <a href="${buyPath}"
       class="btn btn-success active w-75"
       aria-current="page">Buy</a>
    <a href="${lazyBuyPath}"
       class="btn btn-success">
        <div class="text-center mt-1">
            <i class="bi bi-cart-plus"></i>
        </div>
    </a>
    <a href="${favoriteMarkPath}"
       class="btn btn-success">
        <div class="text-center mt-1">
            <i class="bi bi-heart"></i>
        </div>
    </a>
</div>
<%--</c:if>--%>