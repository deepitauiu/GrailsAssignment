
<g:if test="${!changePassword}">
<div class="form-group">
    <label><g:message code="first.name"/> *</label>
    <g:textField name="firstName" class="form-control" value="${member?.firstName}" placeholder="Please Enter First Name"/>
    <UIHelper:renderErrorMessage fieldName="firstName" model="${member}" errorMessage="Please Enter First Name"/>
</div>

<div class="form-group">
    <label><g:message code="last.name"/></label>
    <g:textField name="lastName" class="form-control" value="${member?.lastName}" placeholder="Please Enter Last Name"/>
</div>

<div class="form-group">
    <label><g:message code="address"/></label>
    <g:textField name="address" class="form-control" value="${member?.address}" placeholder="Please Enter Address"/>
</div>

<div class="form-group">
    <label><g:message code="phone"/></label>
    <g:textField name="phone" class="form-control" value="${member?.phone}" placeholder="Please Enter Phone Number"/>

    <UIHelper:renderErrorMessage fieldName="phone" model="${member}" errorMessage="Invalid Phone Number"/>
</div>

<div class="form-group">
    <label><g:message code="email.address"/> *</label>
    <g:field type="email" name="email" class="form-control" value="${member?.email}" placeholder="Please Enter Email"/>
    <UIHelper:renderErrorMessage fieldName="email" model="${member}" errorMessage="Your Email Address is not Valid / Already Exist in System"/>
</div>


<div class="form-group">
    <label><g:message code="birth.date"/></label>
    <g:datePicker name="birthDate" years="${1930..2010}" value="${member?.birthDate}" placeholder="Please Birth Date"/>
</div>

<g:if test="${!edit}">
    <div class="form-group">
        <label><g:message code="password"/> *</label>
        <g:passwordField name="password" class="form-control" value="${member?.password}" placeholder="Please Enter Password"/>
        <UIHelper:renderErrorMessage fieldName="password" model="${member}" errorMessage="Please Enter a Password."/>
    </div>
</g:if>
</g:if>