<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<c:if test="${!ajaxRequest}">
	<html>
<body>
</c:if>
<div id="formsContent">
	<form:form id="form" method="post" name="form" class="form span5 well" modelAttribute="userInfo">
		<div class="control-group">
			<h4>Введите имя пользователя и пароль</h4>
			<br>
		</div>
		<div class="control-group error">
			<s:bind path="*">
				<c:if test="${status.error}">
					<div id="controls" class="alert alert-error">${status.errorMessage }</div>
				</c:if>
			</s:bind>
		</div>
		<div id="divUsername" class="control-group">
			<%-- <form:label class="control-label" path="username"> 
						Username 
			</form:label> --%>
			<div class="controls">
				<form:input path="username" autocomplete="off" id="inputUsername"
					placeholder="Имя пользователя" />
				<%-- <form:errors class="help-inline error" path="username" /> --%>
			</div>
		</div>
		<div id="divPassword" class="control-group">
			<%-- <form:label class="control-label" path="password"> 
						Password 
			</form:label> --%>
			<div class="controls">
				<form:password path="password" id="inputPassword"
					placeholder="Пароль" />
				<%-- <form:errors class="help-inline" path="password" /> --%>
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<button type="submit" onclick="this.disabled=true;document.form.submit();" class="btn">Войти</button>
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
