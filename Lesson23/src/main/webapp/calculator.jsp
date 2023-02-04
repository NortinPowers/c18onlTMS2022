<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<link rel="stylesheet" href="css/inputForm.css">
<div class="form-box">
    <h2>Math operations</h2>
    <form action="calculator-result.jsp">
        <div class="value-box">
            <input type="number" step="any" name="value1" required="">
            <label>Value</label>
        </div>
        <div class="value-box">
            <input type="number" step="any" name="value2" required="">
            <label>Value</label>
        </div>
        <span></span>
        <span></span>
        <div class="button">
            <input type="submit" value="Do operation"/>
        </div>
    </form>
</div>
</body>
</html>