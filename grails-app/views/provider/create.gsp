<g:applyLayout name="twoColumns">
	<head>
		<title>Proveedor</title>
	</head>

	<content tag="main">
		<g:form action="create" autocomplete="off">
			<g:render template="form"/>

			<g:submitButton name="send" value="Confirmar" class="btn btn-primary"/>
		</g:form>

		<g:hasErrors bean="${provider}">
			<br>
			<g:renderErrors bean="${provider}"/>
		</g:hasErrors>
	</content>
</g:applyLayout>