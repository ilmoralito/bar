<g:applyLayout name="threeColumns">
	<head>
		<title>Proveedor</title>
	</head>

	<content tag="main">
		<g:if test="${providers}">
			<h5>Proveedores</h5>

			<table class="table table-hover table-striped">
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

	<content tag="rightColumn">
		<h5>Agregra proveedor</h5>
		<g:form action="save" autocomplete="off">
			<g:render template="form"/>

			<g:submitButton name="send" value="Confirmar" class="btn btn-primary btn-block"/>
		</g:form>

		<g:hasErrors bean="${provider}">
			<br>
			<g:renderErrors bean="${provider}"/>
		</g:hasErrors>
	</content>
</g:applyLayout>