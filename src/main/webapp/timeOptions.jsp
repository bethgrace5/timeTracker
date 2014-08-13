<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<section>
    <h4>Time Options</h4>
    <s:form action="beginTime" method="post">
        <s:select name="selectedTimeSession" 
                  id="select" 
                  label="Select" 
                  list="timeSessions"
                  headerKey="-1" 
                  headerValue="Select Time Session" />
        <s:textfield id="repositoryName" name="repositoryName" label="Repository" ></s:textfield>
        <s:textfield id="location" name="location" label="Location" ></s:textfield>
        <s:submit value="Start"></s:submit>
    </s:form>


<script type="text/javascript">
   $(document).ready(function(){
        $('#select').selectize({
            create: true,
            createOnBlur: true,
            highlight: true,
        });

   });
</script>
