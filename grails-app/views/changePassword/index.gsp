%{--Include Main Layout--}%
<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header text-center">
        <g:message code="changePassword"/>
    </div>
    <div class="card-body">
        <g:form controller="changePassword" action="update">
            <g:render template="form"/>
            <div class="form-action-panel">
                <g:submitButton class="btn btn-primary" name="update" value="${g.message(code: "changePassword")}"/>
                <g:link controller="dashboard" action="index" class="btn btn-primary"><g:message code="cancel"/></g:link>
            </div>
        </g:form>
    </div>
</div>