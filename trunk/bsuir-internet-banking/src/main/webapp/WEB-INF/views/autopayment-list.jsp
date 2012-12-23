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
			<li class="active">Автоплатежи</li>

		</ul>
	</div>
	<br>
	<div id="ratesInfo" class="span11">
		<h4>Сохраненные автоплатежи</h4>
		<table class="table table-hover table-condensed">
			<tr>
				<th>#</th>
				<th>Номер карты</th>
				<th>Услуга</th>
				<th>Сумма</th>
				<th>Валюта</th>
				<th>День оплаты</th>
				<th>Информация</th>
				<th colspan="2">Действия</th>
			</tr>
			<tr>
				<c:forEach begin="0" end="${fn:length(list)-1}"
					varStatus="loop">
					<tr>
						<td>${loop.index + 1}</td>
						<td>${list[loop.index].cardNumber}</td>
						<td>${list[loop.index].name}</td>
						<td>${list[loop.index].amount.amount}</td>
						<td>${list[loop.index].amount.currencyType}</td>
						<td>${list[loop.index].dayOfMonth}</td>
						<td>${list[loop.index].displayInfo}</td>
						<td>
						<a href="<c:url value='/autopayment/edit/${list[loop.index].id}' />" class="btn btn-primary btn-mini">Редактировать</a>
						</td>
						<td>
						<span><form action="<c:url value='/autopayment/delete/${list[loop.index].id}'/>" method="post">
							<input  type="submit"  class="btn btn-danger btn-mini" value="Удалить" onclick="return confirm('Вы уверены, что хотите удалить автоплатеж?')"/>
						</form></span>
						</td>
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
