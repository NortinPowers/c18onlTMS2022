<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Calculator</title>
    <link rel="stylesheet" href="css/inputForm.css">
</head>
<body>
<div class="form-box">
    <form action="calculator-result" method="post">
        <div class="value-box">
            <p> Value: </p>
            <input type="number" step="any" name="value1">
        </div>
        <div class="value-box">
            <p> Value: </p>
            <input type="number" step="any" name="value2">
        </div>
        <br>
        <br>
        <form>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <input type="submit" value="Addition" name="addition"/>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="submit" value="Subtraction" name="subtraction"/>
            <br>
            <br>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <input type="submit" value="Multiplication" name="multiplication"/>
            &nbsp;&nbsp;
            <input type="submit" value="Division" name="division"/>
        </form>
    </form>
</div>
</body>
</html>