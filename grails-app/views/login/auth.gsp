<g:applyLayout name="oneColumn">
	<head>
		<title>Login</title>
		<asset:stylesheet src="application.css"/>
	</head>

	<content tag="main">
		<h4>${grails.util.Metadata.current.'app.name'}</h4>
		<form action='${postUrl}' method='POST' id='loginForm' class='cssform' autocomplete='off'>
			<div class="form-group">
				<input type='text' class='text_ form-control' name='j_username' id='username' placeholder="<g:message code='springSecurity.login.username.label'/>" autofocus="true"/>
			</div>

			<div class="form-group">
				<input type='password' class='text_ form-control' name='j_password' id='password' placeholder="<g:message code="springSecurity.login.password.label"/>"/>
			</div>

			<input type='submit' id="submit" value='${message(code: "springSecurity.login.button")}' class="btn btn-primary"/>
		</form>
	</content>
</g:applyLayout>
