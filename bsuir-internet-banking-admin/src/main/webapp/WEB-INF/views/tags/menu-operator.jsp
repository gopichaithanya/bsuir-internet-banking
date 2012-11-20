<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul class="nav nav-list">
	<li class="nav-header">Info</li>
	<li><a href="<c:url value="/" />">Currency exchange rates</a></li>

	<li class="nav-header">Accounts</li>
	<li><a href="<c:url value="/client/create/common" />">Create client</a></li>
	<%-- <li><a href="<c:url value="/account/create" />">Create account</a></li> --%>
</ul>