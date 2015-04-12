<g:applyLayout name="twoColumns">
	<head>
		<title>Proveedor</title>
	</head>

	<content tag="main">
		<g:link action="create" class="btn btn-primary pull-right">Crear proveedor</g:link>
		<g:if test="${providers}">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Proveedores</th>
					</tr>
				</thead>
				<tbody>
					<g:each in="${providers}" var="provider">
						<tr>
							<td>
								<g:link action="show" params="[id:provider.id]">${provider.name}</g:link>
							</td>
						</tr>
					</g:each>
				</tbody>
			</table>
		</g:if>
	</content>
</g:applyLayout>