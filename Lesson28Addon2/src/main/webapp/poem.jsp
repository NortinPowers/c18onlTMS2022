<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Poem</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="card text-center position-relative">
    <div class="card-body position-absolute top-50 start-50 translate-middle" style="width: 100%">
        <pre class="card-text fw-bold font-italic" style="font-size: 1.2em">${requestScope.poem}</pre>
        <a class="btn btn-outline-dark mt-5 font-italic" style="width: 20em" href="<c:url value="/poem"/>">Re-roll</a>
    </div>
</div>
</body>
</html>