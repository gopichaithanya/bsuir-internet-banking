<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<c:if test="${!ajaxRequest}">
	<html>
<body>
</c:if>
<div id="formsContent">
	<div id="adminInfo" class="well">
		<c:choose>
			<c:when test="${not empty error}">
				<p class="text-error">${error}</p>
			</c:when>
			<c:when test="${not empty admin}">
				<dl class="dl-horizontal">
					<dt>Login</dt>
					<dd>
						<c:out value="${admin.login}" />
					</dd>
					<dt>First name</dt>
					<dd>
						<c:out value="${admin.firstName}" />
					</dd>
					<dt>Middle name</dt>
					<dd>
						<c:out value="${admin.middleName}" />
					</dd>
					<dt>Last name</dt>
					<dd>
						<c:out value="${admin.lastName}" />
					</dd>
				</dl>
				<div id="adminButtons">
					<a href="<c:url value="/admin/edit/${admin.id}" />" class="btn">Edit</a>
					<a href="<c:url value="/admin/delete/${admin.id}" />" class="btn">Delete</a>
				</div>
			</c:when>
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
