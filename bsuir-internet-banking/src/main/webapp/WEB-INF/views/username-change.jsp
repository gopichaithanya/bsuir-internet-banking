<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<c:if test="${!ajaxRequest}">
	<html>
<body>
</c:if>
<div id="formsContent">
	<div id="breadcumbs">
		<ul class="breadcrumb">
			<li><a href="<c:url value='/main' />">Главная</a> <span class="divider">/</span></li>
			<li class="active">Сменить имя пользователя</li>
			
		</ul>
	</div>
	<form:form id="form" method="post" name="form" class="form span5" modelAttribute="changeusername">
		<div class="control-group">
			<h4>Заполните форму</h4>
			<br>
		</div>
		<div class="control-group error">
			<s:bind path="*">
				<c:if test="${status.error}">
					<div id="controls" class="alert alert-error">${status.errorMessage}</div>
				</c:if>
			</s:bind>
		</div>
		<div id="divOrigUsername" class="control-group">
			<%-- <form:label class="control-label" path="username"> 
						Username 
			</form:label> --%>
			<div class="controls">
				<form:input path="originalUsername" autocomplete="off" id="inputOrigUsername"
					placeholder="Текущее имя пользователя" required="required" />
				<form:errors class="help-inline error bankingError" path="originalUsername" />
			</div>
		</div>
		<div id="divUsername" class="control-group">
			<%-- <form:label class="control-label" path="username"> 
						Username 
			</form:label> --%>
			<div class="controls">
				<form:label class="control-label" path="username" style="color:#ccc"> 
				</form:label>
				<form:input path="username" autocomplete="off" id="inputUsername"
					placeholder="Новое имя пользователя" required="required" />
											<p style="color:#ccc; font-size:12px;">Имя пользователя может содержать латинские буквы, цифры и знак подчеркивания и должен содержать не менее 3 символов</p> 
				<form:errors class="help-inline error bankingError" path="username" />
			</div>
		</div>
		<div id="divConfirm" class="control-group">
			<div class="controls">
				<form:input path="confirmUsername" id="inputConfirm" autocomplete="off"
					placeholder="Подтвердите имя пользователя" required="required" />
				<form:errors class="help-inline bankingError" path="confirmUsername" />
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<button type="submit" class="btn" onclick="this.disabled=true;document.form.submit();">Принять</button>
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
