<%@tag description="Page template" pageEncoding="UTF-8"%>
<html>
<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Ubuntu:regular,bold&subset=Latin">
<link type="text/css" rel = "stylesheet" href="${pageContext.request.contextPath}/resources/css/generic-page.css">
<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
<body>
<div id="pageheader">
    <!--TODO Это подлежит рефакторингу, когда сделаю соотв.класс-->
    <div id = "navigation" style="position:relative">
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
</body>
</html>