<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<section id="register-form">
    <h4>Client info </h4>
    <h5>view, update, or add new...</h5>
    <s:form action="setClientInfo" method="post">
        <s:select name="selectedClient" 
                  id="selectedClient" 
                  label="Client" 
                  list="clients"
                  headerKey="-1" 
                  headerValue="select or add new..." />

        <s:textfield id="name" name="name" label="Name" ></s:textfield>
        <s:textfield id="clientUserName" name="clientUserName" label="Email" ></s:textfield>
        <s:checkbox id="deactivated" name="deactivated" label="Deactivated"/>
        <s:submit value="Submit Changes" onclick="setSelect()"></s:submit>
    </s:form>
</section>

<script type="text/javascript">
   // jquery, with my document, when the ready event is fired, call 
   // this anonymous function.
   $(document).ready(function(){

        $('#selectedClient').selectize({
            create: true,
            createOnBlur: false,
            highlight: true,

        });


       // jquery, with element identified by the id "selectClient",
       // when the change event is fired, call this anonymous function.
       $( "#selectedClient" ).change(function() {
            // alert, jquery with this(the element calling the event, in
            // this case, selectClient), get the value.

            // get result as string.
            $.ajax({
                type: "GET",
                data: {
                    selectedClient: $("#selectedClient").val(),
                },
                url: "/getClientInfo",
                dataType: 'json',
                success : function(result,status,xhr){
                   // parse string as json object.
                   var obj = JSON.parse(result);
                   $("#selectedClient").val(obj.name)
                   $("#name").val(obj.name)
                   $("#clientUserName").val(obj.userName)
                   $("#deactivated").prop("checked", (obj.deactivated))
               }
           });

           // use jquery's $.ajaxSetup and $.ajax to talk to the server
       });

   });

   $

   function setSelect(){

       // we need to reset the select to the new value
       // so if any other changes are made without reselecting the 
       // drop down menu, it won't crash.
       var newName = document.getElementById('clientUserName').value;
       document.getElementById('selectedClient').value = newName;
       //$("#selectedClient").val(name.val());


   }
</script>
