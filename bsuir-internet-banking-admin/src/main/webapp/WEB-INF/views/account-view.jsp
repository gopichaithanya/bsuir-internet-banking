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
			<div class="span6">
				<h4>Account Info</h4>

				<table class="table table-condensed">
					<tr>
						<th>Number</th>
						<td>${account_card.accountNumber}</td>
					</tr>
					<tr>
						<th>Balance</th>
						<td>${account_card.amount}</td>
					</tr>
					<tr>
						<th>Currency</th>
						<td>${account_card.currencyType.shortName}</td>
					</tr>

				</table>

			</div>
			<c:choose>
				<c:when test="${hasCard}">
					<div class="span6">
						<h4>Card Info</h4>
						<table class="table table-condensed">
							<tr>
								<th>Number</th>
								<td>${account_card.cardNumber}</td>
							</tr>
							<tr>
								<th>Card type</th>
								<td>${account_card.cardType.name}</td>
							</tr>
							<tr>
								<th>Status</th>
								<td>${account_card.status}</td>
							</tr>
							<tr>
								<th>Expiration date</th>
								<td><fmt:formatDate pattern="dd/MM/yyyy" value="${account_card.expirationDate}" /></td>
							</tr>
							<tr>
								<th>CVV2</th>
								<td>${account_card.CVV2}</td>
							</tr>
							<tr>
								<th>Money Limit</th>
								<td>${account_card.moneyLimit}</td>
							</tr>
							<tr>
								<th>Operations Limit</th>
								<td>${account_card.operationsLimit}</td>
							</tr>
						</table>
					</div>
				</c:when>
				<c:otherwise>
					<div class="span6">
						<h4>NO CARD</h4>

						<table class="table table-condensed">
							

						</table>

					</div>
				</c:otherwise>
			</c:choose>
			
		</div>
		<div class="row-fluid">
				<c:if test="${empty account_card.card}">
					<a class="btn btn-info"
						href="<c:url value="/card/create" />">Create card</a>
				</c:if>
					<c:if test="${hasCard}"> 
					<a class="btn btn-danger pull-right"
					href="<c:url value="/card/delete/${account_card.cardId}" />">Delete
					card</a>
					</c:if>
			</div>
		<!-- <div class="span6 well">
	
	</div> -->
		<script type="text/javascript">
			$(document).ready(
					function() {
						$("#form").submit(
								function() {
									$.post($(this).attr("action"), $(this)
											.serialize(), function(html) {
										$("#formsContent").replaceWith(html);
										$('html, body').animate(
												{
													scrollTop : $("#message")
															.offset().top
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