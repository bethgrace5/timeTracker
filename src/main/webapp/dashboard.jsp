<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<section>
    <h4>Dashboard</h4>
    <%-- <s:if test="%{#context['struts.actionMapping'].name=='register'}">
        <h5>Successfully registered as <s:property value="%{#parameters.userName}"/></h5>
    </s:if>
    <s:elseif test="%{#context['struts.actionMapping'].name=='login'}">
        <h5>Successfully logged in as <s:property value="%{#parameters.userName}"/></h5>
    </s:elseif> --%>
        <h5> generic dashboard </h5>
        <h4> selected client </h4>
        <s:property value="selectedClient"/>

</section>
