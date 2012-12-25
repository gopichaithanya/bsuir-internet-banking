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
			<li class="active">История переводов</li>

		</ul>
	</div>
	<br>
	<div id="ratesInfo" class="span11">
		<h4>Переводы за последние 3 месяца</h4>
		<table class="table table-hover table-condensed">
			<tr>
				<th>#</th>
				<th>С карты</th>
				<th>На карту</th>
				<th>Сумма</th>
				<th>Валюта</th>
				<th>Дата</th>
				<th>Статус</th>
			</tr>
			<tr>
			<c:if test="${not empty trasfers}">
				<c:forEach begin="0" end="${fn:length(transfers)-1}"
					varStatus="loop">
					<tr>
						<td>${loop.index + 1}</td>
						<td>${transfers[loop.index].senderCardNumber}</td>
						<td>${transfers[loop.index].receiverCardNumber}</td>
						<td>${transfers[loop.index].amount}</td>
						<td>${transfers[loop.index].currency}</td>
						<td><c:set var="date" value="${transfers[loop.index].dateTime}" />
						<fmt:formatDate pattern="MM/dd/yyyy HH:mm:ss" value="${date}" />
						</td>
						<td>${transfers[loop.index].status}</td>
					</tr>
				</c:forEach>
				</c:if>
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
