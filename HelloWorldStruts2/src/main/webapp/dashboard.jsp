<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<section>
    <h4>Dashboard</h4>
    <s:if test="%{#context['struts.actionMapping'].name=='register'}">
        <h5>Successfully registered</h5>
    </s:if>
    <s:elseif test="%{#context['struts.actionMapping'].name=='login'}">
        <h5>Successfully logged in</h5>
    </s:elseif>

    <s:form action="deactivate">
        <s:submit value="Deactivate Account"></s:submit>
    </s:form>

    <s:form action="createTeam">
        <s:textfield name="teamName" label="Team Name"></s:textfield>
        <s:submit value="Create Team"></s:submit>
    </s:form>

    <p>List of Teams</p>
    <s:form action="ListTeamsAction">
        <s:submit value="List teams"></s:submit>
    </s:form>
</section>
