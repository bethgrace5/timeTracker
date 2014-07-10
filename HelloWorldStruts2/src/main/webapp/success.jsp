<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
    <title>Successful</title>
</head>
<body>
    Successfully created account for: <s:property value="name"/> <br/>

    <s:form action="deactivate">
    <s:hidden name="id"/>
    <s:submit value="Deactivate Account"></s:submit>
    </s:form>
</body>
</html>
