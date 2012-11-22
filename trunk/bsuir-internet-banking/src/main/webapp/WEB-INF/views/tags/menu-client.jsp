<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul class="nav nav-list" >
	<li class="nav-header"><a href="<c:url value="/" />" data-toggle="collapse">Info</a></li>
	<ul>
		<li><a href="<c:url value="/" />">Currency exchange rates</a></li>
	</ul>
	<!-- <button type="button" class="btn btn-danger" data-toggle="collapse" data-target="demo">simple</button><div id="demo" class="collapse in">jfgdjkf</div>
 -->
	<li class="nav-header"><a href="<c:url value="/" />">Personal data</a></li>
	<ul>
		<li><a href="<c:url value="/administrator/create" />">Change login</a></li>
		<li><a href="<c:url value="/administrator/list" />">Change password</a></li>
	</ul>

	<li class="nav-header"><a href="<c:url value="/" />">My cards</a></li>
	<ul>
		<li><a href="<c:url value="/operator/create"/>">Create
				operator</a></li>
		<li><a href="<c:url value="/operator/list"/>">View operators</a></li>
	</ul>
	<li class="nav-header"><a href="<c:url value="/" />">Payments</a></li>
	<ul>
		<li><a href="<c:url value="#"/>">Auto payments</a></li>
		<li><a href="<c:url value="#"/>">Saved payments</a></li>
	</ul>
	<li class="nav-header"><a href="<c:url value="/" />">Billing</a></li>
	<ul>
		<li><a href="<c:url value="#"/>">Auto payments</a></li>
		<li><a href="<c:url value="#"/>">Saved payments</a></li>
	</ul>
	<li class="nav-header"><a href="<c:url value="/" />">Transfer</a></li>
	<ul>
		<li><a href="<c:url value="#"/>">Auto payments</a></li>
		<li><a href="<c:url value="#"/>">Saved payments</a></li>
	</ul>
	<li class="nav-header"><a href="<c:url value="/" />">Log out</a></li>
</ul>
<!-- "src/main/webapp/WEB-INF/views/tags/menu-admin.jsp" -->