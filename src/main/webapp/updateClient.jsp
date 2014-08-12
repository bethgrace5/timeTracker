<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<section id="register-form">
    <h4>Update Existing Client Account</h4>
    <s:form action="setClientInfo" method="post">
        <s:select name="selectedClient" 
                  id="selectClient" 
                  label="Select" 
                  list="clients"
                  headerKey="-1" 
                  headerValue="Select Client" />

        <s:textfield id="userName" name="userName" label="User Name"></s:textfield>
        <s:textfield id="name" name="name" label="Name" ></s:textfield>
        <s:textfield id="email" name="email" label="Email" ></s:textfield>
        <s:checkbox id="deactivated" name="deactivated" label="Deactivated"/>
        <s:submit value="Submit Changes"></s:submit>
    </s:form>
    <a href="javascript:window.history.back()">Back</a>
</section>

<script type="text/javascript">
   // jquery, with my document, when the ready event is fired, call 
   // this anonymous function.
   $(document).ready(function(){
       // jquery, with element identified by the id "selectClient",
       // when the change event is fired, call this anonymous function.
       $( "#selectClient" ).change(function() {
            // alert, jquery with this(the element calling the event, in
            // this case, selectClient), get the value.

            // get result as string.
            $.ajax({
                type: "GET",
                data: {
                    selectedClient: $("#selectClient").val(),
                },
                url: "/getClientInfo",
                dataType: 'json',
                success : function(result,status,xhr){
                   // parse string as json object.
                   var obj = JSON.parse(result);
                   $("#userName").val(obj.userName)
                   $("#name").val(obj.name)
                   $("#email").val(obj.email)
                   $("#deactivated").prop("checked", (obj.deactivated))
               }
           });

           // use jquery's $.ajaxSetup and $.ajax to talk to the server
       });
   });

   $
</script>
