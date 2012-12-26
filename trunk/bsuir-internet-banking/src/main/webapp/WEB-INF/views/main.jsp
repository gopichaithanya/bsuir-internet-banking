<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<body>
		
		<div class="span12">
		<h4>Выберите операцию</h4>
		<br>
			<a href="<c:url value="/currency/rates/view"/>" title="Курс валют"><img width="100" height="50"
				src="<c:url value="/resources/img/exchange_rate.png" />"
				alt="Курс валют"></img></a> 
			<a href="<c:url value="/cards/view" />" title="Мои карты"><img width="100"
				height="50" src="<c:url value="/resources/img/my_cards.png" />"
				alt="Мои карты"></img></a> 
			<a href="<c:url value="/payment/list"/>" title="Платежи"><img width="100" height="50"
				src="<c:url value="/resources/img/payments.png" />" alt="Платежи"></img></a>
			<a href="<c:url value="/history/payment"/>" title="История платежей"><img width="100" height="50"
				src="<c:url value="/resources/img/billing.png" />" alt="История платежей"></img></a>
		</div>
		
		<div>
					<small>Ваш последний вход в систему: <fmt:formatDate
							pattern="dd/MM/yyyy HH:mm:ss" value="${user.lasDate}" /></small>
				</div>

</body>
</html>