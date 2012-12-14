<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:if test="${!ajaxRequest}">
	<html>
<body>
</c:if>
<div id="formsContent">
	<div class="span12 well">
		<form:form id="form" method="post" class="form-horizontal"
			modelAttribute="client">
			<div class="control-group">
				<h4>Edit client information</h4>

			</div>
			<div class="row-fluid">
				<div class="span6">
					<s:bind path="*">
						<c:if test="${status.error}">
							<div id="message" class="alert alert-error">Form has errors</div>
						</c:if>
					</s:bind>
					<div class="control-group">
						<form:label class="control-label" path="firstName"> 
						First name 
					</form:label>
						<div class="controls">
							<form:input path="firstName" id="inputFirstName"
								placeholder="First Name" />
							<form:errors class="help-inline" path="firstName" />
						</div>
					</div>
					<div class="control-group">
						<form:label class="control-label" path="middleName"> 
						Middle name 
					</form:label>
						<div class="controls">
							<form:input path="middleName" id="inputMiddleName"
								placeholder="Middle Name" />
							<form:errors class="help-inline" path="middleName" />
						</div>
					</div>
					<div class="control-group">
						<form:label class="control-label" path="lastName"> 
						Last name 
					</form:label>
						<div class="controls">
							<form:input path="lastName" id="inputLastName"
								placeholder="Last Name" />
							<form:errors class="help-inline" path="lastName" />
						</div>
					</div>
					<div class="control-group">
						<form:label class="control-label" path="birthdayDate"> 
						Birth date 
					</form:label>
						<div class="controls">
							<form:input path="birthdayDate" id="inputBirthdayDate"
								placeholder="Birthday (dd/mm/yyyy)" readonly="true" />
							<form:errors class="help-inline" path="birthdayDate" />
						</div>
					</div>
					<div class="control-group">
						<form:label class="control-label" path="address"> 
						Address
					</form:label>
						<div class="controls">
							<form:input path="address" id="inputAddress"
								placeholder="Address" />
							<form:errors class="help-inline" path="address" />
						</div>
					</div>
					<div class="control-group">
						<form:label class="control-label" path="phoneNumber"> 
						Phone number 
					</form:label>
						<div class="controls">
							<form:input path="phoneNumber" id="inputPhoneNumber"
								placeholder="Phone Number" />
							<form:errors class="help-inline" path="phoneNumber" />
						</div>
					</div>
				</div>
				<div class="span6">
					<div class="control-group">
						<form:label class="control-label" path="passport.authority"> 
						Authority
					</form:label>
						<div class="controls">
							<form:input path="passport.authority" id="inputAuthority"
								placeholder="Authority" />
							<form:errors class="help-inline" path="passport.authority" />
						</div>
					</div>
					<div class="control-group">
						<form:label class="control-label" path="passport.dateOfExpiry"> 
						Expiration date
					</form:label>
						<div class="controls">
							<form:input path="passport.dateOfExpiry" id="inputDateOfExpiry"
								placeholder="Date of expiry (dd/mm/yyyy)" readonly="true" />
							<form:errors class="help-inline" path="passport.dateOfExpiry" />
						</div>
					</div>
					<div class="control-group">
						<form:label class="control-label" path="passport.dateOfIssue"> 
						Issue date 
					</form:label>
						<div class="controls">
							<form:input path="passport.dateOfIssue" id="inputDateOfIssue"
								placeholder="Date of issue (dd/mm/yyyy)" readonly="true" />
							<form:errors class="help-inline" path="passport.dateOfIssue" />
						</div>
					</div>
					<div class="control-group">
						<form:label class="control-label" path="passport.seria"> 
						Seria 
					</form:label>
						<div class="controls">
							<form:input path="passport.seria" id="inputSeria"
								placeholder="Seria" />
							<form:errors class="help-inline" path="passport.seria" />
						</div>
					</div>
					<div class="control-group">
						<form:label class="control-label" path="passport.number"> 
						Number 
					</form:label>
						<div class="controls">
							<form:input path="passport.number" id="inputNumber"
								placeholder="Number" />
							<form:errors class="help-inline" path="passport.number" />
						</div>
					</div>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<button type="submit" class="btn btn-success">Submit</button>
					<a class="btn btn-danger pull-right" href="<c:url value="/client/delete/${client.id}"/>">Delete client</a>
				</div>
			</div>

		</form:form>
	</div>
	<!-- <div class="span6 well">
	
	</div> -->
	<script type="text/javascript">
		$(document).ready(
				function() {
					$("#form").submit(
							function() {
								$.post($(this).attr("action"), $(this)
										.serialize(), function(html) {
									$("#formsContent").replaceWith(html);
									$('html, body').animate({
										scrollTop : $("#message").offset().top
									}, 500);
								});
								return false;
							});
				});
	</script>
</div>
<c:if test="${!ajaxRequest}">
	</body>
	</html>
</c:if>
