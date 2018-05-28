<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="search-panel" pageEncoding="UTF-8"%>
<!--todo едет в рефактор когда буду делать поиск и автокомплит-->
<div class="default-search-panel">
    <div class="search-with-button-and-select">
        <button type="reset" class="category-selector">
            <i class="fa fa-times"></i> Категории
        </button>
        <input type="text" title="hello" class="search-form" placeholder="Что ищем?" class="search-form"/>
        <input type="submit" value="Искать" class="submit-search-button"/>
    </div>
</div>