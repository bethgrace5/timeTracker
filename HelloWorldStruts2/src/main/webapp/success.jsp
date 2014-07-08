<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
    <title>Successful</title>
</head>
<body>
    success. Hello, <s:property value="name"/>
    password: <s:property value="password"/>

    <s:form action="deactivate">
    <s:submit value="Deactivate Account"></s:submit>
    </s:form>
</body>
</html>
