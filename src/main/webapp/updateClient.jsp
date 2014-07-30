<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<section id="register-form">
    <h4>Update Existing Client Account</h4>
    <s:form action="getClientInfo">
        <s:select id="selectClient" label="Select" headerKey="-1" headerValue="Select Client"
        list="clients"/>
        <s:submit value="submit" name="submit"/>
    </s:form>

    <s:form action="getClientInfo"> 
        <s:textfield name="userName" label="User Name"></s:textfield>
        <s:textfield name="name" label="Name" ></s:textfield>
        <s:textfield name="email" label="Email" ></s:textfield>
    </s:form>
        <div id="userName"></div>
</section>

<script type="text/javascript">
   // jquery, with my document, when the ready event is fired, call 
   // this anonymous function.
   $(document).ready(function(){
       // jquery, with element identified by the name "selectClient",
       // when the change event is fired, call this anonymous function.
       $( "#selectClient" ).change(function() {
           //alert, jquery with this(the element calling the event, in
           // this case, selectClient), get the value.
           $.ajax({
               url: "<s:url action='getClientInfo'/>",
               success : function(result){
                   alert(result);
               }
           //}).done(function() {
               //alert($("#selectClient").val());
           });

           //TODO call a server action passing the username selected
           //     which returns the user properties. 

           // use jquery's $.ajaxSetup and $.ajax to talk to the server
       });
   });

   $
</script>
