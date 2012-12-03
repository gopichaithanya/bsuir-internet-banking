<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul id="client_menu" class="nav nav-list accordion ">
	<div class=" well accordion-group">

		<li class="nav-header accordion-heading accordion-heading"><a
			class="accordion-toggle" data-toggle="collapse"
			data-parent="#client_menu" href="#test">Info</a></li>

		<ul id="test" class="accordion-body collapse">
			<div class="accordion-inner">
				<li><a href="<c:url value="/currency/rates/view" />">Currency exchange rates</a></li>
			</div>
		</ul>
		<li class="nav-header accordion-heading accordion-heading"><a
			class="accordion-toggle" data-toggle="collapse"
			data-parent="#client_menu" href="#test2">Personal data</a></li>
		<ul id="test2" class="accordion-body collapse">
			<div class="accordion-inner">
				<li><a href="<c:url value="/personal/change/login" />">Change
						login</a></li>
				<li><a href="<c:url value="/personal/change/password" />">Change
						password</a></li>
			</div>
		</ul>

		<li class="nav-header accordion-heading accordion-heading"><a
			class="accordion-toggle" data-toggle="collapse"
			data-parent="#client_menu" href="#menu3">My cards</a></li>
		<ul id="menu3" class="accordion-body collapse">
			<div class="accordion-inner">
				<li><a href="<c:url value="/cards/view"/>">View cards</a></li>
			</div>
		</ul>

		<li class="nav-header accordion-heading accordion-heading"><a
			class="accordion-toggle" data-toggle="collapse"
			data-parent="#client_menu" href="#menu4">Payments</a></li>
		<ul id="menu4" class="accordion-body collapse">
			<div class="accordion-inner">
				<li><a href="<c:url value="#"/>">Auto payments</a></li>
				<li><a href="<c:url value="#"/>">Saved payments</a></li>
				<li><a href="<c:url value="#"/>">Pay something</a></li>
			</div>
		</ul>

		<li class="nav-header accordion-heading accordion-heading"><a
			class="accordion-toggle" data-toggle="collapse"
			data-parent="#client_menu" href="#menu5">Billing</a></li>
		<ul id="menu5" class="accordion-body collapse">
			<div class="accordion-inner">
				<li><a href="<c:url value="#"/>">Online information</a></li>
				<li><a href="<c:url value="#"/>">wtf</a></li>
			</div>
		</ul>

		<li class="nav-header accordion-heading accordion-heading"><a
			class="accordion-toggle" data-toggle="collapse"
			data-parent="#client_menu" href="#menu6">Transfer</a></li>
		<ul id="menu6" class="accordion-body collapse">
			<div class="accordion-inner">
				<li><a href="<c:url value="#"/>">Transfer between</a></li>
				<li><a href="<c:url value="#"/>">i don't know</a></li>
			</div>
		</ul>

		<li class="nav-header accordion-heading accordion-heading">
		<a  href="<c:url value="/logout"/>">Log out</a></li>
	</div>
</ul>
<!-- "src/main/webapp/WEB-INF/views/tags/menu-admin.jsp" -->