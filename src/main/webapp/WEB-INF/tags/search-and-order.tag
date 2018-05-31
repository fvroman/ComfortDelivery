<%@tag description="search-panel" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@attribute name="orderBin" required="true" type="com.comfortdelivery.model.OrderBin"%>
<div style="position:relative">
    <t:search/>
    <t:order-bin orderBin="${orderBin}"/>
</div>