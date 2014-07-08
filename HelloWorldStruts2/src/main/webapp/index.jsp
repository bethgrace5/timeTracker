<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Hello World</title>
</head>
<body>
    <h3>Hello World From Struts2</h3>
    <s:form action="register">
    <s:textfield name="name" label="Name"></s:textfield>
    <s:textfield name="password" label="Password"></s:textfield>
    <s:submit value="Create Account"></s:submit>
    </s:form>
    
</body>
</html>
