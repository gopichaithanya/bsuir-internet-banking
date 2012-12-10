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
			<li><a href="<c:url value='/main' />">Home</a> <span class="divider">/</span></li>
			<li class="active">View Cards</li>
			
		</ul>
	</div>
	<br>
	<div id="ratesInfo" class="span8">
		<c:choose>
			<c:when test="${fn:length(accountlist) == 0}">
				<div class="clearfix alert alert-warning ">This client has no accounts. <span><a href="<c:url value='/account/${clientId}/open'/> " class="btn pull-right">Open account</a></span></div>
			</c:when>
			<c:otherwise>
				<h4>My cards</h4>
				<table class="table table-hover">
					<tr>
						<th>#</th>
						<th>Card Number</th>
						<th>Card Type</th>
						<th>Ballance</th>
						<th>Currency</th>
						<th>Expiration Date</th>
						<th>Status</th>
						<th>Secret Word</th>
					</tr>
					<tr>
						<c:forEach begin="0" end="${fn:length(accountlist)-1}"
							varStatus="loop">
							<c:choose>
							<c:when test="${accountlist[loop.index].expired}">
							<tr class="error">
								<td>${loop.index + 1}</td>
								<td><a href="<c:url value='/account/${clientId}/view/${accountlist[loop.index].accountId }' />" >${accountlist[loop.index].hiddenNumber}</a></td>
								<td>${accountlist[loop.index].cardType.name}</td>
								<td>${accountlist[loop.index].amount}</td>
								<td>${accountlist[loop.index].currencyType.shortName}</td>
								<td><fmt:formatDate pattern="MM/dd/yyyy" value="${accountlist[loop.index].expirationDate}" /></td>
								<td>${accountlist[loop.index].status}</td>
								<td>${accountlist[loop.index].secretWord}</td>
								
							</tr>
							</c:when>
							<c:otherwise>
							<tr>
								<td>${loop.index + 1}</td>
								<td><a href="<c:url value='/account/${clientId}/view/${accountlist[loop.index].accountId }' />" >${accountlist[loop.index].hiddenNumber}</a></td>
								<td>${accountlist[loop.index].cardType.name}</td>
								<td>${accountlist[loop.index].amount}</td>
								<td>${accountlist[loop.index].currencyType.shortName}</td>
								<td><fmt:formatDate pattern="MM/dd/yyyy" value="${accountlist[loop.index].expirationDate}" /></td>
								<td>${accountlist[loop.index].status}</td>
								<td>${accountlist[loop.index].secretWord}</td>
							</tr>
							</c:otherwise>
							</c:choose>
						</c:forEach>
					</tr>
				</table>
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
