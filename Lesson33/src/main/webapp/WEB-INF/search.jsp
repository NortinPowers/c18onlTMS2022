<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Search</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <%--    <script>--%>
    <%--        const searchButton = document.getElementById('search-button');--%>
    <%--        const searchInput = document.getElementById('search-input');--%>
    <%--        searchButton.addEventListener('click', () => {--%>
    <%--            const inputValue = searchInput.value;--%>
    <%--            alert(inputValue);--%>
    <%--        });--%>
    <%--    </script>--%>
</head>
<body>
<jsp:include page="/view/navigate.jsp"/>

<div class="container gap-3">

    <div class="row border border-secondary rounded rounded-5 shadow p-3 mb-5 bg-body-tertiary rounded p-2 g-col-6">
        <form class="d-flex" role="search">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
        <%--        <div class="col border-dark rounded-3">--%>
        <%--            <div class="input-group">--%>
        <%--                <div class="form-outline">--%>
        <%--                    <input id="search-input" type="search" class="form-control" />--%>
        <%--                    <label class="form-label" for="search-input">Search</label>--%>
        <%--                </div>--%>
        <%--                <button id="search-button" type="button" class="btn btn-primary">--%>
        <%--                    <i class="fas fa-search"></i>--%>
        <%--                </button>--%>
        <%--            </div>--%>
        <%--        </div>--%>
    </div>

    <div class="row border border-secondary rounded rounded-5 shadow p-3 mb-5 bg-body-tertiary rounded p-2 g-col-6">

        <div class="col-5">
            <div class="container">
                <form action="#" method="post">
                    <div class="row">
                        <div class="col">
                            <select class="form-select" aria-label="Default select example">
                                <option selected>Categories</option>
                                <option value="1">TV</option>
                                <option value="2">Phone</option>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="form-outline">
                                <input type="text" id="MinPrice" class="form-control"/>
                                <label class="form-label" for="MinPrice">Min price</label>
                            </div>
                        </div>
                        <div class="col">
                            <div class="form-outline">
                                <input type="text" id="MaxPrice" class="form-control"/>
                                <label class="form-label" for="MaxPrice">Max price</label>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6"></div>
                        <div class="col-6">
                            <div>
                                <input type="submit" value="Action"/>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <div class="col-7">
            <div class="row row-cols-1 row-cols-md-3 g-4 text-center">
                <%--                <c:forEach var="product" items="${ordering.products}">--%>
                <div class="col">
                    <div class="card shadow bg-body-tertiary rounded">
                        <div class="row g-0">
                            <div class="col-md-12">
                                <img class="card-img-top"
                                <%--                                         src="/img/${fn:toLowerCase(product.type)}/${product.name}.jpg"--%>
                                     src="/img/phone.jpg"
                                <%--                                         alt="${product.name}">--%>
                            </div>
                            <div class="col-md-8">
                                <div class="card-body">
                                    <%--                                        <h5 class="card-title">${product.name}</h5>--%>
                                    <h5 class="card-title">Phone</h5>
                                    <%--                                        <p class="card-text">${product.info}</p>--%>
                                    <p class="card-text">info bla-bla fdsfdsfdsfdsf fdfdsf fdsfdsf dfdsfsf fdsfdsf</p>
                                </div>
                            </div>
                            <div class="card-footer">
                                <%--                                    <h5>${product.price}$</h5>--%>
                                <h5>300$</h5>
                            </div>
                        </div>
                    </div>
                </div>
                <%--                </c:forEach>--%>
            </div>
            <%--<!--            <c:forEach var="product" items="${applicationScope.products}">-->--%>
            <!--            <div class="card mb-3" style="max-width: 540px;">-->
            <%--            <div class="card mb-3" style="max-height: 200px;">--%>
            <%--                <div class="row g-0">--%>
            <%--                    <div class="col-md-4">--%>
            <%--<!--&lt;!&ndash;                        class="img-fluid rounded-start"&ndash;&gt; image class-->--%>
            <%--                        <img class="card-img-top" style="max-height: 8rem"--%>
            <%--&lt;%&ndash;                             src="/img/${fn:toLowerCase(product.type)}/${product.name}.jpg"&ndash;%&gt;--%>
            <%--                             src="/img/phone.jpg"--%>
            <%--&lt;%&ndash;                             alt="${product.name}">&ndash;%&gt;--%>
            <%--                    </div>--%>
            <%--                    <div class="col-md-8">--%>
            <%--                        <div class="card-body">--%>
            <%--&lt;%&ndash;                            <h5 class="card-title text-nowrap" style="text-align: -webkit-center">${product.name}</h5>&ndash;%&gt;--%>
            <%--                            <h5 class="card-title text-nowrap" style="text-align: -webkit-center">Phone</h5>--%>
            <%--&lt;%&ndash;                            <p class="card-text font-italic">${product.info}.</p>&ndash;%&gt;--%>
            <%--                            <p class="card-text font-italic">some info</p>--%>
            <%--                        </div>--%>
            <%--                        <div class="card-footer text-center">--%>
            <%--                            <div class="container">--%>
            <%--                                <div class="row">--%>
            <%--                                    <div class="col">--%>
            <%--&lt;%&ndash;                                        <small class="text-muted" style="font-size: 15px">${product.price}$</small>&ndash;%&gt;--%>
            <%--                                        <small class="text-muted" style="font-size: 15px">300$</small>--%>
            <%--                                    </div>--%>
            <%--                                </div>--%>
            <%--                                <div class="row">--%>
            <%--                                    <div class="col">--%>
            <%--                                        <div class="btn-group btn-group-sm">--%>
            <%--                                            <a href="#"--%>
            <%--                                               class="btn btn-success active w-75"--%>
            <%--                                               aria-current="page">To product</a>--%>
            <%--&lt;%&ndash;                                            <a href="<c:url value="/eshop?command=add-cart&id=${product.id}&shop=none&location=none"/>"&ndash;%&gt;--%>
            <%--                                            <a href="#"--%>
            <%--                                            class="btn btn-success">--%>
            <%--                                            <div class="text-center mt-1">--%>
            <%--                                                <i class="bi bi-cart-plus"></i>--%>
            <%--                                            </div>--%>
            <%--                                            </a>--%>
            <%--&lt;%&ndash;                                            <a href="<c:url value="/eshop?command=add-favorite&id=${product.id}&shop=none&location=none"/>"&ndash;%&gt;--%>
            <%--                                            <a href="#"--%>
            <%--                                            class="btn btn-success">--%>
            <%--                                            <div class="text-center mt-1">--%>
            <%--                                                <i class="bi bi-heart"></i>--%>
            <%--                                            </div>--%>
            <%--                                            </a>--%>
            <%--                                        </div>--%>
            <%--                                    </div>--%>
            <%--                                </div>--%>
            <%--                            </div>--%>
            <%--                        </div>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--            </div>--%>
        </div>

    </div>
</div>

</body>
</html>