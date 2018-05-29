<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<link type="text/css" rel = "stylesheet" href="${pageContext.request.contextPath}/resources/css/product-list.css">
<html>
<head>
    <title>Товары</title>
</head>
<t:generic-page>
<jsp:body>
<t:search-and-order/>
    <form:form method="get" modelAttribute="products">
        <h3>${subcategoryName}</h3>
        <div class="filters-common">
            <div class="price-filter">
                <h4>Цена</h4>
                От
                <input type="number">
                До
                <input type="number">
            </div>
            <hr>
            <div class="brand-filter">
                <h4>Производители</h4>
                <c:forEach begin="1" end="4">
                   <label><input type="checkbox">Samsung</label>
                </c:forEach>
            </div>
        </div>
        <c:forEach var="product" items="${products}">
            <c:out value="${product.productName} ${product.price} ${product.subcategory}"/>
            <br>
        </c:forEach>
    </form:form>
</jsp:body>
</t:generic-page>
</html>