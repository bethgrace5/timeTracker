<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<section id="time-form">
    <h4>Time Session info </h4>
    <h5>view, update, or add new...</h5>
    <s:form action="startTimeSession" method="post">
         <s:select id="selectedRepository" 
                  label="Repository"
                  name="selectedRepository"
                  list="repositories"
                  headerKey="-1"
                  headerValue="select or add new..." />
        <s:select id="selectedStatus" 
                  label="Status"
                  name="selectedStatus"
                  list="statuses"
                  headerKey="1" />
        <s:select id="selectedMilestone" 
                  label="Milestone"
                  name="selectedMilestone" 
                  list="milestones"
                  headerKey="1" />
        <s:select id="selectedIssue" 
                  label="Issue"
                  name="selectedIssue"
                  list="issues"
                  headerKey="1" />
        <s:textfield id="description" name="description" label="Description"/>
        <s:textfield id="milesDriven" name="milesDriven" label="Miles Driven"/>
        <s:textfield id="hourlyRate" name="hourlyRate" label="Hourly Rate"/>
        <s:textfield id="repositoryName" name="repositoryName" label="Repository Name"/>
        <s:submit value="Start"/>
    </s:form>

</section>

<script type="text/javascript">
   $(document).ready(function(){
        $('#selectedRepository').selectize({
            create: true,
            highlight: true,
            // When a new repository is typed in, it is saved in database
            onOptionAdd: function(value){
                $.ajax({
                    data: {
                        selectedRepository: value,
                    },
                    url: "/addRepository",
                    success: function(result, status, xhr) {
                        //alert(value);
                    },
                });
            },
            //onChange: function(value){
                //$.ajax({
                    //type: "GET",
                    //data: {
                        //selectedRepository: value,
                    //},
                    //url: "/getRepositoryInfo",
                    //dataType: 'json',
                    //success: function(result, status, xhr) {
                        //alert(result);
                        //var obj = JSON.parse(result);
                        //alert(obj);
                        //$("#repositoryName").val(obj.full_name)
                    //},
                //});
            //},

        });
        $('#selectedMilestone').selectize({
            create: false,
            highlight: true,
        });
        $('#selectedIssue').selectize({
            create: false,
            highlight: true,
        });
        $('#selectedStatus').selectize({
            create: false,
            highlight: true,
            onChange: function(value){
                $.ajax({
                    data: {
                        selectedRepository: $("#selectedRepository").val(),
                        selectedStatus: value,
                    },
                    url: "/updateStatus",
                    success: function(result, status, xhr) {
                    },
                });
            },
        });

       //$( "#selectedRepository" ).change(function() {
            // alert, jquery with this(the element calling the event, in
            // this case, selectClient), get the value.

            // get result as string.
            //$.ajax({
                //type: "GET",
                //data: {
                    //selectedRepository: $("#selectedRepository").val(),
                //},
                //url: "/getRepositoryInfo",
                //dataType: 'json',
                //success : function(result,status,xhr){
                   // parse string as json object.
                   //alert(result);
                   //var obj = JSON.parse(result);
                   //$("#repositoryName").val(obj.full_name)
               //}
           //});

           // use jquery's $.ajaxSetup and $.ajax to talk to the server
       //});

   });
</script>
