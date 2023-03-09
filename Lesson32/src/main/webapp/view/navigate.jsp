<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-dark bg-dark">
    <ul class="nav nav-pills ">
        <li class="nav-item">
            <a class="btn btn-outline-warning"
               href="<c:url value="/"/>">Home</a>
        </li>
        <c:set var="access" value="${sessionScope.get('accessPermission')}"/>
        <c:if test="${access != null}">
            <li class="nav-item">
                <a class="btn btn-outline-info ml-2" href="<c:url value="/view/favorites"/>">Favorites</a>
            </li>
            <li class="nav-item">
                <a class="btn btn-outline-info ml-2" href="<c:url value="/view/shopping-cart"/>">Shopping cart</a>
            </li>
        </c:if>
    </ul>
    <c:set var="access" value="${sessionScope.get('accessPermission')}"/>
    <c:choose>
        <c:when test="${access == null}">
            <a id="loginButton" class="form-inline my-2 my-lg-0" style="text-decoration: none"
               href="<c:url value="/login"/>">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Login</button>
            </a>
        </c:when>
        <c:otherwise>
            <p style="text-align: center; font-size: 1.2em; color: #e5a0a4; margin-right: 5%; text-shadow: 1px 1px 2px red, 0 0 1em #ff004d, 0 0 0.2em #ff0062;">
                Welcome ${sessionScope.get('userName')}</p>
            <ul class="nav nav-pills ">
                <li class="nav-item">
                    <a id="accountButton"
                       href="<c:url value="/account"/>">
                        <button class="btn btn-outline-success mr-2" type="submit">Account</button>
                    </a>
                </li>
                <li class="nav-item">
                    <a id="exitButton"
                       href="<c:url value="/exit"/>">
                        <button class="btn btn-outline-success" type="submit">Exit</button>
                    </a>
                </li>
            </ul>
        </c:otherwise>
    </c:choose>
</nav>