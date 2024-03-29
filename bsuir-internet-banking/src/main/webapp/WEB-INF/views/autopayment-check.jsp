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
			<li><a href="<c:url value='/autopayment/list' />">Автоплатежи</a><span
				class="divider">/</span></li>
				
				<c:if test="${ not empty payment.legalPerson}">
					<li class="active"><c:choose><c:when test="${!payment.saved}">Создать</c:when><c:otherwise>Редактировать</c:otherwise></c:choose> автоплатеж - ${payment.legalPerson.name}</li>
				</c:if>
				<c:if test="${ not empty payment.erip}">
					<li class="active"><c:choose><c:when test="${!payment.saved}">Создать</c:when><c:otherwise>Редактировать</c:otherwise></c:choose> автоплатеж - ${payment.erip.name}</li>
				</c:if>
		</ul>
	</div>
	<br>
	<div id="ratesInfo" class="span8">
		<c:if test="${ not empty payment.legalPerson}">
			<h4>Проверить автоплатеж: ${payment.legalPerson.category.name.value} - ${payment.legalPerson.name}</h4>
		</c:if>
		<c:if test="${ not empty payment.erip}">
			<h4>Проверить автоплатеж в системе Расчет: ${payment.erip.region.name.value} - ${payment.erip.city.name.value} - ${payment.erip.name}</h4>
		</c:if>
		<c:choose>
			<c:when test="${fn:length(cardSelect) == 0}">
				<div class="clearfix alert alert-error ">У Вас нет карт. Вы не можете создать автоплатеж. Свяжитесь с оператором банка.</div>
			</c:when>
			<c:otherwise>
				<form:form id="form" name="form" method="post" class="form span10"
					modelAttribute="payment">
					<s:bind path="*">
						<c:if test="${status.error}">
							<div id="message" class="alert alert-error">${status.errorMessage}.</div>
						</c:if>
					</s:bind>
					
					<div class="control-group">
						<form:label class="control-label" path="displayCard">
							<strong>С карты:</strong>
							<div class="controls">${payment.displayCard}</div>
						</form:label>
					</div>
					<div class="control-group">
						<form:label class="control-label" path="infoString"> 
						<strong>${payment.infoLabel}</strong> <form:errors path="infoString" />
						</form:label>
						<div class="controls">
							<form:input readonly="true" path="infoString"  />
							
						</div>
					</div>
					<div class="control-group">
						<form:label class="control-label" path="amount.enteredAmount"> 
						<strong>Сумма</strong> <form:errors path="amount.enteredAmount" />
						</form:label>
						<div class="controls">
							<form:input required="required" readonly="true" path="amount.enteredAmount" />
							<span>(BYR)</span>
							<form:errors path="amount.enteredAmount"/>
						</div>
					</div>
					<div class="control-group">
						<form:label class="control-label" path="dayOfMonth"> 
						<strong>Оплачивать каждое</strong> 
						</form:label>
						<div class="controls">
							<form:input class="input-mini" readonly="true"  path="dayOfMonth" />
						<strong> число месяца:</strong>				
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<a href="<c:url value='/autopayment/list'/>" class="btn btn-danger">Отменить</a>
							<!-- BACK BUTTON -->
							<input type="submit" class="btn btn-success" value="Дальше" onclick="this.disabled=true;document.form.submit();"/>
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
