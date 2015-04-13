<ul class="nav nav-tabs">
  <li role="presentation">
  	<g:link action="">Productos</g:link>
  </li>
  <li role="presentation" class="${action='show' ? 'active' : ''}">
  	<g:link action="show" params="[id:provider?.id]">Editar</g:link>
  </li>
</ul>
<br>