<g:applyLayout name="twoColumns">
	<head>
		<title>${provider?.name}</title>
	</head>

	<content tag="main">
		<g:render template="navbar"/>

		${products.brand}
	</content>
</g:applyLayout>