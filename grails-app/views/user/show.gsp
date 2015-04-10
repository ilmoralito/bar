<g:applyLayout name="twoColumns">
	<head>
		<title>Usuarios</title>
	</head>

	<content tag="main">
		<g:link action="list">Regresar</g:link>
		<br><br>

		<h4>Nombre de usuario</h4>
		<p>${user?.username}</p>

		<h4>Nombre completo</h4>
		<p>${user?.fullName}</p>

		<h4>Roles</h4>
		<p>${user?.authorities.authority.join(", ")}</p>

		<h4>Estado</h4>
		<p><bar:isEnabled enabled="${user?.enabled}"/></p>
	</content>
</g:applyLayout>