<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul class="nav nav-list">
	<li class="nav-header">Info</li>
	<li><a href="<c:url value="/currency/rates/view" />">Currency exchange rates</a></li>

	 <li class="nav-header">Administrators</li>
  <li><a href="<c:url value="/admin/create" />">Create administrator</a></li>
  <li><a href="<c:url value="/admin/list" />">View administrators</a></li>
 
  <li class="nav-header">Operators</li>
  <li><a href="<c:url value="/operator/create"/>">Create operator</a></li>
  <li><a href="<c:url value="/operator/list"/>">View operators</a></li>
</ul><!-- "src/main/webapp/WEB-INF/views/tags/menu-admin.jsp" -->