<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shopping-cart</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body style="background: #dee4ec;">
<jsp:include page="/view/navigate.jsp"/>
<table class="table table-sm table-dark w-75 ml-5 mt-5" style="text-align: center">
    <thead>
    <tr style="text-align: center">
        <th scope="col">#</th>
        <th scope="col">Product name</th>
        <th scope="col">Price</th>
        <th scope="col">#</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${cartProducts}">
        <tr>
            <th scope="row">-</th>
            <td class="font-italic">${product.name}</td>
            <td class="font-italic">${product.price}</td>
            <td class="font-italic">
                <a href="<c:url value="/delete-cart-product?id=${product.id}"/>">
                    Delete
                </a>

            </td>
        </tr>
    </c:forEach>
    <tr style="border-top: chartreuse solid 2px">
        <td colspan="3" style="text-align: right">Full price:</td>
        <td class="font-weight-bold" style="text-align: center">${full_price}</td>
    </tr>
    </tbody>
</table>
<c:set var="access" value="${sessionScope.get('accessPermission')}"/>
<c:if test="${access==null}">
    <a href="<c:url value="/login"/>" style="text-decoration: none">
        <button type="button" class="btn btn-lg btn-success btn-block w-75 ml-5 mt-5">Login</button>
    </a>
</c:if>
<c:if test="${access!=null}">
    <a href="<c:url value="/view/success-buy.jsp"/>" style="text-decoration: none">
        <button type="button" class="btn btn-lg btn-success btn-block w-75 ml-5 mt-5">Buy</button>
    </a>
</c:if>
</body>
</html>