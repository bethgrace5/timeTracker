<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
    <title>Created Team</title>
</head>
<body>
    <s:property value="currentUser"/>
    Successfully Created team: <s:property value="teamName"/>
    <br/>
    <a href="/">Back to home</a><br/>
    <a href="/dbconsole">dbconsole</a>
</body>
</html>
