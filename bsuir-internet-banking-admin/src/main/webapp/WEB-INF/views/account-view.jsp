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
						<th>Currency</th>
						<td>${account_card.CurrencyType.shortName}</td>
					</tr>
					<%-- <tr>
						<th>Amount</th>
						<td>${client.middleName}</td>
					</tr>
					<tr>
						<th>Last name</th>
						<td>${client.lastName}</td>
					</tr>
					<tr>
						<th>Birth date</th>
						<c:set var="date" value="${client.birthdayDate}" />
						<td><fmt:formatDate pattern="MM/dd/yyyy" value="${date}" /></td>
					</tr>
					<tr>
						<th>Address</th>
						<td>${client.address}</td>
					</tr>
					<tr>
						<th>Phone number</th>
						<td>${client.phoneNumber}</td>
					</tr> --%>
				</table>
			</div>
		</div>
		<div class="row-fluid">
			<a class="btn btn-info"
				href="<c:url value="/client/edit/${client.id}" />">Edit</a> <a
				class="btn btn-info"
				href="<c:url value="/account/${client.id}/list" />">View
				Accounts</a> <a class="btn btn-success"
				href="<c:url value="/account/${client.id}/open" />">Open Account</a>
			<a class="btn btn-danger pull-right"
				href="<c:url value="/client/delete/${client.id}" />">Delete
				client</a>
		</div>
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
