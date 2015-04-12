<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">${grails.util.Metadata.current.'app.name'}</a>
    </div>

    <ul class="nav navbar-nav navbar-right">
      <!--<li><a href="#">Link</a></li>-->
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
          <sec:loggedInUserInfo field="fullName"/> <span class="caret"></span>
        </a>
        <ul class="dropdown-menu" role="menu">
          <li class="${actionName in ['profile', 'password'] ? 'active' : ''}">
            <g:link controller="user">Perfil</g:link>
          </li>
          <sec:ifAllGranted roles="ROLE_ADMIN">
            <li class="${controllerName == 'user' && actionName == 'list' ? 'active' : ''}">
              <g:link controller="user" action="list">Usuarios</g:link>
            </li>
          </sec:ifAllGranted>
          <li class="divider"></li>
          <li><g:link controller="logout">Salir</g:link></li>
        </ul>
      </li>
    </ul>
  </div>
</nav>