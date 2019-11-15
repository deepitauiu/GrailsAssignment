 <div class="form-group">
        <label><g:message code="oldPassword"/> *</label>
        <g:passwordField name="oldPassword" class="form-control" value="" placeholder="Please Enter Old Password"/>
        <UIHelper:renderErrorMessage fieldName="password" model="${member}"/>
 </div>
 <div class="form-group">
     <label><g:message code="newPassword"/> *</label>
     <g:passwordField name="newPassword" class="form-control" value="" placeholder="Please Enter Password"/>
     <UIHelper:renderErrorMessage fieldName="password" model="${member}" />
 </div>
 <div class="form-group">
     <label><g:message code="confirmPassword"/> *</label>
     <g:passwordField name="password" class="form-control" value="" placeholder="Please Enter Password"/>
     <UIHelper:renderErrorMessage fieldName="password" model="${member}"/>
 </div>