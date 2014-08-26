<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<section>
    <s:form action="startTimeSession" method="post">
         <s:select id="selectedRepository" 
                  label="Select"
                  name="selectedRepository"
                  list="repositories"
                  headerKey="1" />
        <s:textfield id="description" name="description" label="Description"/>
        <s:textfield id="milesDriven" name="milesDriven" label="Miles Driven"/>
        <s:textfield id="hourlyRate" name="hourlyRate" label="Hourly Rate"/>
        <s:select id="selectedMilestone" 
                  name="selectedMilestone" 
                  list="milestones"
                  headerKey="1" />
        <s:select id="selectedIssue" 
                  name="selectedIssue"
                  list="issues"
                  headerKey="1" />
        <s:submit value="Start"/>
    </s:form>

</section>

<script type="text/javascript">
   $(document).ready(function(){
        $('#selectedRepository').selectize({
            create: true,
            openOnFocus: true,
            highlight: true,
        });
        $('#selectedMilestone').selectize({
            create: false,
            highlight: true,
        });
        $('#selectedIssue').selectize({
            create: false,
            highlight: true,
        });

   });
</script>
