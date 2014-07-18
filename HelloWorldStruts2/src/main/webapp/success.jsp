<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
    <title>Successful</title>
</head>
<body>
    Successfully created account for: <s:property value="userName"/> <br/>

    <s:form action="deactivate">
        <s:submit value="Deactivate Account"></s:submit>
    </s:form>
    <s:form action="createTeam">
    <s:textfield name="teamName" label="Team Name"></s:textfield>
        <s:submit value="Create Team"></s:submit>
    </s:form>

    <%-- TODO: get the team that is selected from the action --%>
    <s:action name="listTeams" var="selectedTeam" executeResult="true"/>
    <s:form action="joinTeam">
        <s:submit value="Join Selected Team"/>
        <s:property value="selectedTeam.teamName"/>
    </s:form>

</body>
</html>
