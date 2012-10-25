<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul class="nav nav-list">
	<li class="nav-header">Info</li>
	<li><a href="<c:url value="/" />">Currency exchange rates</a></li>

	 <li class="nav-header">Administrators</li>
  <li><a href="<c:url value="/" />">Create administrator</a></li>
  <li><a href="<c:url value="/" />">View administrators</a></li>
 
  <li class="nav-header">Operators</li>
  <li><a href="<c:url value="/create-operator"/>">Create operator</a></li>
  <li><a href="<c:url value="/view-operator"/>">View operators</a></li>
</ul><!-- "src/main/webapp/WEB-INF/views/tags/menu-admin.jsp" -->