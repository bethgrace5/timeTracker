<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<section>
    <h4>Dashboard-contractor</h4>
    <%--<s:if test="%{#context['struts.actionMapping'].name=='register'}">
        <h5>Successfully registered as <s:property value="%{#parameters.userName}"/></h5>
    </s:if>
    <s:elseif test="%{#context['struts.actionMapping'].name=='login'}">
        <h5>Successfully logged in as <s:property value="%{#parameters.userName}"/></h5>
    </s:elseif> --%>
    <h5>Welcome contractor</h5>

    <s:if test="hasActionMessages()"> <div class="success">
            <s:actionmessage/>
        </div>
    </s:if>
    <s:if test="hasActionErrors()"> <div class="success">
            <s:actionerror/>
        </div>
    </s:if>

    <div>
        <a href="<s:url action='show-registerClient' />">Add New Client</a>
        <br/>
        <a href="<s:url action='show-updateClient' />">Update Existing Client</a>
        <br/>
        <a href="<s:url action='show-repositoryOptions' />">Repository Options</a>
        <br/>
        <a href="<s:url action='logout' />">Logout</a>
    </div>

</section>
