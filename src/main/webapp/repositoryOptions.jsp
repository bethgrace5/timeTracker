<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<section>
    <s:form action="addRepository" method="post">
        <s:select name="selectedRepository" 
                  id="repositoryNames" 
                  label="Select" 
                  list="repositories"
                  headerKey="-1" 
                  headerValue="Select Repository" />
    </s:form>

</section>


<script type="text/javascript">
   $(document).ready(function(){
        $('#repositoryNames').selectize({
            create: true,
            createOnBlur: true,
            highlight: true,
        });
       $( "#repositoryNames" ).change(function() {
            $.ajax({
                //url: get action for listing repositories
                type: "GET",
                data: {
                    selectedRepository: $("#repositoryNames").val(),
                },
                success : function(result,status,xhr){
                    $("#userName").val( $("#repositoryNames").val())
                   //alert(result);
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
