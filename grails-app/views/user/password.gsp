<g:applyLayout name="twoColumns">
	<head>
		<title>Clave</title>
	</head>

	<content tag="main">
		<g:render template="navbar"/>

		<g:form action="password" autocomplete="off">
			<div class="form-group">
				<g:passwordField name="currentPassword" class="form-control" placeholder="Clave actual" autofocus="true"/>
			</div>

			<div class="form-group">
				<g:passwordField name="newPassword" class="form-control" placeholder="Nueva clave"/>
			</div>

			<div class="form-group">
				<g:passwordField name="repeatPassword" class="form-control" placeholder="Repetir nueva clave"/>
			</div>

			<g:submitButton name="send" value="Confirmar" class="btn btn-primary"/>
		</g:form>

		<g:hasErrors bean="${cmd}">
			<br>
			<g:renderErrors bean="${cmd}"/>
		</g:hasErrors>
	</content>
</g:applyLayout>
