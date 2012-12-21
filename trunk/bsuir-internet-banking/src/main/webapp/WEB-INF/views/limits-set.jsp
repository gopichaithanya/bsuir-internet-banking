<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<c:if test="${!ajaxRequest}">
	<html>
<body>
</c:if>
<div id="formsContent">
	<div id="breadcumbs" class="span12">
		<ul class="breadcrumb">
			<li><a href="<c:url value='/main' />">Главная</a> <span class="divider">/</span></li>
			<li class="active">Установить лимиты по карте</li>
			
		</ul>
	</div>
	<form:form id="form" method="post" class="form span5" modelAttribute="limits">
		<div class="control-group">
			<h4>Заполните суточные лимиты</h4>
			<br>
		</div>
		<div class="control-group error">
			<s:bind path="*">
				<c:if test="${status.error}">
					<div id="controls" class="alert alert-error">${status.errorMessage}</div>
				</c:if>
			</s:bind>
		</div>
		<div id="divMoneyLimit" class="control-group">
			<label class="control-label"> 
						<strong>Карта:</strong> ${info.displayValue}
			</label>
		</div>
		<div id="divMoneyLimit" class="control-group">
			<form:label class="control-label" path="moneyLimit"> 
						<strong>Лимит по сумме</strong> 
			</form:label>
			<div class="controls">
				<form:input path="enteredMoneyLimit" autocomplete="off" id="inputOrigPassword"
					placeholder="" required="true"/><span class="help-inline">(${info.currencyType})</span>
				<form:errors class="help-inline error bankingError" path="enteredMoneyLimit" />
			</div>
		</div>
		<div id="divPassword" class="control-group">
			<form:label class="control-label" path="operationsLimit"> 
						<strong>Лимит по расходным операциям</strong>
			</form:label>
			<div class="controls">
				<form:input path="enteredOperationsLimit" autocomplete="off" id="inputPassword"
					placeholder="" required="true"/>
				<form:errors class="help-inline error bankingError" path="enteredOperationsLimit"  />
			</div>
		</div>
		<div id="divConfirm" class="control-group">
			<form:label class="control-label" path="secretWord"> 
						<strong>Секретное слово</strong> 
			</form:label>
			<div class="controls">
				<form:password path="secretWord" id="inputConfirm"
					placeholder="Введите секретное слово" required="true"/>
				<form:errors class="help-inline" path="secretWord" />
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<button type="submit" class="btn">Принять</button>
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
