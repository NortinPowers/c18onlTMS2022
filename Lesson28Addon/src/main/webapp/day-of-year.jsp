<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Day of year</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body style="background: linear-gradient(#c1c2c4, #90909a)">
<div class="card text-center position-relative">
    <div class="card-body position-absolute top-50 start-50 translate-middle" style="width: 100%">
        <h5 class="card-title">${requestScope.dayOfYearDate} this is the</h5>
        <h1 class="card-text">${requestScope.dayOfYear}</h1>
        <h5 class="card-title">day of the year</h5>
        <a class="btn btn-outline-dark" style="width: 20em" href="<c:url value="/index"/>">Back</a>
    </div>
</div>
</body>
</html>