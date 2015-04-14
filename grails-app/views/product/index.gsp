<g:applyLayout name="threeColumns">
	<head>
		<title>Producto</title>
	</head>

	<content tag="main">
		<g:render template="navbar"/>

		${products}
	</content>

	<content tag="rightColumn">
		<g:link action="create" class="btn btn-primary btn-block">Crear</g:link>
	</content>
</g:applyLayout>