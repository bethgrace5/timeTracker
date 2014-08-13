<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!doctype html>
<html>
    <head>
        <title>
            <%-- filled in by Struts2 Tiles --%>
            <tiles:insertAttribute name="title"/>
        </title>
        <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/selectize.js/0.9.0/css/selectize.default.css" />
        <link rel="stylesheet" type="text/css" href="static/css/main.css" />
        <script type="text/javascript" src="//code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/selectize.js/0.9.0/js/standalone/selectize.min.js"></script>
    </head>
    <body>
        <%-- filled in by Struts2 Tiles --%>
        <tiles:insertAttribute name="body"/>
    </body>
</html>
