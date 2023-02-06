<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Delete student</title>
    <link rel="stylesheet" href="<c:url value="/css/page.css"/>">
</head>
<body>
<div class="login-box">
    <h2>Delete student by ID</h2>
    <form action="<c:url value="/view/delete"/>" method="post">
        <div class="user-box">
            <input type="number" name="id" required="">
            <label>ID</label>
        </div>
        <div>
            <input type="submit" value="Delete"/>
        </div>
    </form>
    <a href="<c:url value="/view/students"/>" class="button">Back</a>
</div>
</body>
</html>