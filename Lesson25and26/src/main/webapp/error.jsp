<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String message = pageContext.getException().getMessage();
    String exception = pageContext.getException().getClass().toString();
%>
<html>
<head>
    <title>Exception</title>
    <link rel="stylesheet" href="css/glitch.css">
</head>
<body>
<h1 style="
font-size: 30px;
text-shadow: 0 0 0 #eee, 2px 2px 1px #00dcdc, -2px -1px 0 #ff3232;">
    Type: <%= exception%>
    Message: <%= message %>
</h1>
</body>
</html>