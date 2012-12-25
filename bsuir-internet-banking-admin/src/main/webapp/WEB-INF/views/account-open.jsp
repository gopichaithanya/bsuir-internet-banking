<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<c:if test="${!ajaxRequest}">
	<html>
<body>
</c:if>
<div id="formsContent">
	<form:form id="form" name="form" method="post" class="form span8 well"
		modelAttribute="account_card">
		<div class="control-group">
			<h4>Open account for ${client.firstName} ${client.middleName} ${client.lastName}</h4>
			<br>
		</div>
		
		<s:bind path="*">
			<c:if test="${status.error}">
				<div id="message" class="alert alert-error">Form has errors</div>
			</c:if>
		</s:bind>
		<div class="control-group">
			<div class="controls">
				<form:select path="currencyTypeId" id="inputCurrency" items="${currencyTypes}" itemLabel="shortName" itemValue="id" />
				<form:errors class="help-inline" path="currencyType" />
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<form:select path="cardTypeId" id="inputCardType" items="${cardTypes}" itemLabel="name" itemValue="id"/>
				<form:errors class="help-inline" path="cardType" />
			</div>
		</div>
		<div class="control-group">
			<%-- <form:label class="control-label" path="lastName"> 
						Last Name <form:errors path="lastName" />
			</form:label> --%>
			<div class="controls">
				<form:input path="secretWord" id="inputSecretWord"
					placeholder="Secret Word" />
				<form:errors class="help-inline" path="secretWord" />
			</div>
		</div>
		<!-- code for expiration date -->
		<div class="control-group">
			<div class="controls">
				<button type="submit" onclick="this.disabled=true;document.form.submit();" class="btn">Submit</button>
			</div>
		</div>
	</form:form>
	
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
