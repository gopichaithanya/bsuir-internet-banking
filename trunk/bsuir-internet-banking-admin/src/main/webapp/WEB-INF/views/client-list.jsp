<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<c:if test="${!ajaxRequest}">
	<html>
<body>
</c:if>
<div id="formsContent">
	<div>
		<h3 align="left">Clients list</h3>
	</div>
	<div>
		<form:form class="form-search"  modelAttribute="searchCriteria">
			<form:input type="text" class="input-medium search-query" path="seria"/>
			<form:input type="text" class="input-medium search-query" path="number"/>
			<button type="submit" class="btn">Search</button>
		</form:form>
	</div>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>#</th>
				<th>Name</th>
				<th>Birth Date</th>
				<th>Address</th>
				<th>Phone Number</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="i" value="1" />
			<c:forEach var="clientitem" items="${clientlist}">
				<tr>
					<td><c:out value="${i}" /></td>
					<td><a href="<c:url value="/client/view/${clientitem.id}"/>"><c:out
								value="${clientitem.firstName} ${clientitem.middleName} ${clientitem.lastName}" /></a></td>
					<td>${clientitem.birthdayDate}</td>
					<td>${clientitem.address}</td>
					<td>${clientitem.phoneNumber}</td>
				</tr>
				<c:set var="i" value="${i + 1}" />
			</c:forEach>
		</tbody>
	</table>

	<div class="pagination pagination-small pagination-centered ">
		<ul>
			<c:choose>
				<c:when test="${page == 1}">
					<li class="disabled"><a href='#'>Prev</a></li>
				</c:when>
				<c:otherwise>
					<li><a href='<c:url value="/client/list/${page - 1}"/>'>Prev</a></li>
				</c:otherwise>
			</c:choose>
			<c:forEach begin="1" end="${pagecount}" var="i">
				<c:choose>
					<c:when test="${page == i}">
						<li class="active"><a
							href='<c:url value="/client/list/${i}"/>'><c:out value="${i}" /></a></li>
					</c:when>
					<c:otherwise>
						<li><a href='<c:url value="/client/list/${i}"/>'><c:out
									value="${i}" /></a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${page == pagecount}">
					<li class="disabled"><a href='#'>Next</a></li>
				</c:when>
				<c:otherwise>
					<li><a href='<c:url value="/client/list/${page + 1}"/>'>Next</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
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
