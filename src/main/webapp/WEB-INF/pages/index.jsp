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
    <jsp:body>
        <t:search-and-order/>
        <form:form method="GET" modelAttribute="cat">
            <table>
                <c:forEach var="category" items="${categories}" varStatus="loop">
                    <!--shiet looping in the house, надеюсь временно. неужели нет варианта как в jsf?-->
                    <c:if test="${loop.index % 2 == 0}">
                        <tr>
                    </c:if>
                    <td>
                        <div class="category-menu-item">
                            <c:url var="categoryLink" value="getRequestPage">
                                <c:param name="categoryPath" value="${category.title}"/>
                            </c:url>
                            <img src="${pageContext.request.contextPath}/resources/images/sample.jpg" alt="тест"
                                 width="100" height="180">
                            <div class="category-list">
                                <a href="${pageContext.request.contextPath}/${category.title}/">
                                    <h4>${category.title}</h4>
                                </a>
                                <hr>
                                <c:forEach var="subcategory" items="${category.subcategories}">
                                <span class="subcategory-title">
                                    <a href="${pageContext.request.contextPath}/${category.title}/${subcategory.subcategoryName}">
                                            ${subcategory.subcategoryName}</a>
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
