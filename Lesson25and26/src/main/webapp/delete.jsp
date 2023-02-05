<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add new student</title>
    <link rel="stylesheet" href="css/page.css">
</head>
<body>
<div class="login-box">
    <h2>Delete student by ID</h2>
    <form action="<c:url value="/delete"/>" method="post">
        <div class="user-box">
            <input type="number" name="id" required="">
            <label>ID</label>
        </div>
        <span></span>
        <span></span>
        <div>
            <input type="submit" value="Delete"/>
        </div>
    </form>
    <form action="<c:url value="/students"/>">
        <br>
        <div>
            <input type="submit" value="Back">
        </div>
    </form>
</div>
</body>
</html>