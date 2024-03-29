<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:if test="${!ajaxRequest}">
	<html>
<body>
</c:if>
<div id="formsContent">
	<div class="span10 well">
	<c:if test="${client.locked}">
						<div class="alert">Client's user account has been locked.</div>
					</c:if>
					<c:if test="${not empty newLogin }">
					<strong>New login:</strong> ${newLogin}
					</c:if>
					<c:if test="${not empty newPassword }">
					<strong>New password:</strong> ${newPassword}
					</c:if>
		<div class="row-fluid">
		
			<div class="span6">
				<h4>Client Info</h4>

				<table class="table table-condensed">
					<tr>
						<th>First name</th>
						<td>${client.firstName}</td>
					</tr>
					<tr>
						<th>Middle name</th>
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
					</tr>
				</table>
			</div>
			<div class="span6">
				<h4>Passport Data</h4>

				<table class="table table-condensed">
					<tr>
						<th>Seria</th>
						<td>${client.passport.seria}</td>
					</tr>
					<tr>
						<th>Number</th>
						<td>${client.passport.number}</td>
					</tr>
					<tr>
						<th>Authority</th>
						<td>${client.passport.authority}</td>
					</tr>
					<tr>
						<th>Issue date</th>
						<td><fmt:formatDate pattern="MM/dd/yyyy"
								value="${client.passport.dateOfIssue}" /></td>
					</tr>
					<tr>
						<th>Expiration date</th>
						<td><fmt:formatDate pattern="MM/dd/yyyy"
								value="${client.passport.dateOfExpiry}" /></td>
					</tr>
					
				</table>
			</div>
			
		</div>
		<div class="row-fluid">
			<a class="btn btn-info" href="<c:url value="/client/edit/${client.id}" />">Edit</a>
			<a class="btn btn-info" href="<c:url value="/account/${client.id}/list" />">View Accounts</a>
			<a class="btn btn-success" href="<c:url value="/account/${client.id}/open" />">Open Account</a>
			<c:if test="${client.locked}">
				<a href="<c:url value='/client/unlock/${client.id}' /> " class="btn btn-primary">Unlock client</a>
			</c:if>
			<a class="btn btn-danger pull-right" onclick="return confirm('Are you sure you want to delete client?')" href="<c:url value="/client/delete/${client.id}" />">Delete client</a>
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
