<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<section id="register-form">
    <h4>Create Account</h4>
    <form action="register">
        <table>
            <s:textfield name="name" label="Name"></s:textfield>
            <s:textfield name="email" label="Email"></s:textfield>
            <s:textfield name="userName" label="Username"></s:textfield>
            <s:select label="Choose Type"
                list="#{'contractor':'Contractor', 'client':'Client'}"
                name="type"/>
            <s:textfield name="password" label="Password"></s:textfield>
            <s:submit value="Register"></s:submit>
        </table>
    </form>
</section>
