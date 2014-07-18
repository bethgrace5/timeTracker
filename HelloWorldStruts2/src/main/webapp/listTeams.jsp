<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<section>
    <s:select list="teams" label="Join Team" name="team">
        <s:iterator value="teams"> </s:iterator>
    </s:select>
</section>
