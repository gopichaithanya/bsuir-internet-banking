<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
	<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>БГУИР Интернет Банкинг</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link href="<c:url value="/resources/css/css-treeview.css" />" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/resources/css/bootstrap_cerulian.min.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet"
	type="text/css" />



<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
	
}

.sidebar-nav {
	padding: 9px 0;
}
.bankingError {
 color:#D41E24;
}
</style>

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->

</head>

<body>
	<div>

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
					<div class="sidebar-nav">
						<c:choose>
							<c:when test="${user.role == 'Client' }">
								<c:import url="/WEB-INF/views/tags/menu-client.jsp" />
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
							<c:if test="${not empty success}">
							<div class="alert ">
								<button type="button" class="close" data-dismiss="alert">x</button>
								${success}
							</div>
							</c:if>
							<c:if test="${not empty error}">
							<div class="alert alert-error">
								<button type="button" class="close" data-dismiss="alert">x</button>
								${error}
							</div>
							</c:if>
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
	</div>

	<!-- Placed at the end of the document so the pages load faster -->
	<script type="text/javascript"
		src="<c:url value="/resources/js/jquery-1.8.0-min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/demo.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/json2.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/date.format.js" />"></script>
		<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap-datepicker.js" />"></script>
	<script>
		$(function(){
			window.prettyPrint && prettyPrint();
			$('#d').value = "13-02-2012";
			$('#dp3').datepicker();
						
			var startDate = new Date(2012,1,20);
			var endDate = new Date(2012,1,25);
			$('#dp4').datepicker()
				.on('changeDate', function(ev){
					if (ev.date.valueOf() > endDate.valueOf()){
						$('#alert').show().find('strong').text('The start date can not be greater then the end date');
					} else {
						$('#alert').hide();
						startDate = new Date(ev.date);
						$('#startDate').text($('#dp4').data('date'));
					}
					$('#dp4').datepicker('hide');
				});
		});
	</script>
</body>
</html>