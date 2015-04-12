<g:applyLayout name="twoColumns">
	<head>
		<title>${provider?.name}</title>
	</head>

	<content tag="main">
		<g:form action="update" autocomplete="off">
			<g:hiddenField name="id" value="${provider?.id}"/>
			<g:render template="form"/>

			<g:submitButton name="send" value="Confirmar" class="btn btn-primary"/>
		</g:form>

		<g:hasErrors bean="${provider}">
			<br>
			<g:renderErrors bean="${provider}"/>
		</g:hasErrors>
	</content>
</g:applyLayout>