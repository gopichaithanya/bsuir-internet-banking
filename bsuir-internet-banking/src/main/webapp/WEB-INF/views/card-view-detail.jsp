<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<c:if test="${!ajaxRequest}">
	<html>
<body>
</c:if>
<div id="formsContent">
	<div class="span8 well">
		<div class="row-fluid">
			<div class="span10">
				<h4>Карт-счет</h4>

				<table class="table table-condensed">
					<tr>
						<th>Номер</th>
						<td>${card.hiddenNumber}</td>
					</tr>
					<tr>
						<th>Баланс</th>
						<td>${ballance.amount}</td>
					</tr>
					<tr>
						<th>Валюта</th>
						<td>${ballance.currencyType}</td>
					</tr>
					<tr>
						<th>Тип карты</th>
						<td>${card.cardType.name}</td>
					</tr>
					<tr>
						<th>Статус</th>
						<td>${card.status}</td>
					</tr>
					<tr>
						<th>Срок действия</th>
						<td><fmt:formatDate pattern="dd/MM/yyyy"
								value="${card.expirationDate}" /></td>
					</tr>
					<tr>
						<th>Лимит по сумме (в сутки)</th>
						<td>${card.moneyLimit} (${ballance.currencyType})</td>
					</tr>
					<tr>
						<th>Лимит по операциям (в сутки)</th>
						<td>${card.operationsLimit}</td>
					</tr>
					<c:if test="${card.locked}">
						<tr class="error">
						<td colspan="2"><strong>Карта заблокированна: операции по карте запрещены</strong></td>
						</tr>
					</c:if>
				</table>

			</div>
		</div>
		<div class="row-fluid">
			<table>
				<tr><c:choose>
				<c:when test="${not card.locked}">
					<td><a
						href="<c:url value='/card/${card.cardId}/limits/set' />"
						class="btn btn-small btn-primary">Установить лимиты</a></td>
					<td>
							
								<form action="<c:url value='/card/${card.cardId}/lock' />"
									style="padding: 0; margin: 0" method="post">
									<input type="submit" class="btn btn-small btn-warning"
										value="Заблокировать карту"
										onclick="return confirm('Вы уверены, что хотите заблокировать карту?')" />
								</form>
							</td>
							</c:when>
							<c:otherwise>
							<td>
								<form action="<c:url value='/card/${card.cardId}/unlock' />"
									style="padding: 0; margin: 0" method="post">
									<input type="submit" class="btn btn-small btn-warning"
										value="Разблокировать карту" />
								</form>
								</td>
							</c:otherwise>
						</c:choose>
				</tr>
			</table>
		</div>
		<!-- <div class="span6 well">
	
	</div> -->
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