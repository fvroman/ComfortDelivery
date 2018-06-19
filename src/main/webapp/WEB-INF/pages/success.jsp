<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<head>
    <title>Успех!</title>
</head>
<t:generic-page>
    <t:search/>
    <c:url var="printLink" value="${pageContext.request.contextPath}/generateReport">
        <c:param name="orderId" value="${order.orderId}"/>
    </c:url>
    <div class="success-container">
        <h3>Успешно!</h3>
        <span>
            <h4>Уважаемый ${order.customer.fullName},</h4>
            Ваш заказ оформлен.
            <br>Номер заказа - <span id="order_num" style="font-weight: bold"> ${order.orderId} </span>
            <br>Теперь вы можете
            <a id="printLink" href=${printLink}> распечатать договор </a>
                </span>
    </div>
</t:generic-page>
<script src="${pageContext.request.contextPath}/resources/js/printAgreement.js"></script>
