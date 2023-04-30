<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shopping-cart</title>
    <jsp:include page="../include/bootstrap.jsp"/>
</head>
<body style="background: #dee4ec">
<jsp:include page="../include/navigate.jsp"/>
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
    <c:forEach var="product" items="${cartProducts}">
        <tr>
            <th scope="row">-</th>
            <td class="font-italic">${product.left.name}</td>
            <td class="font-italic">${product.left.price}</td>
            <td class="font-italic">${product.right}</td>
            <td class="font-italic">${product.left.price*product.right}</td>
            <td class="font-italic">
                <a href="/delete-cart?id=${product.left.id}">
                    Delete
                </a>
            </td>
        </tr>
    </c:forEach>
    <tr style="border-top: chartreuse solid 2px">
        <td colspan="5" style="text-align: right; font-weight: bold">Full price:</td>
        <td class="font-weight-bold" style="text-align: center">${fullPrice}</td>
    </tr>
    </tbody>
</table>
<c:set var="authorizedUser" value="${sessionScope.get('userAccessPermission')}"/>
<c:set var="price" value="${fullPrice}"/>
<c:if test="${(authorizedUser != null) and (price > 0)}">
    <form method="post" action="/cart-processing">
        <input type="submit" name="buy" value="Buy" class="btn btn-lg btn-success btn-block w-75 ml-5 mt-5"/>
    </form>
</c:if>
</body>
</html>