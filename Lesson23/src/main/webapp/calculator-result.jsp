<%@ page import="by.tms.service.Calculator" contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<style>
  p {
    margin: 0;
    text-indent: 1ch;
    color: snow;
    font-size: 1.5em;
    text-shadow: 0 0 white, 1px 1px #D7CC88;
  }

  body {
    margin: 0;
    padding: 0;
    background: linear-gradient(#141e30, #243b55);
  }
</style>
<body>
<p>Addition Result: <%= new Calculator().addition(request.getParameter("value1"), request.getParameter("value2")) %>
</p>
<br>
<p>Subtraction
    Result: <%= new Calculator().subtraction(request.getParameter("value1"), request.getParameter("value2")) %>
</p>
<br>
<p>Multiplication
    Result: <%= new Calculator().multiplication(request.getParameter("value1"), request.getParameter("value2")) %>
</p>
<br>
<p>Division Result: <%= new Calculator().division(request.getParameter("value1"), request.getParameter("value2")) %>
</p>
</body>
</html>