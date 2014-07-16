
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
    <title>Iterator</title>
</head>
<body>
    <p> List of Teams </p>

    <s:select list="teams" name="team">
        <s:iterator value="teams">
        </s:iterator>
    </s:select>

</body>
</html>
