<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<c:if test="${!ajaxRequest}">
	<html>
<body>
</c:if>
<div id="formsContent">
	<form:form id="form" method="post"
		class="form-horizontal">
		<div>
			<c:if test="${not empty message}">
				<div id="message" class="success">${message}</div>
			</c:if>
			<s:bind path="*">
				<c:if test="${status.error}">
					<div id="message" class="error">Form has errors</div>
				</c:if>
			</s:bind>
		</div>
		<div class="control-group">
			<form:label class="control-label" path="firstName"> 
						First Name <form:errors class="error" path="firstName" />
			</form:label>
			<div class="controls">
				<form:input path="firstName" id="inputFirstName"
					placeholder="First Name" />
			</div>
		</div>
		<div class="control-group">
			<form:label class="control-label" path="middleName"> 
						Middle Name <form:errors path="middleName" />
			</form:label>
			<div class="controls">
				<form:input path="middleName" id="inputMiddleName"
					placeholder="Middle Name" />
			</div>
		</div>
		<div class="control-group">
			<form:label class="control-label" path="lastName"> 
						Last Name <form:errors path="lastName" />
			</form:label>
			<div class="controls">
				<form:input path="lastName" id="inputLastName"
					placeholder="Last Name" />
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<button type="submit" class="btn">Sign in</button>
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
