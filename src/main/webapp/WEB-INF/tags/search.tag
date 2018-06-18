<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@tag description="search-panel" pageEncoding="UTF-8"%>
<form:form action="/searchProducts" method="get">
    <div class="default-search-panel">
    <div class="search-with-button-and-select">
        <button type="reset" class="category-selector">
            <i class="fa fa-times"></i> Категории
        </button>
        <input id="search" type="text" title="hello" name="searchStr"  placeholder="Что ищем?" value="" class="search-form"/>
        <input type="submit" value="Искать" class="submit-search-button"/>
    </div>
</div>
</form:form>