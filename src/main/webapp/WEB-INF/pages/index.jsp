<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Уют - доставка в п.Октябрьский и д.Чунояр</title>
    <meta name="yandex-verification" content="360ead2595e2a06a" />
</head>
<t:generic-page>
    <jsp:body>
        <t:search-and-order/>
        <form:form method="GET">
            <table>
                <c:forEach var="category" items="${categories}" varStatus="loop">
                    <!--shiet looping in the house, надеюсь временно. неужели нет варианта как в jsf?-->
                    <c:if test="${loop.index % 2 == 0}">
                        <tr>
                    </c:if>
                    <td>
                        <div class="category-menu-item">
                            <c:url var="categoryUrl"
                                   value="${pageContext.request.contextPath}/${category.categoryName}">
                            </c:url>
                            <img src="../static/${category.imageLink}" alt="тест"
                                 width="120" height="120">
                            <div class="category-list">
                                <a href=${categoryUrl}>
                                    <h4>${category.categoryName}</h4>
                                </a>
                                <hr>
                                <c:forEach var="subcategory" items="${category.subcategories}">
                                    <c:url var="subcategoryUrl" value="${categoryUrl}/${subcategory.subcategoryName}"/>
                                    <span class="subcategory-title">
                                        <a href="${subcategoryUrl}">
                                            <c:out value="${subcategory.subcategoryName}"/>
                                        </a>
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
