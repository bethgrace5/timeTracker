<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<section>
    <s:form action="startTimeSession" method="post">
        <s:textfield id="description" name="description" label="Description"/>
        <s:textfield id="miles" name="milesDriven" label="Miles Driven"/>
        <s:textfield id="rate" name="hourlyRate" label="Hourly Rate"/>
        <s:textfield id="repo" name="selectedRepository" label="selectedRepository"/>
        <%-- <s:select id="selectRepository" 
                  name="selectedRepository"
                  list="repositories"
                  headerKey="1" />
        <s:select id="selectMilestone" 
                  name="selectedMilestone" 
                  list="milestones"
                  headerKey="1" />
        <s:select id="selectIssue" 
                  name="selectedIssue"
                  list="issues"
                  headerKey="1" />
                  --%>
        <s:submit value="Start"/>
    </s:form>

</section>

<script type="text/javascript">
   $(document).ready(function(){
        $('#select').selectize({
            create: true,
            createOnBlur: true,
            highlight: true,
        });

   });
</script>
