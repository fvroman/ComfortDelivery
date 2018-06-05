<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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