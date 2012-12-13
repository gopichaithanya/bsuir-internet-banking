<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>BSUIR Internet Banking</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link href="<c:url value="/resources/css/bootstrap_spacelab.min.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/jquery-ui-1.9.2.custom.min.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet"
	type="text/css" />
	<link href="<c:url value="/resources/css/datepicker.css" />" rel="stylesheet"
	type="text/css" />

<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}
</style>

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->

</head>


<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<c:import url="/WEB-INF/views/tags/navbar.jsp" />
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3">
				<div id="logo" align="center">
					<img src="<c:url value="/resources/img/bguir_logo.jpg" />"
						alt="Logo">
				</div>
			</div>
			<div class="span9">
				<div class="page-header">
					<c:import url="/WEB-INF/views/tags/banner.jsp" />
				</div>
			</div>
		</div>
		<div class="row-fluid">
			<div class="span3">
				<div class="well sidebar-nav">
					<c:choose>
						<c:when test="${user.role == 'Administrator' }">
							<c:import url="/WEB-INF/views/tags/menu-admin.jsp" />
						</c:when>
						<c:when test="${user.role == 'Operator' }">
							<c:import url="/WEB-INF/views/tags/menu-operator.jsp" />
						</c:when>
						<c:otherwise>
							<c:import url="/WEB-INF/views/tags/menu-unauthorized.jsp" />
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<div class="span9">
				<div class="row-fluid">
					<div class="span12">
						<decorator:body />
					</div>
				</div>
			</div>
		</div>
		<!--/span-->
	</div>
	<!--/row-->

	<hr>

	<footer>
		<c:import url="/WEB-INF/views/tags/footer.jsp" />
	</footer>

<!-- Placed at the end of the document so the pages load faster -->
	<script type="text/javascript"
		src="<c:url value="/resources/js/jquery-1.8.0-min.js" />"></script>
	<%--<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/demo.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/json2.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/date.format.js" />"></script>
		<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap-datepicker.js" />"></script> --%>
	<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-ui.js" />"></script>
	<script>
		$(function(){
			//$('#inputBirthdayDate').datapicker( { date-format: "dd/mm/yy"  })
			$('#inputBirthdayDate').datepicker( { dateFormat: "dd/mm/yy",
				showOn: 'button',
				buttonImage: "/resources/img/calendar.gif",
	            buttonImageOnly: true,
				minDate: '-120Y',
				maxDate: '-18Y',
				changeMonth: true, 
				changeYear: true});
			$('#inputDateOfExpiry').datepicker( { dateFormat: "dd/mm/yy",
				showOn: 'button',
				buttonImage: "/resources/img/calendar.gif",
	            buttonImageOnly: true,
				minDate: '+1M',
				maxDate: '+50Y',
				changeMonth: true, 
				changeYear: true});
			$('#inputDateOfIssue').datepicker( { dateFormat: "dd/mm/yy",
				showOn: 'button',
				buttonImage: "/resources/img/calendar.gif",
	            buttonImageOnly: true,
				minDate: '-50Y',
				maxDate: '+0D',
				changeMonth: true, 
				changeYear: true});

		});
	</script>
</body>
</html>