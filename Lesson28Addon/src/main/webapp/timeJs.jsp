<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Time JS</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
      function digitalClock() {
        var date = new Date();
        var hours = date.getHours();
        var minutes = date.getMinutes();
        var seconds = date.getSeconds();
        if (hours < 10) hours = "0" + hours;
        if (minutes < 10) minutes = "0" + minutes;
        if (seconds < 10) seconds = "0" + seconds;
        document.getElementById("clock").innerHTML = hours + ":" + minutes + ":" + seconds;
        setTimeout("digitalClock()", 1000);
      }
    </script>
</head>
<body style="background: linear-gradient(#c1c2c4, #90909a)">
<div class="card text-center position-relative">
    <div class="card-body position-absolute top-50 start-50 translate-middle" style="width: 100%">
        <h5 class="card-title">Current time:</h5>
        <h1>
            <span id="clock"></span>
        </h1>
        <a class="btn btn-outline-dark" style="width: 20em" href="<c:url value="/index"/>">Back</a>
    </div>
</div>
<script>
  digitalClock();
</script>
</body>
</html>