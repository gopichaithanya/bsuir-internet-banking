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
	<div class="span10 well">
		<c:if test="${hasCard}">
			<c:if test="${account_card.expired}">
				<div class="alert alert-warning">Card has expired. All
					operations with this card are forbidden. Delete the card.</div>
			</c:if>
			<c:if test="${account_card.locked}">
				<div class="alert alert-warning">Card is locked. All
					operations with this card are forbidden.</div>
			</c:if>
		</c:if>
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
								<td><fmt:formatDate pattern="dd/MM/yyyy"
										value="${account_card.expirationDate}" /></td>
							</tr>
							<%-- <tr>
								<th>CVV2</th>
								<td>${account_card.CVV2}</td>
							</tr> --%>
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
					<div class="span6 error">
						<h4>NO CARD</h4>

						<table class="table table-condensed">


						</table>

					</div>
				</c:otherwise>
			</c:choose>

		</div>
		<div class="row-fluid">
		<input type="submit" class="btn" value="Close account"
						onclick="if (confirm('Are you sure you want to close account?')==true){this.disabled=true;document.form1.submit();}" />
			<c:if test="${!hasCard}">
				<a class="btn btn-primary" style="float: left;"
					href="<c:url value="/account/${client.id}/card/${account_card.accountId}/create" />">Create
					card</a>
				<form class="form form-inline pull-right" name="form1" method="post"
					action="<c:url value='/account/${client.id }/close/${account_card.accountId }' />">
					
				</form>
			</c:if>
			<c:if test="${hasCard}">
				<c:choose>
					<c:when test="${account_card.locked and !account_card.expired}">
						<a class="btn" href="<c:url value='/account/${client.id }/card/${account_card.accountId }/unlock/${account_card.cardId }' />" >Unlock card</a>
					</c:when>
					<c:when test="${!account_card.expired}">
						<a class="btn" href="<c:url value='/account/${client.id }/card/${account_card.accountId }/lock/${account_card.cardId }' />" >Lock card</a>
					</c:when>
				</c:choose>
				<c:if test="${!account_card.locked and !account_card.expired }">
					<a class="btn" href="<c:url value='/account/${client.id }/replenish/${account_card.accountId }' />" >Replenish account</a>
				</c:if>
				<form name="form2" method="post" class="form form-inline pull-right"
					action="<c:url value="/account/${client.id}/card/${account_card.accountId}/delete/${account_card.cardId}" />">
					<input type="submit" class="btn" value="Delete card"
						onclick="if (confirm('Are you sure you want to delete card?')==true){this.disabled=true;document.form2.submit();}" />
				</form>

			</c:if>
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