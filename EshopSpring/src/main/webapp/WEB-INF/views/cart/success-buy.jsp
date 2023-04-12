<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Success buying</title>
    <jsp:include page="../include/bootstrap.jsp"/>
</head>
<body style="background: #dee4ec">
<jsp:include page="../include/navigate.jsp"/>
<div class="card mt-5 ml-5 mr-5 mb-5 text-center border-success mb-3 shadow bg-body-tertiary rounded">
    <div class="card-header">
        <h3 style="text-shadow: 1px 1px 2px #3f0909">Purchase completed successfully</h3>
    </div>
    <div class="card-body">
        <blockquote class="blockquote mb-0">
            <p>We will be glad to see you again in our store</p>
            <footer class="blockquote-footer">With respect <cite>the store's team</cite></footer>
        </blockquote>
    </div>
</div>
</body>
</html>