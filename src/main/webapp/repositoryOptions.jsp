<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<section>
    <h4>Repository Options</h4>
    <s:form action="addRepository" method="post">
        <s:textfield id="githubUrl" name="githubUrl" label="New Repository github URL" ></s:textfield>
        <s:submit value="Add"></s:submit>
    </s:form>
    <s:form action="" method="post">
        <s:select name="selectedRepository" 
                  id="repositoryNames" 
                  label="Select" 
                  list="repositoryNames"
                  headerKey="-1" 
                  headerValue="Select Repository" />
    </s:form>

<script type="text/javascript">
   $(document).ready(function(){
       $( "#repositoryNames" ).change(function() {
            $.ajax({
                type: "GET",
                data: {
                    selectedRepository: $("#repositoryNames").val(),
                },
                dataType: 'json',
                success : function(result,status,xhr){
                    alert(result);
                   // parse string as json object.
                   //var obj = JSON.parse(result);
                   //$("#userName").val(obj.userName)
                   //$("#name").val(obj.name)
                   //$("#email").val(obj.email)
                   //$("#deactivated").prop("checked", (obj.deactivated))
               }
           });
       });
   });
   $
</script>
