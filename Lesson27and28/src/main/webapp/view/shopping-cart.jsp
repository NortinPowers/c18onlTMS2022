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
        <th scope="col">Count</th>
        <th scope="col">Total price</th>
        <th scope="col">#</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${applicationScope.cartProducts}">
        <tr>
            <th scope="row">-</th>
            <td class="font-italic">${product.left.name}</td>
            <td class="font-italic">${product.left.price}</td>
            <td class="font-italic">${product.right}</td>
            <td class="font-italic">${product.left.price*product.right}</td>
            <td class="font-italic">
                <a href="<c:url value="/delete-cart-product?id=${product.left.id}"/>">
                    Delete
                </a>
            </td>
        </tr>
    </c:forEach>
    <tr style="border-top: chartreuse solid 2px">
        <td colspan="4" style="text-align: right; font-weight: bold">Full price:</td>
        <td class="font-weight-bold" style="text-align: center">${applicationScope.fullPrice}</td>
    </tr>
    </tbody>
</table>
<c:if test="${applicationScope.full_price != 0}">
    <c:set var="authorizedUser" value="${sessionScope.get('accessPermission')}"/>
    <c:if test="${authorizedUser == null}">
        <a href="<c:url value="/login"/>" style="text-decoration: none">
            <button type="button" class="btn btn-lg btn-success btn-block w-75 ml-5 mt-5">Login</button>
        </a>
    </c:if>
    <c:if test="${authorizedUser != null}">
        <form method="post" action="<c:url value="/view/shopping-cart"/>">
            <input type="hidden" name="buy" value="buy">
            <input type="submit" value="Buy" class="btn btn-lg btn-success btn-block w-75 ml-5 mt-5"/>
        </form>
    </c:if>
</c:if>
</body>
</html>