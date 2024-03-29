<%@ page contentType="text/html;charset=UTF-8" %>
<head>
    <title>Open Form</title>
    <link rel="stylesheet" href="css/index.css">
</head>
<div>
    <a id="calc" class="button blue" href="${pageContext.request.contextPath}/calculator.jsp">
        <i class="fa fa-calculator" aria-hidden="true"></i>
        <span>Калькулятор курильщика</span>
    </a>
</div>
<div>
    <a id="calcNew" class="button orange" href="${pageContext.request.contextPath}/calculator-new-view.jsp">
        <i class="fa fa-calculator" aria-hidden="true"></i>
        <span>Калькулятор здорового человека</span>
    </a>
</div>
<div>
    <a id="DB" class="button purple" href="${pageContext.request.contextPath}/students">
        <i class="fa fa-address-book" aria-hidden="true"></i>
        <span>Работа с БД</span>
    </a>
</div>