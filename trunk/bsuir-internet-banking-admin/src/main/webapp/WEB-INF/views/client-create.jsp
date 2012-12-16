<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<c:if test="${!ajaxRequest}">
	<html>
<body>
</c:if>
<div id="formsContent">
	<div class="span6 well">
		<form:form id="form1" method="post" class="form" action=""
			modelAttribute="client">
			<div class="control-group">
				<h4>Please enter client information</h4>
				<br>
			</div>

			<s:bind path="*">
				<c:if test="${status.error}">
					<div id="message" class="alert alert-error">Form has errors</div>
				</c:if>
			</s:bind>
			<div class="control-group">
				<div class="controls">
					<form:input path="firstName" id="inputFirstName"
						placeholder="First Name" />
					<form:errors class="help-inline" path="firstName" />
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<form:input path="middleName" id="inputMiddleName"
						placeholder="Middle Name" />
					<form:errors class="help-inline" path="middleName" />
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<form:input path="lastName" id="inputLastName"
						placeholder="Last Name" />
					<form:errors class="help-inline" path="lastName" />
				</div>
			</div>
			<div class="control-group">
				<div class="controls ">
					<form:input path="birthdayDate" id="inputBirthdayDate"
						placeholder="Birthday (dd/mm/yyyy)" readonly="true" />
					<form:errors class="help-inline" path="birthdayDate">
						<c:forEach items="${messages}" var="message" begin="1">
							<span>${message}</span>
						</c:forEach>
					</form:errors>
				</div>

			</div>

			<div class="control-group">
				<div class="controls">
					<form:input path="address" id="inputAddress" placeholder="Address" />
					<form:errors class="help-inline" path="address" />
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<form:input path="phoneNumber" id="inputPhoneNumber"
						placeholder="Phone Number" />
					<form:errors class="help-inline" path="phoneNumber" />
				</div>
			</div>
			<div class="control-group">
			<div class="controls">
				<form:input  path="email" id="inputEmail"
					placeholder="Email address" />
				<form:errors class="help-inline" path="email" />
			</div>
		</div>
			<div class="control-group">
				<div class="controls">
					<button type="submit" class="btn">Next</button>
				</div>
			</div>
		</form:form>
	</div>
	<!-- <div class="span6 well">
	
	</div> -->
</div>
<c:if test="${!ajaxRequest}">
	</body>
	</html>
</c:if>
