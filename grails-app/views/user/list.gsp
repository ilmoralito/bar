<g:applyLayout name="threeColumns">
	<head>
		<title>Usuarios</title>
	</head>

	<content tag="main">
		<h4>Usuarios</h4>

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
							<td>${user.fullName}</td>
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
					<g:checkBox name="enabled" value="true" checked="false"/> Activos
				</label>
			</div>

			<div class="checkbox">
				<label>
					<g:checkBox name="enabled" value="true" checked="false"/> No activos
				</label>
			</div>

			<h5>por rol</h5>
			<g:each in="${roles}" var="rol">
				<div class="checkbox">
					<label>
						<g:checkBox name="roles" value="${rol.authority}" checked="false"/> ${rol.authority}
					</label>
				</div>
			</g:each>

			<g:submitButton name="send" value="Filtrar" class="btn btn-info btn-block"/>
		</g:form>
	</content>
</g:applyLayout>