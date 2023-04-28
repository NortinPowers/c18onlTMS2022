<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/page.css">
    <style>
        p.error {
            color: #f57b07;
            padding-left: 160px;
            font-size: large;
        }
    </style>
</head>
<body>
<div class="login-box">
    <h2>Login</h2>
    <form action="/login-verify" method="post">
        <div class="user-box">
            <p class="error" style="padding-left: 200px">${loginError}</p>
            <input type="text" name="login" required="">
            <label>Username</label>
        </div>
        <div class="user-box">
            <p class="error">${passwordError}</p>
            <input type="password" name="password" required="">
            <label>Password</label>
        </div>
        <div style="margin-top: 15px">
            <input type="submit" value="Submit"/>
        </div>
    </form>
    <a href="/create-user" class="button">Register</a>
    <a href="/eshop" class="button">Back</a>
</div>
</body>
</html>