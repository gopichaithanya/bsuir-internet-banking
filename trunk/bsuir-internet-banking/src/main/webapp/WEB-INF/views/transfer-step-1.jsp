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
			<li><a href="<c:url value='/main' />">Home</a> <span
				class="divider">/</span></li>
			<li><a href="<c:url value='/transfer' />">Transfer</a><span
				class="divider">/</span></li>
			<li class="active">Step 1</li>
		</ul>
	</div>
	<br>
	<div id="ratesInfo" class="span8">
		<c:choose>
			<c:when test="${fn:length(cardSelect) == 0}">
				<div class="clearfix alert alert-error ">You have no cards.
					Please contact bank operator.</div>
			</c:when>
			<c:when test="${fn:length(cardSelect) == 1}">
				<div class="clearfix alert alert-error ">You have only one
					card. You cannot transfer money.</div>
			</c:when>
			<c:otherwise>
				<h4>Select cards</h4>
				<form:form id="form" method="post" class="form span10"
					modelAttribute="transfer">
					<s:bind path="*">
						<c:if test="${status.error}">
							<div id="message" class="alert alert-error">${status.errorMessage}.</div>
						</c:if>
					</s:bind>
					<div class="control-group">
						<form:label class="control-label" path="senderCardNumber"> 
						<strong>From:</strong> <form:errors path="senderCardNumber" />
						</form:label>
						<div class="controls">
							<form:select  path="senderCardNumber" style="width:400px;" items="${cardSelect}"
								itemLabel="displayValue" itemValue="cardNumber"></form:select>
							
						</div>
					</div>
					<div class="control-group">
						<form:label class="control-label" path="receiverCardNumber"> 
						<strong>To:</strong> <form:errors path="receiverCardNumber" />
						</form:label>
						<div class="controls">
							<form:select path="receiverCardNumber" style="width:400px;" items="${cardSelect}"
								itemLabel="displayValue" itemValue="cardNumber"></form:select>
							
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<a href="<c:url value='/main'/>" class="btn">Cancel</a>
							<button type="submit" class="btn">Next</button>
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
