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
</head>
<body>
<jsp:include page="/view/navigate.jsp"/>
<div class="container text-center mt-3 w-100 p-0">
    <div class="row">
        <div class="col">
            <div class="container-fluid">
                <form class="d-flex" role="search">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="container mt-3 min-vw-100 p-0">
    <div class="row grid gap-3">
        <div class="col-5">
            <div class="row ml-3 mr-1">
                <div class="col-12 border border-secondary rounded rounded-5 shadow p-3 mb-5 bg-body-tertiary rounded">
                    <h3 class="text-start ml-5">Filter:</h3>
                    <div class="row text-center">
                        <div class="col-sm-12">
                            <select class="form-select col-8 col-sm-12 p-2 text-center" aria-label="Default select example">
                                <option selected>Categories</option>
                                <option value="1">TV</option>
                                <option value="2">Phone</option>
                            </select>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col">
                            <div class="form-outline">
                                <input type="text" id="MinPrice" class="form-control form-control-lg text-center" placeholder="MinPrice"/>
                            </div>
                        </div>
                        <div class="col">
                            <div class="form-outline">
                                <input type="text" id="MaxPrice" class="form-control form-control-lg text-center" placeholder="MaxPrice"/>
                            </div>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-6"></div>
                        <div class="col-6 col-sm-6">
                            <div>
                                <input class="col-sm-12 btn btn-info" type="submit" value="Action"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-7 border border-secondary rounded rounded-5 shadow p-3 mb-5 bg-body-tertiary rounded">
            <div class="card mb-3 border border-secondary rounded rounded-5 shadow-sm p-2 bg-body-tertiary rounded mr-2">
                <div class="container text-center mb-2">
                    <div class="row">
                        <div class="col-sm-4 btn btn-success">
                            <a href="#" class="text-light text-decoration-none" aria-current="page">
                                To product
                            </a>
                        </div>
                        <div class="col-sm-4 btn btn-success">
                            <a href="<c:url value="/eshop?command=add-cart&id=${product.id}&shop=true&location=none"/>" class="text-light text-decoration-none" aria-current="page">
                                Buy
                            </a>
                        </div>
                        <div class="col-sm-2 btn btn-success">
                            <a href="<c:url value="/eshop?command=add-cart&id=${product.id}&shop=none&location=none"/>">
                                <div class="text-center text-light text-decoration-none">
                                    <i class="bi bi-cart-plus"></i>
                                </div>
                            </a>
                        </div>
                        <div class="col-sm-2 btn btn-success">
                            <a href="<c:url value="/eshop?command=add-favorite&id=${product.id}&shop=none&location=none"/>">
                                <div class="text-center text-light text-decoration-none">
                                    <i class="bi bi-heart"></i>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="row g-0">
                    <div class="col-md-3">
                        <img src="<c:url value="/img/phone.jpg"/>" class="img-fluid rounded-start w-100 p-3" alt="---IMG_NAME---">
                    </div>
                    <div class="col-md-9">
                        <div class="card-body">
                            <h5 class="card-title text-center">---PROD_NAME---</h5>
                            <p class="card-text p-1">---PROD_INFO---</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>