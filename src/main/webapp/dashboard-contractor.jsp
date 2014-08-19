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

    <s:if test="hasActionMessages()"> <div class="success">
            <s:actionmessage/>
        </div>
    </s:if>
    <s:if test="hasActionErrors()"> <div class="success">
            <s:actionerror/>
        </div>
    </s:if>

    <div>
        <s:action name="show-repositoryOptions" executeResult="true"/>
    <%--
        <s:action name="show-timeOptions" executeResult="true"/> 
    --%>
        <s:action name="show-updateClient" executeResult="true"/>
        <a href="<s:url action='logout' />">Logout</a>


    <%--
        <a href="<s:url action='show-updateClient' />">Client Options</a>
        <br/>
        <a href="<s:url action='show-repositoryOptions' />">Repository Options</a>
        <br/>
    --%>
        <a href="<s:url action='show-timeOptions' />">Time Session</a>
        <%--
        <br/>
        <a href="<s:url action='logout' />">Logout</a>
        --%>
    </div>

</section>
