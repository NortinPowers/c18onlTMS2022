<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="<c:url value="/css/page.css"/>">
</head>
<body>
<div class="login-box">
    <h2>Register</h2>
    <form action="<c:url value="/create-user"/>" method="post">
        <div class="user-box">
            <input type="text" name="login" required="">
            <label>Username</label>
        </div>
        <div class="user-box">
            <input type="password" name="password" required="">
            <label>Password</label>
        </div>
        <div class="user-box">
            <input type="password" name="verifyPassword" required="">
            <label>Password</label>
        </div>
        <div style="margin-top: 15px">
            <input type="submit" value="Register"/>
        </div>
    </form>
    <a href="<c:url value="/login"/>" class="button">Back</a>
</div>
</body>
</html>