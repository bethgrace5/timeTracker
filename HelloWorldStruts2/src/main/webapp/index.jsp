<!--Java Server Pages: uses HTML with server-side code. JSP provides an interface to dynamically invoke server action -->

<!-- server actions -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!-- HTML display -->
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Hello World</title>
</head>
<body>
   <h1>Hello World From Struts2</h1>

<!-- this action maps to execute method in LoginAction class
 using struts.xml file-->
   <form action="login" method="post">
        User: <br/><input type = "text" name="user"/><br/>
        Password: <br/><input type = "password" name="password"/><br/>
      <input type="submit" value="login"/>
   </form>
</body>
</html>
