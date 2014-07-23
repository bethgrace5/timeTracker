<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<section id="register-form">
    <h4>Update Existing Client Account</h4>
    <s:form action="getSelectedClient">

        <s:select label="Select" headerKey="-1" headerValue="Select Client"
        list="clients" name="selectedClient"/>

        <s:submit value="submit" name="submit"/>
    </s:form>
</section>
