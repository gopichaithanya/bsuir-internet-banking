<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<c:if test="${!ajaxRequest}">
	<html>
<body>
</c:if>
<div id="content">
	<div id="breadcumbs" class="span12">
		<ul class="breadcrumb">
			<li><a href="<c:url value='/main' />">Главная</a> <span class="divider">/</span></li>
			<li class="active">Просмотреть курсы обмена валют</li>
			
		</ul>
	</div>
	<div id="ratesInfo" class="span5">
		<table class="table table-bordered">
			<tr>
				<th>Наим. валюты</th>
				<th>Покупка</th>
				<th>Продажа</th>
			</tr>
			<tr>
				<c:forEach var="i" begin="1" end="3" step="1">
					<tr>
						<th>${purchaseRates[i].currencyType.shortName}</th>
						<td>${purchaseRates[i].rate}</td>
						<td>${sellRates[i].rate}</td>
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
