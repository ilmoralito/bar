<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title><g:layoutTitle default="Grails"/></title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<asset:stylesheet src="application.css"/>
	<g:layoutHead/>
</head>
<body>
	<sec:ifLoggedIn>
		<g:render template="/layouts/navbar"/>
	</sec:ifLoggedIn>

	<div class="container">
		<div class="row">
			<g:layoutBody/>
			<asset:javascript src="application.js"/>
		</div>
	</div>
</body>
</html>
