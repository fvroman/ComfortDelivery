<%@tag description="Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<html>
<link type="text/css" rel = "stylesheet" href="${pageContext.request.contextPath}/resources/css/generic-page.css">
<body>
<div id="pageheader">
    <!--TODO Это подлежит рефакторингу, когда сделаю соотв.класс-->
    <div style="position:relative">
        <img src="${pageContext.request.contextPath}/resources/images/comfort-header.jpg" alt = "Уют" width="auto">
        <ul>
            <li>Главная</li>
            <li>Доставка и оплата</li>
            <li>Контакты</li>
            <li>Регистрация/Вход</li>
        </ul>
    </div>
</div>
<div id="body">
    <jsp:doBody/>
</div>
<div id="pagefooter">
    <jsp:invoke fragment="footer"/>
</div>
</body>
</html>