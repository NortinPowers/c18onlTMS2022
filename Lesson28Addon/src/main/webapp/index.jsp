<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Start Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body style="background: linear-gradient(#c1c2c4, #90909a)">
<ul class="nav justify-content-end text-white bg-dark mb-5 text-center">
    <li class="nav-item">
        <p class="mr-5 mt-3">Number of visits: ${sessionScope.numberOfVisits}</p>
    </li>
</ul>
<div class="row text-center mt-5 ml-5 mr-5">
    <div class="col-sm">
        <div class="card border border-dark shadow p-0 mb-5 bg-white rounded"
             style="background: linear-gradient(#c1b9c4, #b9becb)">
            <div class="card-body">
                <h5 class="card-title">Current time</h5>
                <p class="card-text">Using the "refresh" method</p>
                <a class="btn btn-outline-dark btn-lg btn-block" href="<c:url value="/time"/>">Time</a>
            </div>
        </div>
    </div>
    <div class="col-sm">
        <div class="card border border-dark shadow p-0 mb-5 bg-white rounded"
             style="background: linear-gradient(#c1b9c4, #b9becb)">
            <div class="card-body">
                <h5 class="card-title">Current time</h5>
                <p class="card-text">Using the javascript realization</p>
                <a class="btn btn-outline-dark btn-lg btn-block" href="<c:url value="/timeJs.jsp"/>">Time</a>
            </div>
        </div>
    </div>
</div>
<div class="row text-center mt-5 ml-5 mr-5">
    <div class="col-sm">
        <div class="card border border-dark shadow p-0 mb-5 bg-white rounded"
             style="background: linear-gradient(#c1b9c4, #b9becb)">
            <div class="card-body">
                <h5 class="card-title">Day of week</h5>
                <p class="card-text">Get the day of the week by date</p>
                <form class="mb-0" action="<c:url value="/day-of-week"/>" method="get">
                    <div>
                        <label class="font-italic"> Select the date:
                            <input class="bg-secondary text-white" type="date" name="date" required="">
                        </label>
                    </div>
                    <div>
                        <input class="btn btn-outline-dark btn-lg btn-block mt-3" type="submit" name="Check date"
                               value="Receive">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="col-sm">
        <div class="card border border-dark shadow p-0 mb-5 bg-white rounded"
             style="background: linear-gradient(#c1b9c4, #b9becb)">
            <div class="card-body">
                <h5 class="card-title">Day of year</h5>
                <p class="card-text">Get the day of the year by date</p>
                <form class="mb-0" action="<c:url value="/day-of-year"/>" method="post">
                    <div>
                        <label class="font-italic"> Select the date:
                            <input class="bg-secondary text-white" type="date" name="date" required="">
                        </label>
                    </div>
                    <div>
                        <input class="btn btn-outline-dark btn-lg btn-block mt-3" type="submit" name="Check date"
                               value="Receive">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>