<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Time and Mileage Tracker</title>
</head>
<body>
    <h3>Time and Mileage Tracker</h3>
    <h4>Create account:</h4>
    <s:form action="register">
    <s:textfield name="name" label="Username"></s:textfield>
    <s:textfield name="password" label="Password"></s:textfield>
    <s:submit value="Submit"></s:submit>
    </s:form>
    
</body>
</html>
