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
			<li><a href="<c:url value='/transfer' />">Перевод</a><span
				class="divider">/</span></li>
			<li class="active">Сумма</li>
		</ul>
	</div>
	<br>
	<div id="ratesInfo" class="span8">
		<c:choose>
			<c:when test="${fn:length(cardSelect) == 0}">
				<div class="clearfix alert alert-error ">У Вас нет карт. Свяжитесь с оператором банка.</div>
			</c:when>
			<c:when test="${fn:length(cardSelect) == 1}">
				<div class="clearfix alert alert-error ">У Вас одна карта. Вы не можете провести операцию перевода.</div>
			</c:when>
			<c:otherwise>
				<h4>Введите сумму</h4>
				<form:form id="form" method="post" name="form" class="form span8"
					modelAttribute="transfer" >
					<s:bind path="*">
						<c:if test="${status.error}">
							<div id="message" class="alert alert-error">${status.errorMessage}.</div>
						</c:if>
					</s:bind>
					<div class="control-group">
						<label class="control-label"> 
						<strong>С карты</strong> : ${sender} 
						</label>
					</div>
					<br>
					<div class="control-group">
						<label class="control-label"> 
						<strong>На карту</strong> : ${receiver} 
						</label>
					</div>
					<br>
					<div class="control-group">
						<form:label class="control-label" path="amount.currencyType"> 
						<strong>Валюта:</strong> <form:errors path="amount.currencyType" />
						</form:label>
						<div class="controls">
							<form:select path="amount.currencyType" items="${curSelect}"></form:select>
							
						</div>
					</div>
					<div class="control-group">
						<form:label class="control-label" path="amount.enteredAmount"> 
						<strong>Сумма:</strong> <form:errors path="amount.enteredAmount" />
						</form:label>
						<div class="controls">
							<form:input path="amount.enteredAmount" ></form:input>
							
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<a href="<c:url value='/main' />" class="btn">Отмена</a>
							<button type="submit" onclick="this.disabled=true;document.form.submit();" class="btn">Принять</button>
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
