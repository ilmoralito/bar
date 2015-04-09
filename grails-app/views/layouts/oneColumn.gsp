<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="layout" content="main"/>
	<title><g:layoutTitle/></title>
	<g:layoutHead/>
</head>
<body>
	<div class="col-md-4 col-md-offset-4">
		<g:pageProperty name="page.main"/>

		<g:if test="${flash.message}">
			<br>
			${flash.message}
		</g:if>
	</div>
</body>
</html>