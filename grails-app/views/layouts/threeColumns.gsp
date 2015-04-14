<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="layout" content="main"/>
	<title><g:layoutTitle/></title>
	<g:layoutHead/>
</head>
<body>
	<div class="col-md-2">
		<g:render template="/layouts/sidebar"/>
	</div>

	<div class="col-md-8">
		<g:pageProperty name="page.main"/>
	</div>

	<div class="col-md-2">
		<g:pageProperty name="page.rightColumn"/>

		<g:if test="${flash.message}">
			<br>
			${flash.message}
		</g:if>
	</div>
</body>
</html>