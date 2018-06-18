<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@tag description="Page template" pageEncoding="UTF-8"%>
<html>
<head>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Ubuntu:regular,bold&subset=Latin">
    <link type="text/css" rel = "stylesheet" href="${pageContext.request.contextPath}/resources/css/generic-page.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"
            integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU="
            crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/resources/js/autocomplete.js"></script>
</head>
<body>
<c:url value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, '')}" var="baseUrl"/>
<div id="pageheader">
    <!--TODO Это подлежит рефакторингу, когда сделаю соотв.класс-->
    <div id = "navigation" style="position:relative">
        <img src="${pageContext.request.contextPath}/resources/images/comfort-header.jpg" alt = "Уют" width="auto">
        <ul>
            <a href="${baseUrl}"><li>Главная</li></a>
            <a href="${baseUrl}/delivery"><li>Доставка и оплата</li></a>
            <a href="${baseUrl}/contacts"><li>Контакты</li></a>
            <a href="${baseUrl}/login"><li>Регистрация/Вход</li></a>
        </ul>
    </div>
</div>
<div id="body">
    <jsp:doBody/>
</div>
</body>
</html>