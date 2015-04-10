<g:applyLayout name="threeColumns">
	<head>
		<title>Usuarios</title>
	</head>

	<content tag="main">
		<g:if test="${users}">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Usuarios</th>
					</tr>
				</thead>
				<tbody>
					<g:each in="${users}" var="user">
						<tr>
							<td>
								<g:link action="show" params="[id:user.id]">${user.fullName}</g:link>
							</td>
						</tr>
					</g:each>
				</tbody>
			</table>
		</g:if>
	</content>

	<content tag="rightColumn">
		<g:link action="create" class="btn btn-primary btn-block">Crear usuario</g:link>

		<h4>Filtrar</h4>
		<g:form action="list">
			<h5>por estado</h5>

			<div class="checkbox">
				<label>
					<g:checkBox name="enabled" value="true" checked="${params.list('enabled')*.toBoolean().contains(true)}"/> Activos
				</label>
			</div>

			<div class="checkbox">
				<label>
					<g:checkBox name="enabled" value="false" checked="${params.list('enabled')*.toBoolean().contains(false)}"/> No activos
				</label>
			</div>

			<h5>por rol</h5>
			<g:each in="${roles}" var="role">
				<div class="checkbox">
					<label>
						<g:checkBox name="roles" value="${role.authority}" checked="${params.list('roles').contains(role.authority)}"/> ${role.authority}
					</label>
				</div>
			</g:each>

			<g:submitButton name="send" value="Filtrar" class="btn btn-info btn-block"/>
		</g:form>
	</content>
</g:applyLayout>