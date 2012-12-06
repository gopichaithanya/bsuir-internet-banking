<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<c:if test="${!ajaxRequest}">
	<html>
<body>
</c:if>
<div id="content">
	<div id="ratesInfo" class="span5">
		<table class="table table-bordered">
			<tr>
				<th>card number</th>
				<th>card type</th>
				<th>balance</th>
				<th>currency type</th>
			</tr>
			<tr>
				<c:forEach begin="0" end="${fn:length(cardList)-1}" varStatus="loop">
					<tr>
						<td>${cardList[loop.index].cardNumber}</td>
						<td>${cardList[loop.index].cardType.name}</td>
						<td>${ballance[loop.index].amount}</td>						
						<td>${ballance[loop.index].currencyType}</td>
					</tr>
				</c:forEach>
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
