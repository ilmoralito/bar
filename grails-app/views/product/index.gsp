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
							<g:if test="${productType in ['beer', 'juice', 'energy drink', 'soda']}">
								<th>Presentacion</th>
							</g:if>
						</tr>
					</thead>
					<tbody>
						<g:each in="${brand.value}" var="${p}">
							<tr>
								<td>${p.measure}</td>
								<g:if test="${productType in ['beer', 'juice', 'energy drink', 'soda']}">
									<td><bar:presentation presentation="${p.presentation}"/></td>
								</g:if>
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