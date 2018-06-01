<%@tag description="search-panel" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <div class="order-bin">
        <div class="order-bin-title">Ваш заказ</div>
        <div class="order-bin-items">
            <c:forEach var="item" items="${sessionScope['scopedTarget.orderBin'].products}" varStatus="current">
            <div class="order-bin-item">
                <c:url var="delete" value="/deleteFromBin">
                    <c:param name="id" value="${current.index}"/>
                </c:url>
            <span>
                <img src="${pageContext.request.contextPath}/resources/images/sample.jpg" alt="item" width="40" height="40">
            </span>
                    <span class="order-bin-item-title">${item.productName}</span>
                    <input type="number" name="quantity" min="1" max="99" value="1"/>
                    <span class="order-bin-item-price">${item.price}</span>
                    <input type="button" onclick="window.location.href = '${delete}';" value="fic"/>
            </div>
            </c:forEach>
        </div>
        <div class="submit-order">
            <input class="submit-order-button" type="submit"/>
        </div>
    </div>