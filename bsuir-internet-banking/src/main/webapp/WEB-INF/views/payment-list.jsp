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
			<c:choose>
				<c:when test="${(empty auto) or (not auto) }">
					<li class="active">Платежи</li>
					</c:when>
					<c:otherwise>
					<li class="active">Автоплатежи</li>
					</c:otherwise>
					</c:choose>
		</ul>
	</div>
	<br>
	<div id="ratesInfo" class="span12">
		<c:choose>
			<c:when test="${fn:length(tree) == 0}">
				<div class="clearfix alert alert-error ">На данный момент нет
					доступных платежей</div>
			</c:when>
			<c:otherwise>
				<c:choose>
				<c:when test="${(empty auto) or (not auto) }">
				<h4>Доступные платежи</h4>
				</c:when>
				<c:otherwise>
				<h4>Выберите услугу для создания автоплатежа</h4>
				</c:otherwise>
				</c:choose>
				<div class="row">
					<div class="css-treeview span4">
						<ul>
							<c:forEach items="${tree}" varStatus="loop" var="entry">
								<li><input type="checkbox" id="item-${loop.index}" /> <label
									for="item-${loop.index}">${entry.key.name.value}</label>
									<ul>
										<c:forEach items="${entry.value}" varStatus="inloop"
											var="legal">
											<c:choose>
												<c:when test="${(empty auto) or (not auto)}">
													<li>- <a
														href="<c:url value='/payment/pay/${legal.id}' />">
															${legal.name.value}</a></li>
												</c:when>
												<c:otherwise>
													<li>- <a
														href="<c:url value='/autopayment/create?type=payment&id=${legal.id}' />">
															${legal.name.value}</a></li>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</ul></li>
							</c:forEach>
						</ul>
					</div>
					<div id="eripTree" class="span4">
						<div class="css-treeview">
							<ul>
								<li><input type="checkbox" id="root" checked="checked" />
									<label for="root">Расчет</label>
									<ul>
										<c:forEach items="${eripTree}" varStatus="loop" var="entry">
											<li><input type="checkbox" id="erip-${loop.index}" /> <label
												for="erip-${loop.index}">${entry.key.name.value}</label>
												<ul>
													<c:forEach items="${entry.value}" varStatus="loopInner"
														var="entryInner">
														<li><input type="checkbox"
															id="erip-${loop.index}-${loopInner.index}" /> <label
															for="erip-${loop.index}-${loopInner.index}">${entryInner.key.name.value}</label>
															<ul>
																<c:forEach items="${entryInner.value}"
																	varStatus="loopLeaf" var="service">
																	<c:choose>
																		<c:when test="${(empty auto) or (not auto) }">
																			<li>- <a
																				href="<c:url value='/erip/pay/${service.id}'/>">${service.name.value}</a>

																			</li>
																		</c:when>
																		<c:otherwise>
																			<li>- <a
																				href="<c:url value='/autopayment/create?type=erip&id=${service.id}'/>">${service.name.value}</a>

																			</li>
																		</c:otherwise>
																	</c:choose>
																</c:forEach>
															</ul></li>
													</c:forEach>
												</ul></li>
										</c:forEach>
									</ul></li>
							</ul>
						</div>

					</div>
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
