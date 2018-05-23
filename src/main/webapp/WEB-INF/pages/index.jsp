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
        <t:search/>
        <form:form method="GET">
            <table>
                <c:forEach var="category" items="${categories}" varStatus="loop">
                    <!--shiet looping in the house, надеюсь временно. неужели нет варианта как в jsf?-->
                    <c:if test="${loop.index % 2 == 0}">
                        <tr>
                    </c:if>
                    <td>
                        <div class="category-menu-item">
                            <img src="${pageContext.request.contextPath}/resources/images/sample.jpg" alt="тест"
                                 width="100" height="180">
                            <div class="category-list">
                                <h4>${category.title}</h4>
                                <hr>
                                <c:forEach var="subcategory" items="${category.subcategories}">
                                <span>
                                    <c:out value="${subcategory.subcategoryName}"/>
                                </span>
                                    <br>
                                </c:forEach>
                            </div>
                            </div>
                    </td>
                    <c:if test="${loop.index % 2 != 0}">
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </form:form>
    </jsp:body>
</t:generic-page>
</html>
