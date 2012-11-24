<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul class="nav nav-list">
	<li class="nav-header">Currency exchange rates</li>
	<li><a href="<c:url value="/currency/rates/view" />">View rates</a></li>
	<li><a href="<c:url value="/currency/rates/set" />">Set rates</a></li>

	<li class="nav-header">Accounts</li>
	<li><a href="<c:url value="/client/create/common" />">Create client</a></li>
	<li><a href="<c:url value="/client/list" />">View clients</a></li>
	<%-- <li><a href="<c:url value="/account/create" />">Create account</a></li> --%>
</ul>