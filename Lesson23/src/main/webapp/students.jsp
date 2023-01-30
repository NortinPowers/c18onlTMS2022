<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Students</title>
</head>
<link rel="stylesheet" href="css/table.css">
<h1><span class="blue">&lt;</span>All<span class="blue">&gt;</span> <span class="yellow">Students</span></h1>
<body>
<table class="container">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Age</th>
        <th>City</th>
        <th>Course</th>
        <th></th>
    </tr>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.surname}</td>
            <td>${student.age}</td>
            <td>${student.city.name}</td>
            <td>${student.course}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>