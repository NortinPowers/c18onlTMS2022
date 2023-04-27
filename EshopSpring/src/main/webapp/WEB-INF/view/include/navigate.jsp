<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-dark bg-dark">
    <ul class="nav nav-pills ">
        <li class="nav-item">
            <a class="btn btn-outline-warning"
               href="/eshop">Home</a>
        </li>
        <li class="nav-item">
            <a class="btn btn-outline-warning ml-2"
               href="/search">
                <div class="text-center p-1">
                    <i class="bi bi-search"></i>
                </div>
            </a>
        </li>
        <c:set var="authorizedUser" value="${sessionScope.get('userAccessPermission')}"/>
        <c:if test="${authorizedUser != null}">
            <li class="nav-item">
                <a class="btn btn-outline-info ml-2" href="/favorites">Favorites</a>
            </li>
            <li class="nav-item">
                <a class="btn btn-outline-info ml-2" href="/cart">Shopping cart</a>
            </li>
        </c:if>
    </ul>
    <c:choose>
        <c:when test="${authorizedUser == null}">
            <a id="loginButton" class="form-inline my-2 my-lg-0" style="text-decoration: none"
               href="/login">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Login</button>
            </a>
        </c:when>
        <c:otherwise>
            <h2 style="text-align: center; color: #e5a0a4; margin-right: 11%; text-shadow: 1px 1px 2px red, 0 0 1em #ff004d, 0 0 0.2em #ff0062;">
                Welcome ${authorizedUser.name}</h2>
            <ul class="nav nav-pills ">
                <li class="nav-item">
                    <a id="accountButton"
                       href="/account">
                        <button class="btn btn-outline-success mr-2" type="submit">Account</button>
                    </a>
                </li>
                <li class="nav-item">
                    <a id="exitButton"
                       href="/logout">
                        <button class="btn btn-outline-success" type="submit">Exit</button>
                    </a>
                </li>
            </ul>
        </c:otherwise>
    </c:choose>
</nav>