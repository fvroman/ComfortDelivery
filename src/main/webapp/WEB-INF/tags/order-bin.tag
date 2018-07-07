<%@tag description="search-panel" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<form method="get" class="submit-order-form" action="${pageContext.request.contextPath}/order">
<div id = "order-bin" class="order-bin">
    <div class="order-bin-title">Ваш заказ</div>
   <t:order-bin-products/>
    <div class="submit-order">
        <input class="submit-order-button" value="Оформить заказ" type="submit"/>
    </div>
</div>
</form>