<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row-fluid">
	<div class="span6">
		<h1>BSUIR Internet Banking</h1>
	</div>
	<div class="span3 pull-right">
		<span>Welcome, <c:choose>
				<c:when test="${(not empty user) && (not empty user.username)}">
					<c:out value="${user.username}"></c:out>.
				</c:when>
				<c:otherwise>guest.</c:otherwise>
		</c:choose>
		</span>
		<c:choose>
			<c:when test="${(not empty user) && (not empty user.username)}">
				<a href="<c:url value="/logout"/>" class=""><strong>Logout</strong></a>
			</c:when>
			<c:otherwise>
				<a href="<c:url value="/login"/>" class=""><strong>Login</strong></a>
			</c:otherwise>
		</c:choose>
	</div>
</div>



