<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<c:if test="${!ajaxRequest}">
	<html>
<body>
</c:if>
<div id="content">
	<form:form id="form" method="post" class="form span5"
		modelAttribute="rates">
		<div id="ratesInfo">
			<s:bind path="*">
				<c:if test="${status.error}">
					<div id="message" class="alert alert-error">
						<div>Form has errors</div>
						<div>
							<form:errors  path="purchaseRates[${i}].rate" />
						</div>
						<div>
							<form:errors  path="sellRates[${i}].rate" />
						</div>
					</div>

				</c:if>
			</s:bind>

			<table class="table table-bordered">
				<tr>
					<th>Currency</th>
					<th>Purchase</th>
					<th>Sell</th>
				</tr>
				<tr>
					<c:forEach var="i" begin="1" end="3" step="1">
						<tr>
							<th>${rates.purchaseRates[i].currencyType.shortName}</th>
							<td>
								<div class="control-group">
									<div class="controls" style="width: 50px">
										<form:input path="purchaseRates[${i}].rate"
											id="inputPurchaseRate" style="width:50px" />
									</div>
								</div>
							</td>
							<td>
								<div class="control-group">
									<div class="controls" style="width: 50px">
										<form:input path="sellRates[${i}].rate" id="inputSellRate"
											style="width:50px" />
									</div>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tr>
			</table>
			<div class="control-group">
				<div class="controls">
					<button type="submit" class="btn">Submit</button>
				</div>
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
