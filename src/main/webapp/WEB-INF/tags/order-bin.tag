<%@tag description="search-panel" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="orderBin" required="true" type="com.comfortdelivery.model.OrderBin"%>
  <div class="order-bin">
        <div class="order-bin-title">Ваш заказ</div>
        <div class="order-bin-items">
            <c:forEach var="item" items="${orderBin.products}">
            <div class="order-bin-item">
            <span>
                <img src="${pageContext.request.contextPath}/resources/images/sample.jpg" alt="item" width="40" height="40">
            </span>
                    <span class="order-bin-item-title">${item.productName}</span>
                    <input type="number" name="quantity" min="1" max="99" value="1"/>
                    <span class="order-bin-item-price">${item.price}</span>
            </div>
            </c:forEach>
        </div>
        <div class="submit-order">
            <input class="submit-order-button" type="submit"/>
        </div>
    </div>