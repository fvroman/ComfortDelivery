<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/product-list.css">
<script src="${pageContext.request.contextPath}/resources/js/filters.js"></script>
<html>
<head>
    <title>Товары</title>
</head>
<t:generic-page>
    <jsp:body>
        <t:search-and-order/>
        <form:form method="get">
            <h3>${subcategoryName}</h3>
            <div class="filters-common">
                <div class="price-filter">
                    <h4>Цена</h4>
                    От
                    <input id = "minPrice" type="number" value="${minPrice}" min="0">
                    До
                    <input id = "maxPrice" type="number" value="${maxPrice}" min="0">
                </div>
                <hr>
                <div class="brand-filter" style="display:none">
                    <h4>Производители</h4>
                    <c:forEach begin="1" end="4">
                        <label><input type="checkbox">Samsung</label>
                    </c:forEach>
                </div>
            </div>
            <div class="product-list">
                <c:forEach var="product" items="${products}">
                    <c:url var="addToBin" value="/addToBin">
                        <c:param name="id" value="${product.productId}"/>
                    </c:url>
                    <div class="product-list-item">
                        <img src="../static/${product.imageLink}" alt="тест"
                             width="120" height="120">
                        <div class="product-description">
                            <span class="product-title">${product.productName}</span>
                            <hr>
                            <c:forEach var="feature" items="${product.features}">
                                <span class="product-feature">${feature.title} : ${feature.value}</span>
                            </c:forEach>
                        </div>
                        <span class="product-price">${product.price}</span>
                        <a href="${addToBin}" class="add-to-bin-button">Заказать</a>
                    </div>
                </c:forEach>
                <div class="pagination">
                    <c:forEach begin="1" end="${maxPage}" step="1" varStatus="i">
                        <c:choose>
                            <c:when test="${page == i.index || (page == null && i.index == 1) }">
                                <span class="current-page">${i.index}</span>
                            </c:when>
                            <c:otherwise>
                                <c:url value="${pageContext.request.contextPath}" var="url">
                                    <c:param name="page" value="${i.index}"/>
                                </c:url>
                                <a href="${url}">${i.index}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </div>
            </div>

        </form:form>
    </jsp:body>
</t:generic-page>
</html>