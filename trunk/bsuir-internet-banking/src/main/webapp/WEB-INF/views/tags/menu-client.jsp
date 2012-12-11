<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<ul id="client_menu" class="nav nav-list accordion pull-right">
	<div class=" well accordion-group ">

		<li class="nav-header accordion-heading accordion-heading"><a
			class="accordion-toggle" data-toggle="collapse"
			data-parent="#client_menu" href="#test">Инфо</a></li>

		<ul id="test" class="accordion-body collapse unstyled">
			<div class="accordion-inner">
				<li><a href="<c:url value="/currency/rates/view" />">Курсы обмена валют</a></li>
			</div>
		</ul>
		<li class="nav-header accordion-heading accordion-heading"><a
			class="accordion-toggle" data-toggle="collapse"
			data-parent="#client_menu" href="#test2">Личные данные</a></li>
		<ul id="test2" class="accordion-body collapse unstyled">
			<div class="accordion-inner">
				<li><a href="<c:url value="/personal/change/login" />">Изменить имя пользователя</a></li>
				<li><a href="<c:url value="/personal/change/password" />">Изменить пароль</a></li>
			</div>
		</ul>

		<li class="nav-header accordion-heading accordion-heading"><a
			class="accordion-toggle" data-toggle="collapse"
			data-parent="#client_menu" href="#menu3">Карт-счета</a></li>
		<ul id="menu3" class="accordion-body collapse unstyled">
			<div class="accordion-inner">
				<li><a href="<c:url value="/cards/view"/>">Просмотреть карт-счета</a></li>
			</div>
		</ul>

		<li class="nav-header accordion-heading accordion-heading"><a
			class="accordion-toggle" data-toggle="collapse"
			data-parent="#client_menu" href="#menu4">Платежи</a></li>
		<ul id="menu4" class="accordion-body collapse unstyled">
			<div class="accordion-inner">
				<li><a href="<c:url value="#"/>">Автоплатежи</a></li>
				<li><a href="<c:url value="#"/>">Сохраненные платежи</a></li>
				<li><a href="<c:url value="/payment/list"/>">Провести платеж</a></li>
			</div>
		</ul>

		<%-- <li class="nav-header accordion-heading accordion-heading"><a
			class="accordion-toggle" data-toggle="collapse"
			data-parent="#client_menu" href="#menu5">Billing</a></li>
		<ul id="menu5" class="accordion-body collapse unstyled">
			<div class="accordion-inner">
				<li><a href="<c:url value="#"/>">Online information</a></li>
				<li><a href="<c:url value="#"/>">wtf</a></li>
			</div>
		</ul> --%>

		<li class="nav-header accordion-heading accordion-heading"><a
			class="accordion-toggle" data-toggle="collapse"
			data-parent="#client_menu" href="#menu6">Переводы</a></li>
		<ul id="menu6" class="accordion-body collapse unstyled">
			<div class="accordion-inner">
				<li><a href="<c:url value="/transfer"/>">Переводы между картами</a></li>
			</div>
		</ul>
		
		<li class="nav-header accordion-heading accordion-heading"><a
			class="accordion-toggle" data-toggle="collapse"
			data-parent="#client_menu" href="#menu7">История операций</a></li>
		<ul id="menu7" class="accordion-body collapse unstyled">
			<div class="accordion-inner">
				<li><a href="<c:url value="/history/payment"/>">История платежей</a></li>
				<li><a href="<c:url value="/history/transfer"/>">История переводов</a></li>
			</div>
		</ul>

		<li class="nav-header accordion-heading accordion-heading">
		<a  href="<c:url value="/logout"/>">Закончить сеанс</a></li>
	</div>
</ul>
<!-- "src/main/webapp/WEB-INF/views/tags/menu-admin.jsp" -->