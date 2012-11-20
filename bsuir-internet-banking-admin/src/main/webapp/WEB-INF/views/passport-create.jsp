<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<c:if test="${!ajaxRequest}">
	<html>
<body>
</c:if>
<div id="formsContent">
<div class="span6 well">
	<form:form id="form" method="post" class="form"
		modelAttribute="passport">
		<div class="control-group">
			<h4>Please enter client's passport data</h4>
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
				<form:input path="authority" id="inputAuthority"
					placeholder="Authority" />
				<form:errors class="help-inline" path="authority" />
			</div>
		</div>
		<div class="control-group">
			<%-- <form:label class="control-label" path="middleName"> 
						Middle Name <form:errors path="middleName" />
			</form:label> --%>
			<div class="controls">
				<form:input path="dateOfExpiry" id="inputDateOfExpiry"
					placeholder="Date of expiry (mm/dd/yyyy)" />
				<form:errors class="help-inline" path="dateOfExpiry" />
			</div>
		</div>
		<div class="control-group">
			<%-- <form:label class="control-label" path="lastName"> 
						Last Name <form:errors path="lastName" />
			</form:label> --%>
			<div class="controls">
				<form:input path="dateOfIssue" id="inputDateOfIssue"
					placeholder="Date of issue (mm/dd/yyyy)" />
				<form:errors class="help-inline" path="dateOfIssue" />
			</div>
		</div>
		<div class="control-group">
			<%-- <form:label class="control-label" path="lastName"> 
						Last Name <form:errors path="lastName" />
			</form:label> --%>
			<div class="controls">
				<form:input path="seria" id="inputSeria"
					placeholder="Seria" />
				<form:errors class="help-inline" path="seria" />
			</div>
		</div>
		<div class="control-group">
			<%-- <form:label class="control-label" path="lastName"> 
						Last Name <form:errors path="lastName" />
			</form:label> --%>
			<div class="controls">
				<form:input  path="number" id="inputNumber"
					placeholder="Number" />
				<form:errors class="help-inline" path="number" />
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<button type="submit" class="btn">Submit</button>
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
