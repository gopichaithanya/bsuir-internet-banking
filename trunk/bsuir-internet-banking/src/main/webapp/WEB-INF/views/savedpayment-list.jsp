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
			<li class="active">Сохраненные платежи</li>

		</ul>
	</div>
	<br>
	<div id="ratesInfo" class="span10">
		<h4>Сохраненные платежи</h4>
		<table class="table table-hover">
			<tr>
				<th>#</th>
				<th>Номер карты</th>
				<th>Услуга</th>
				<th>Сумма</th>
				<th>Валюта</th>
				<th>Информация</th>
				
			</tr>
			<tr>
				<c:forEach begin="0" end="${fn:length(savedpayments)-1}"
					varStatus="loop">
					<tr>
						<td>${loop.index + 1}</td>
						<td>${savedpayments[loop.index].cardNumber}</td>
						<td>${savedpayments[loop.index].legalPersonName}</td>
						<td>${savedpayments[loop.index].amount.amount}</td>
						<td>${savedpayments[loop.index].amount.currencyType}</td>
						<td>${savedpayments[loop.index].information}</td>
						
					</tr>
				</c:forEach>
			</tr>
		</table>
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
