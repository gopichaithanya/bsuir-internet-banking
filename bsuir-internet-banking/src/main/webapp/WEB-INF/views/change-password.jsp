<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<c:if test="${!ajaxRequest}">
	<html>
<body>
</c:if>
<div id="formsContent">
	<form:form id="form" method="post" modelAttribute="user">
		<%-- <div class="control-group error">
			<s:bind path="*">
				<c:if test="${status.error}">
					<div id="controls" class="help-inline">Form has errors</div>
				</c:if>
			</s:bind>
		</div> --%>
		<s:bind path="*">
			<c:if test="${status.error}">
				<c:set var="usernameErrors">
					<form:errors path="username" />
				</c:set>
				<c:set var="passwordErrors">
					<form:errors path="password" />
				</c:set>
			</c:if>
		
		<div class="control-group">
			<h4>Change  password</h4>
			<br>
		</div>
		<div id="divOldPassword" class="control-group">
			<%-- <form:label class="control-label" path="username"> 
						Username 
			</form:label> --%>
			<div class="controls">
				<form:input path="username" id="inputPassword" autocomplete="off"
					placeholder="Old password" />
				<form:errors class="help-inline" path="username" />
			</div>
		</div>
		<div id="divNewPassword" class="control-group">
			<%-- <form:label class="control-label" path="password"> 
						Password 
			</form:label> --%>
			<div class="controls">
				<form:input path="password" id="inputPassword"
					placeholder="New password" />
				<form:errors class="help-inline" path="password" />
			</div>
		</div>
		<div  class="control-group">
			<%-- <form:label class="control-label" path="password"> 
						Password 
			</form:label> --%>
			<div class="controls">
				<form:input path="password" id="inputPassword"
					placeholder="confirm new password" />
				<form:errors class="help-inline" path="password" />
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<button type="submit" class="btn">Sign in</button>
			</div>
		</div>
		</s:bind>
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
	<c:if test="${not empty usernameErrors}">
		<script type="text/javascript">
			$('#divUsername').addClass('error');
		</script>
	</c:if>
	<c:if test="${not empty passwordErrors}">
		<script type="text/javascript">
			$('#divPassword').addClass('error');
		</script>
	</c:if>
</div>
<c:if test="${!ajaxRequest}">
	</body>
	</html>
</c:if>
