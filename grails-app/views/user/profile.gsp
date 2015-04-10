<g:applyLayout name="twoColumns">
	<head>
		<title>Perfil</title>
	</head>

	<content tag="main">
		<g:render template="navbar"/>

		<g:form action="profile" autocomplete="off">
			<div class="form-group row">
				<div class="col-xs-4">
					<g:textField name="username" value="${user?.username}" class="form-control" placeholder="Nombre de usuario" autofocus="true"/>
				</div>
			</div>

			<div class="form-group row">
				<div class="col-xs-4">
					<g:textField name="fullName" value="${user?.fullName}" class="form-control" placeholder="Nombre completo"/>
				</div>
			</div>

			<g:submitButton name="send" value="Confirmar" class="btn btn-primary"/>
		</g:form>

		<g:hasErrors bean="${user}">
			<br>
			<g:renderErrors bean="${user}"/>
		</g:hasErrors>
	</content>
</g:applyLayout>
