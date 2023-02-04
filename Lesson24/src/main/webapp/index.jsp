<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<link rel="stylesheet" href="css/login.css">
<body>
<div class="login-box">
    <h2>Login</h2>
    <form action="<c:url value="/hidden-page"/>" method="post">
        <div class="user-box">
            <input type="text" name="name" required="">
            <label>Username</label>
        </div>
        <div class="user-box">
            <input type="password" name="password" required="">
            <label>Password</label>
        </div>
        <span></span>
        <span></span>
        <div>
            <input type="submit" value="Submit"/>
        </div>
    </form>
</div>
</body>
</html>
