<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <link type="text/css" rel = "stylesheet" href="${pageContext.request.contextPath}/resources/css/order-confirmation.css">
    <title>Оформить заказ</title>
</head>
<t:generic-page>
    <jsp:body>
        <t:search/>
        <form:form class = "order-details" modelAttribute="customer" action="confirmOrder" method="post">
        <span class="confirm-header">Оформление Заказа</span>
            <t:order-bin-products/>
            <div class="user-details">
                <span class="details-header">Контактные данные</span>
                <div class="customer-name">
                    <span class="detail">Ф.И.О</span>
                    <form:input path="fullName" type="text" class="detail-input"/>
                </div>
                <div class="customer-town">
                    <span class="detail">Населенный пункт</span>
                    <form:select path="village" class="detail">
                        <form:options items="${villages}"/>
                    </form:select>
                </div>
                <div class="customer-address">
                    <span class="detail">Адрес доставки</span>
                    <form:input path="address" type="text" class="detail-input"/>
                </div>
                <div class="customer-phone">
                    <span class="detail">Телефон</span>
                    <form:input path="phoneNumber" type="text" class="detail-input"/>
                </div>
                <div class="payment-method">
                    <span class="detail">Способ оплаты</span>
                    <select class="detail"></select>
                </div>
            </div>
            <input class = "confirm-order-button" value="Оформить" type="submit">
        </form:form>
    </jsp:body>
</t:generic-page>
</html>