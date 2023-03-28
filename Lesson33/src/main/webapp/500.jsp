<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Something went wrong</title>
    <jsp:include page="/view/bootstrap.jsp"/>
</head>
<body>
<jsp:include page="/view/navigate.jsp"/>
<h1 class="text-center mt-2">Sorry!</h1>
<div class="text-center">
    <img class="card-img-top w-75" src="<c:url value="/img/error/500.png"/>" alt="error-500">
</div>
</body>
</html>