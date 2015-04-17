<ul class="nav nav-tabs">
  <li role="presentation" class="${productType == 'beer' ? 'active' : ''}">
  	<g:link action="index">Cervezas</g:link>
  </li>
  <li role="presentation" class="${productType == 'ron' ? 'active' : ''}">
  	<g:link action="index" params="[productType:'ron']">Rones</g:link>
  </li>
  <li role="presentation" class="${productType == 'water' ? 'active' : ''}">
  	<g:link action="index" params="[productType:'water']">Agua</g:link>
  </li>
  <li role="presentation" class="${productType == 'energy drink' ? 'active' : ''}">
  	<g:link action="index" params="[productType:'energy drink']">Bebidas energizantes</g:link>
  </li>
  <li role="presentation" class="${productType == 'soda' ? 'active' : ''}">
  	<g:link action="index" params="[productType:'soda']">Gaseosas</g:link>
  </li>
  <li role="presentation" class="${productType == 'juice' ? 'active' : ''}">
  	<g:link action="index" params="[productType:'juice']">Jugos</g:link>
  </li>
  <li role="presentation" class="${productType == 'cigar' ? 'active' : ''}">
  	<g:link action="index" params="[productType:'cigar']">Cigarros</g:link>
  </li>
</ul>
<br>
