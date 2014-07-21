<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<section id="register-form">
    <h4>Register New Client Account</h4>
    <form action="register" method="post">
        <table>
            <s:textfield name="userName" label="User Name"></s:textfield>
            <s:textfield name="name" label="Full Name"></s:textfield>
            <s:textfield name="email" label="Email Address"></s:textfield>
            <s:submit value="Register"></s:submit>
        </table>
    </form>
</section>
