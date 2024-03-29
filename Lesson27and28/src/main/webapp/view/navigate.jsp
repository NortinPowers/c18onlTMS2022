<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-dark bg-dark">
    <ul class="nav nav-pills ">
        <li class="nav-item">
            <a class="nav-link navbar-brand mb-0 h1" style="border: chartreuse solid 2px"
               href="<c:url value="/"/>">Home</a>
        </li>
        <c:set var="authorizedUser" value="${sessionScope.get('accessPermission')}"/>
        <c:if test="${authorizedUser != null}">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/view/favorites"/>">Favorites</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/view/shopping-cart"/>">Shopping cart</a>
            </li>
        </c:if>
    </ul>
    <c:set var="access" value="${sessionScope.get('accessPermission')}"/>
    <c:choose>
        <c:when test="${authorizedUser == null}">
            <a id="loginButton" class="form-inline my-2 my-lg-0" style="text-decoration: none"
               href="<c:url value="/login"/>">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Login</button>
            </a>
        </c:when>
        <c:otherwise>
            <p style="text-align: center; font-size: 1.2em; color: chartreuse; margin-right: 5%">
                Welcome ${sessionScope.get('userName')}</p>
            <a id="loginButton" class="form-inline my-2 my-lg-0" style="text-decoration: none;"
               href="<c:url value="/exit"/>">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Exit</button>
            </a>
        </c:otherwise>
    </c:choose>
</nav>