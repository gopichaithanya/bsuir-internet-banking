<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<c:if test="${!ajaxRequest}">
	<html>
<body>
</c:if>
<div id="formsContent">
	<form:form id="form" name="form" method="post" class="form span5 well"
		modelAttribute="admin">
		<div class="control-group">
			<h4>Please enter administrator information</h4>
			<br>
		</div>
		
		<s:bind path="*">
			<c:if test="${status.error}">
				<div id="message" class="alert alert-error">Form has errors</div>
			</c:if>
		</s:bind>
		<div class="control-group">
			<div class="controls">
				<form:input path="login" id="inputLogin"
					placeholder="Username" />
				<form:errors class="help-inline" path="login" />
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<form:password path="password" id="inputPassword"
					placeholder="Password" />
				<form:errors class="help-inline" path="password" />
			</div>
		</div>
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
			<div class="controls">
				<button type="submit" onclick="this.disabled=true;document.form.submit();" class="btn">Submit</button>
			</div>
		</div>
	</form:form>
	
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
