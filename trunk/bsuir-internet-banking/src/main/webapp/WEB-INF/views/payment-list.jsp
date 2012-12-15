<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<c:if test="${!ajaxRequest}">
	<html>
<head>
<meta charset="utf-8" />
</head>

<body>
</c:if>
<div id="content">
	<div id="breadcumbs" class="span12">
		<ul class="breadcrumb">
			<li><a href="<c:url value='/main' />">Главная</a> <span
				class="divider">/</span></li>
			<li class="active">Платежи</li>

		</ul>
	</div>
	<br>
	<div id="ratesInfo" class="span6">
		<c:choose>
			<c:when test="${fn:length(tree) == 0}">
				<div class="clearfix alert alert-error ">На данный момент нет
					доступных платежей</div>
			</c:when>
			<c:otherwise>
				<h4>Доступные платежи</h4>

				<div class="css-treeview">
					<ul>
						<c:forEach items="${tree}" varStatus="loop" var="entry">
							<li><input type="checkbox" id="item-${loop.index}" /><label
								for="item-${loop.index}">${entry.key.name.value}</label>
								<ul>
									<c:forEach items="${entry.value}" varStatus="inloop"
										var="legal">
										<li>-<a href="<c:url value='/payment/pay/${legal.id}' />" > ${legal.name.value}</a></li>
									</c:forEach>
								</ul></li>
						</c:forEach>
					</ul>
				</div>


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
