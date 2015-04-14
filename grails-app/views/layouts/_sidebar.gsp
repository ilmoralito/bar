<ul class="nav nav-pills nav-stacked">
   <li role="presentation" class="${controllerName == 'product' ? 'active' : ''}">
  	<g:link controller="product">Productos</g:link>
  </li>
  <li role="presentation" class="${controllerName == 'provider' ? 'active' : ''}">
  	<g:link controller="provider">Proveedores</g:link>
  </li>
</ul>