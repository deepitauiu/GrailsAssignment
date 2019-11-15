<%--
  Created by IntelliJ IDEA.
  User: Deepi
  Date: 13-Nov-19
  Time: 10:33 PM
--%>

<meta name="layout" content="public"/>

<div class="card">
    <div class="card-header text-center">
        User Registration
    </div>
    <div class="card-body">
        <g:form controller="authentication" action="doRegistration">
            <g:render template="/member/form"/>
            <g:submitButton name="registration" value="Registration" class="btn btn-primary"/>
            <g:link controller="authentication" action="login" class="btn btn-primary"><g:message code="back.to.login"/></g:link>
        </g:form>
    </div>
</div>