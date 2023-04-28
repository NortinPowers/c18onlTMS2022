<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Personal Account</title>
    <jsp:include page="../include/bootstrap.jsp"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body style="background: #243855">
<jsp:include page="../include/navigate.jsp"/>
<div class="card text-center" style="background: #2a415e">
    <div class="card-header text-center">
        <h2 style="color: #e3e1da; text-shadow: #FC0 1px 0 10px;">Personal data</h2>
    </div>
    <div class="card-body">
        <div class="row g-3" style="text-shadow: 1px 1px 2px #0a0a33;">
            <div class="col-md-5">
                <p class="form-control border-success rounded-pill form-control form-control-lg">${models.userDto.name}</p>
            </div>
            <div class="col-md-5">
                <p class="form-control border-success rounded-pill form-control form-control-lg">${models.userDto.email}</p>
            </div>
            <div class="col-md-5">
                <p class="form-control border-success rounded-pill form-control form-control-lg">${models.userDto.surname}</p>
            </div>
            <div class="col-md-5">
                <fmt:parseDate value="${models.userDto.birthday}" type="date" pattern="yyyy-MM-dd" var="parsedDate"/>
                <fmt:formatDate value="${parsedDate}" type="date" pattern="dd MMMM yyyy" var="date"/>
                <p class="form-control border-success rounded-pill form-control form-control-lg">${date}</p>
            </div>
        </div>
    </div>
</div>
<div class="card text-center" style="background: #2a415e">
    <div class="card-header text-center">
        <h2 style="color: #e3e1da; text-shadow: #FC0 1px 0 10px;">Order history:</h2>
    </div>
</div>
<c:choose>
    <c:when test="${models.userOrder == null}">
        <div class="card text-center" style="background: #2a415e">
            <div class="card-header text-center">
                <h4 style="color: #e3e1da; text-shadow: #FC0 1px 0 10px;">The order history is empty</h4>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <div class="accordion" id="accordionPanelsStayOpenExample">
            <c:forEach var="order" items="${models.userOrder}">
                <div class="accordion-item" style="background: #314b6c">
                    <h2 class="accordion-header" id="panelsStayOpen-heading" style="background: #406491">
                        <button class="accordion-button" type="button" data-bs-toggle="collapse"
                                data-bs-target="#panelsStayOpen-collapse" aria-expanded="true"
                                aria-controls="panelsStayOpen-collapse">
                            Order: ${order.order} Date: ${order.date}
                        </button>
                    </h2>
                    <div id="panelsStayOpen-collapse" class="accordion-collapse collapse show"
                         aria-labelledby="panelsStayOpen-heading">
                        <div class="accordion-body">
                            <div class="row row-cols-1 row-cols-md-3 g-4 text-center">
                                <c:forEach var="product" items="${order.productsDto}">
                                    <div class="col">
                                        <div class="card h-100 shadow bg-body-tertiary rounded">
                                            <div class="row g-0">
                                                <div class="col-md-4">
                                                    <img class="card-img-top"
                                                         src="${pageContext.request.contextPath}/images/${fn:toLowerCase(product.type)}/${product.name}.jpg"
                                                         alt="${product.name}">
                                                </div>
                                                <div class="col-md-8">
                                                    <div class="card-body">
                                                        <h5 class="card-title">${product.name}</h5>
                                                        <p class="card-text">${product.info}</p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="card-body">
                                                <h5>${product.price}$</h5>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:otherwise>
</c:choose>
</body>
</html>