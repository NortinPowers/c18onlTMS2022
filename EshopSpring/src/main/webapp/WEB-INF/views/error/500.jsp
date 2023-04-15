<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Something went wrong</title>
    <jsp:include page="../include/bootstrap.jsp"/>
</head>
<body>
<jsp:include page="../include/navigate.jsp"/>
<h1 class="text-center mt-2">Sorry!</h1>
<h5 class="text-center text-danger-emphasis">${errorMessage}</h5>
<div class="text-center">
    <img class="card-img-top w-75" src="${pageContext.request.contextPath}/images/error/500.png" alt="error-500">
    <%--    <img class="card-img-top w-75" src="<c:url value="/img/error/500.png"/>" alt="error-500">--%>
</div>
</body>
</html>