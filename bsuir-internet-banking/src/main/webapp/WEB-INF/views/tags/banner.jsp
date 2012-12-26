<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<div class="row-fluid">
	<div class="span6">
		<h1>БГУИР Интернет Банкинг</h1>

	</div>
	<div class="span3 pull-right">
		<span>Добро пожаловать, <c:choose>
				<c:when test="${(not empty user) && (not empty user.name)}">
					<c:out value="${user.name}"></c:out>.
				</c:when>
				<c:otherwise>гость.</c:otherwise>
			</c:choose>
		</span>
		<c:choose>
			<c:when test="${(not empty user) && (not empty user.username)}">
				<a href="<c:url value="/logout"/>" class=""><strong>Выйти</strong></a>
				
			</c:when>
			<c:otherwise>
				<a href="<c:url value="/login"/>" class=""><strong>Войти</strong></a>
			</c:otherwise>
		</c:choose>

	</div>
</div>



