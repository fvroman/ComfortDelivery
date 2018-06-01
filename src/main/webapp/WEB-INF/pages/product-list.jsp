<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/product-list.css">
<html>
<head>
    <title>Товары</title>
</head>
<t:generic-page>
    <jsp:body>
        <t:search-and-order/>
        <form:form method="get">
            <c:forEach items="${sessionScope}" var="entry">
                ${entry.key} = ${entry.value}<br>
            </c:forEach>
            <c:out value="${sessionScope['scopedTarget.orderBin'].products} FUdsUFUFUF"/>
            <h3>${subcategoryName}</h3>
            <div class="filters-common">
                <div class="price-filter">
                    <h4>Цена</h4>
                    От
                    <input type="number" value="${minPrice}" min="0">
                    До
                    <input type="number" value="${maxPrice}" min="0">
                </div>
                <hr>
                <div class="brand-filter">
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
                        <img src="${pageContext.request.contextPath}/resources/images/sample.jpg" alt="тест"
                             width="100" height="180">
                        <div class="product-description">
                            <span class="product-title">${product.productName}</span>
                            <hr>
                            <c:forEach var="feature" items="${product.features}">
                                <span class="product-feature">${feature.title} : ${feature.value}</span>
                            </c:forEach>
                        </div>
                        <span class="product-price">${product.price}</span>
                        <input type="button" class="add-to-bin-button" onclick="location.href = '${addToBin}'"
                               title="Купить">Купить</in>
                    </div>
                </c:forEach>
            </div>
        </form:form>
    </jsp:body>
</t:generic-page>
</html>