<%@tag description="search-panel" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="${pageContext.request.contextPath}/resources/js/order-bin-actions.js"></script>
<div id = "order-bin" class="order-bin">
    <div class="order-bin-title">Ваш заказ</div>
    <div class="order-bin-items">
        <c:forEach var="item" items="${sessionScope['scopedTarget.orderBin'].products}" varStatus="current">
            <div class="order-bin-item">
                <c:url var="delete" value="/deleteFromBin">
                    <c:param name="id" value="${item.key.productId}"/>
                </c:url>
                <c:url var="decreaseAmount" value="/decreaseAmount">
                    <c:param name="id" value="${item.key.productId}"/>
                </c:url>
                <c:url var="increaseAmount" value="/addToBin">
                    <c:param name="id" value="${item.key.productId}"/>
                </c:url>
                <span>
                <img src="${pageContext.request.contextPath}/resources/images/sample.jpg" alt="item" width="40"
                     height="40">
            </span>
                <span class="order-bin-item-title">${item.key.productName}</span>
                <div class="bin-controls">
                    <a class="decreaseLink" href="${decreaseAmount}">
                        <input type="button" class="control-button" value="-"/>
                    </a>
                    <span class="quantity">${item.value}</span>
                    <a class="increaseLink" href="${increaseAmount}">
                        <input type="button" class="control-button" value="+"/>
                    </a>
                </div>
                <span class="order-bin-item-price">${item.key.price}</span>
                <span class="remove-item-from-bin">
                    <a class="delete-link" href=${delete}>
                        <i class="fa fa-times" aria-hidden="true"></i>
                    </a>
                </span>
            </div>
        </c:forEach>
    </div>
    <div id="total" class="order-bin-total">
        ${sessionScope['scopedTarget.orderBin'].total}
    </div>
    <div class="submit-order">
        <input class="submit-order-button" type="submit"/>
    </div>
</div>