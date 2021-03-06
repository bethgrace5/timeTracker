<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<section id="register-form">
    <h4>Register New Client Account</h4>
    <form action="registerClient" method="post">
        <table>
            <s:textfield name="userName" label="User Name"></s:textfield>
            <s:textfield name="name" label="Full Name"></s:textfield>
            <s:textfield name="email" label="Email Address"></s:textfield>
            <s:submit value="Register"></s:submit>
            <a href="javascript:window.history.back()">Back</a>
        </table>
    </form>
    
    <s:form action="getSelectedClient">
        <s:select label="select client to update"
        headerKey="-1" headerValue="Select Client"
        list="clients"
        name="selectedClient"/>
    <s:submit value="submit" name="submit"/>
    </s:form>
</section>
