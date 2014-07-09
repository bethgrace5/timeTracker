<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
    <title>Successful</title>
</head>
<body>
    success. Hello, <s:property value="name"/> <br/>
    password: <s:property value="password"/> <br/>
    Id: <s:property value="id"/>

    <s:form action="deactivate">
    <s:hidden name="id"/>
    <s:submit value="Deactivate Account"></s:submit>
    </s:form>
</body>
</html>
