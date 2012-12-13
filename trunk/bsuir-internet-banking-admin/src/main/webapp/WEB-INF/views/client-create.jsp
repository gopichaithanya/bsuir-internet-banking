<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:if test="${!ajaxRequest}">
	<html>
<body>
</c:if>
<div id="formsContent">
<div class="span6 well">
	<form:form id="form" method="post" class="form"
		modelAttribute="client">
		<div class="control-group">
			<h4>Please enter client information</h4>
			<br>
		</div>
		
		<s:bind path="*">
			<c:if test="${status.error}">
				<div id="message" class="alert alert-error">Form has errors</div>
			</c:if>
		</s:bind>
		<%-- <div class="control-group">
			<div class="controls">
				<form:input path="login" id="inputLogin"
					placeholder="Username" />
				<form:errors class="help-inline" path="login" />
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<form:input path="password" id="inputPassword"
					placeholder="Password" />
				<form:errors class="help-inline" path="password" />
			</div>
		</div> --%>
		<div class="control-group">
			<%-- <form:label class="control-label" path="firstName" > 
						First Name <form:errors class="error" path="firstName" />
			</form:label> --%>
			<div class="controls">
				<form:input path="firstName" id="inputFirstName"
					placeholder="First Name" />
				<form:errors class="help-inline" path="firstName" />
			</div>
		</div>
		<div class="control-group">
			<%-- <form:label class="control-label" path="middleName"> 
						Middle Name <form:errors path="middleName" />
			</form:label> --%>
			<div class="controls">
				<form:input path="middleName" id="inputMiddleName"
					placeholder="Middle Name" />
				<form:errors class="help-inline" path="middleName" />
			</div>
		</div>
		<div class="control-group">
			<%-- <form:label class="control-label" path="lastName"> 
						Last Name <form:errors path="lastName" />
			</form:label> --%>
			<div class="controls">
				<form:input path="lastName" id="inputLastName"
					placeholder="Last Name" />
				<form:errors class="help-inline" path="lastName" />
			</div>
		</div>
		<div class="control-group">
			<%-- <form:label class="control-label" path="lastName"> 
						Last Name <form:errors path="lastName" />
			</form:label> --%>
			<div class="controls " >
				<form:input path="birthdayDate" id="inputBirthdayDate"
					placeholder="Birthday (dd/mm/yyyy)" readonly="true" />
					<!--<span class="add-on"><i class="icon-calendar"></i></span>-->
				<form:errors class="help-inline" path="birthdayDate" />
			</div>
				
		</div>
		
		<div class="control-group">
			<%-- <form:label class="control-label" path="lastName"> 
						Last Name <form:errors path="lastName" />
			</form:label> --%>
			<div class="controls">
				<form:input  path="address" id="inputAddress"
					placeholder="Address" />
				<form:errors class="help-inline" path="address" />
			</div>
		</div>
		<div class="control-group">
			<%-- <form:label class="control-label" path="lastName"> 
						Last Name <form:errors path="lastName" />
			</form:label> --%>
			<div class="controls">
				<form:input  path="phoneNumber" id="inputPhoneNumber"
					placeholder="Phone Number" />
				<form:errors class="help-inline" path="phoneNumber" />
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<button type="submit" class="btn">Next</button>
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
