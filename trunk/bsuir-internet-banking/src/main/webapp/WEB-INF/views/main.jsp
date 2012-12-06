<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<body>
	<div class="row-fluid">
		<div class="span6">
			<a href="<c:url value="/currency/rates/view"/>" title="currency exchange rate"><img width="100" height="50"
				src="<c:url value="/resources/img/exchange_rate.png" />"
				alt="Currency exchange rate"></img></a> 
			<a href="<c:url value="/cards/view" />" title="my cards"><img width="100"
				height="50" src="<c:url value="/resources/img/my_cards.png" />"
				alt="My cards"></img></a> 
			<a href="#" title="payments"><img width="100" height="50"
				src="<c:url value="/resources/img/payments.png" />" alt="Payments"></img></a>
			<a href="#" title="billing"><img width="100" height="50"
				src="<c:url value="/resources/img/billing.png" />" alt="Billing"></img></a>
		</div>
		<div class="span6"></div>
	</div>

</body>
</html>