<g:applyLayout name="threeColumns">
	<head>
		<title>Producto</title>
	</head>

	<content tag="main">
		<g:render template="navbar"/>

		<g:if test="${products}">
			<g:each in="${products}" var="brand">
				<h4>${brand.key}</h4>

				<table class="table table-hover">
					<thead>
						<tr>
							<th width="1">Medida</th>
							<th>Presentacion</th>
						</tr>
					</thead>
					<tbody>
						<g:each in="${brand.value}" var="${p}">
							<tr>
								<td>${p.measure}</td>
								<td><bar:presentation presentation="${p.presentation}"/></td>
							</tr>
						</g:each>
					</tbody>
				</table>
			</g:each>
		</g:if>
		<g:else>
			<h4>No hay productos registrados en esta categoria</h4>
		</g:else>
	</content>

	<content tag="rightColumn">
		<g:form action="save" autocomplete="off">
			<g:hiddenField name="productType" value="${productType}"/>
			<g:render template="form"/>

			<g:submitButton name="send" value="Agregar" class="btn btn-primary btn-block"/>
		</g:form>
	</content>
</g:applyLayout>