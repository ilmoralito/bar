<g:applyLayout name="twoColumns">
	<head>
		<title>Usuarios</title>
	</head>

	<content tag="main">
		<g:link action="list">Regresar</g:link>
		<br><br>

		<g:form action="create" autocomplete="off">
			<div class="form-group row">
				<div class="col-xs-4">
					<g:textField name="username" value="${user?.username}" class="form-control" placeholder="Nombre de usuario"/>
				</div>
			</div>

			<div class="form-group row">
				<div class="col-xs-4">
					<g:textField name="fullName" value="${user?.fullName}" class="form-control" placeholder="Nombre completo"/>
				</div>
			</div>

			<div class="form-group row">
				<div class="col-xs-4">
					<g:passwordField name="password" value="${user?.password}" class="form-control" placeholder="Clave"/>
				</div>
			</div>

			<div class="form-group">
				<g:each in="${roles}" var="role">
					<div class="checkbox">
						<label>
							<g:checkBox name="roles" value="${role.authority}" checked="${user?.roles?.contains(role.authority) ? true : false}"/> ${role.authority}
						</label>
					</div>
				</g:each>
			</div>

			<button type="submit" class="btn btn-primary">Confirmar</button>
		</g:form>

		<g:hasErrors bean="${user}">
			<br>
			<g:renderErrors bean="${user}"/>
		</g:hasErrors>
	</content>
</g:applyLayout>