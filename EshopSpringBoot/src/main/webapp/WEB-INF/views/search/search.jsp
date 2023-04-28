<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Search</title>
    <jsp:include page="../include/bootstrap.jsp"/>
</head>
<body>
<jsp:include page="../include/navigate.jsp"/>
<div class="container text-center mt-3 w-100 p-0">
    <div class="row">
        <div class="col">
            <div class="container-fluid">
                <form class="d-flex" role="search" action="/search-param" method="post">
                    <input class="form-control me-2" type="search" name="search-condition" placeholder="Search"
                           aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="container mt-1 min-vw-100 p-3">
    <div class="row grid gap-3">
        <div class="col-5 ml-4">
            <div class="row ml-3 mr-3">
                <div class="col-12 border border-secondary rounded rounded-5 shadow p-3 mb-5 bg-body-tertiary rounded">
                    <h3 class="text-start ml-5">Filter:</h3>
                    <form action="/search-filter" method="post">
                        <div class="row text-center">
                            <div class="col-sm-12">
                                <select class="form-select col-8 col-sm-12 p-2 text-center"
                                        aria-label="Default select example" name="select">
                                    <option selected value="all">Categories</option>
                                    <option value="tv">TV</option>
                                    <option value="phone">Phone</option>
                                </select>
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col">
                                <div class="form-outline">
                                    <input type="text" id="minPrice" name="min-price"
                                           class="form-control form-control-lg text-center"
                                           placeholder="Min Price"/>
                                </div>
                            </div>
                            <div class="col">
                                <div class="form-outline">
                                    <input type="text" id="maxPrice" name="max-price"
                                           class="form-control form-control-lg text-center"
                                           placeholder="Max price"/>
                                </div>
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-6"></div>
                            <div class="col-6 col-sm-6">
                                <div>
                                    <input class="col-sm-12 btn btn-dark" type="submit" value="Filter"/>
                                </div>
                                <div>
                                    <a class="col-sm-12 btn btn-dark mt-2"
                                       href="/search">
                                        Reset filter
                                    </a>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-6 border border-secondary rounded rounded-5 shadow p-2 ml-5 bg-body-tertiary rounded">
            <c:set var="filter" value="${applicationScope.get('filter')}"/>
            <c:choose>
                <c:when test="${filter == null}">
                    <c:set var="products" value="${sessionScope.foundProducts}"/>
                </c:when>
                <c:otherwise>
                    <c:set var="products" value="${sessionScope.filterFoundProducts}"/>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${products.size()==0}">
                    <h5 class="text-center">No suitable products found. Enter or change the search terms!</h5>
                </c:when>
                <c:otherwise>
                    <c:forEach var="product" items="${products}">
                        <div class="card mb-3 ml-1 border border-secondary rounded rounded-5 shadow-sm p-2 bg-body-tertiary rounded mr-1">
                            <div class="container text-center mb-2">
                                <div class="row">
                                    <c:set var="authorizedUser" value="${sessionScope.get('userAccessPermission')}"/>
                                    <c:choose>
                                        <c:when test="${authorizedUser == null}">
                                            <div class="col-sm-12">
                                                <a href="/product/${product.id}"
                                                   class="text-light text-decoration-none btn btn-success btn-block w-auto"
                                                   aria-current="page">
                                                    To product
                                                </a>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="col-sm-3 ml-4 mr-2">
                                                <a href="/product/${product.id}"
                                                   class="text-light text-decoration-none btn btn-success btn-block w-100"
                                                   aria-current="page">
                                                    To product
                                                </a>
                                            </div>
                                            <div class="col-sm-3">
                                                <a href="/add-cart?id=${product.id}&shop=true&location=none"
                                                   class="text-light text-decoration-none btn btn-success btn-block w-100"
                                                   aria-current="page">
                                                    Buy
                                                </a>
                                            </div>
                                            <div class="col-sm-2 btn btn-success ml-3 mr-3">
                                                <a href="/add-cart?id=${product.id}&shop=none&location=search">
                                                    <div class="text-center text-light text-decoration-none p-1">
                                                        <i class="bi bi-cart-plus"></i>
                                                    </div>
                                                </a>
                                            </div>
                                            <div class="col-sm-2 btn btn-success ml-3 mr-3">
                                                <a href="/add-favorite?id=${product.id}&shop=none&location=search">
                                                    <div class="text-center text-light text-decoration-none p-1">
                                                        <i class="bi bi-heart"></i>
                                                    </div>
                                                </a>
                                            </div>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                            <div class="row g-0">
                                <div class="col-md-3">
                                    <img src="${pageContext.request.contextPath}/images/${fn:toLowerCase(product.type)}/${product.name}.jpg"
                                         class="img-fluid rounded-start w-100 p-3"
                                         alt="${product.name}">
                                </div>
                                <div class="col-md-9">
                                    <div class="card-body">
                                        <h5 class="card-title text-center">${product.name}</h5>
                                        <p class="card-text font-italic p-1">${product.info}.</p>
                                    </div>
                                </div>
                            </div>
                            <div class="container text-center m-0 p-0">
                                <div class="row">
                                    <div class="col-sm-12 fst-italic">
                                        <p>${product.price}$</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
</body>
</html>