<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Open Form</title>
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
<div>
    <a id="db" class="button purple" href="${pageContext.request.contextPath}/students">
        <i class="fa fa-address-book" aria-hidden="true"></i>
        <span>Работа с БД</span>
    </a>
</div>
<div>
    <a id="exit" class="button blue" href="${pageContext.request.contextPath}/exit">
        <i class="fa fa-window-close" aria-hidden="true"></i>
        <span>Exit</span>
    </a>
</div>
</body>
</html>