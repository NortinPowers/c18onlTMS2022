<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add new student</title>
</head>
<body>
<link rel="stylesheet" href="css/inputForm.css">
<div class="form-box">
    <h2>Delete student by ID</h2>
    <form action="<c:url value="/delete"/>" method="post">
        <div class="value-box">
            <input type="number" name="id" required="">
            <label>ID</label>
        </div>
        <span></span>
        <span></span>
        <div class="button">
            <input type="submit" value="Delete"/>
        </div>
    </form>
</div>
</body>
</html>
