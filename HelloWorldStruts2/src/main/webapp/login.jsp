<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<section id="login-form">
    <h4>Login</h4>
    <form action="login" method="post">
        <table>
            <s:textfield name="userName" label="Username"></s:textfield>
            <s:password name="password" label="Password"></s:password>
            <s:submit value="Login"></s:submit>
        </table>
    </form>
    <div>
        <a href="<s:url action='show-register' />">Register</a>
    </div>
</section>
