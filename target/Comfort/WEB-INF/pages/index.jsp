<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Уют - доставка в п.Октябрьский и д.Чунояр</title>
</head>
<t:generic-page>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
        А ты мне скажешь - я так ждала тебя вова
    </jsp:attribute>
    <jsp:body>
        <t:search-and-order/>
        <form:form method="GET">
            <c:forEach var="category" items="${categories}">
                <c:out value="${category.title}"/>
                <c:forEach var="subcategory" items="${category.subcategories}">
                    <c:out value="${subcategory.subcategoryName}"/>
                </c:forEach>
            </c:forEach>
        </form:form>
    </jsp:body>
</t:generic-page>
</html>
