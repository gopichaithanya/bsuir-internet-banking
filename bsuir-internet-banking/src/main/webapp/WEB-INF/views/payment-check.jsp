<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<c:if test="${!ajaxRequest}">
	<html>
<body>
</c:if>
<div id="content">
	<div id="breadcumbs" class="span12">
		<ul class="breadcrumb">
			<li><a href="<c:url value='/main' />">Главная</a> <span
				class="divider">/</span></li>
			<li><a href="<c:url value='/payment/list' />">Платежи</a><span
				class="divider">/</span></li>
			<li class="active">${payment.legalPerson.name}</li>
		</ul>
	</div>
	<br>
	<div id="ratesInfo" class="span8">
		<h4>Проверить введенные данные: ${payment.legalPerson.category.name.value} - ${payment.legalPerson.name}</h4>
		<c:choose>
			<c:when test="${fn:length(cardSelect) == 0}">
				<div class="clearfix alert alert-error ">У Вас нет карт. Вы не можете провести платеж. Свяжитесь с оператором банка.</div>
			</c:when>
			<c:otherwise>
				<form:form id="form" method="post" class="form span10"
					modelAttribute="payment">
					<s:bind path="*">
						<c:if test="${status.error}">
							<div id="message" class="alert alert-error">${status.errorMessage}.</div>
						</c:if>
					</s:bind>
					
					<div class="control-group">
						<form:label class="control-label" path="сardNumber"> 
						<strong>С карты:</strong> <div class="controls"> ${card} </div>
						</form:label>
					</div>
					<div class="control-group">
						<form:label class="control-label" path="infoString"> 
						<strong>${payment.infoLabel}</strong> <form:errors path="infoString" />
						</form:label>
						<div class="controls">
							<form:input readonly="true" required="required" path="infoString"  />
							
						</div>
					</div>
					<div class="control-group">
						<form:label class="control-label" path="clientName"> 
						<strong>Клиент</strong> <form:errors path="clientName" />
						</form:label>
						<div class="controls">
							<form:input readonly="true" class="input-xlarge" required="required" path="clientName" />
							
						</div>
					</div>
					<div class="control-group">
						<form:label class="control-label" path="amount.amount"> 
						<strong>Сумма</strong> <form:errors path="amount.amount" />
						</form:label>
						<div class="controls">
							<form:input readonly="true" required="required" path="amount.amount" />
							
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<a href="<c:url value='/payment/list'/>" class="btn btn-danger">Отменить</a>
							<a href="<c:url value='/payment/pay/${payment.legalPerson.id}'/>" class="btn btn-warning">Назад</a>
							<button type="submit" class="btn btn-success">Принять</button>
						</div>
					</div>

				</form:form>
			</c:otherwise>
		</c:choose>
	</div>
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
