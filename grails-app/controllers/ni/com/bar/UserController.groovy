package ni.com.bar

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class UserController {
	static defaultAction = "profile"
	static allowedMethods = [
		profile:["GET", "POST"],
		password:["GET", "POST"],
		list:["GET", "POST"],
		create:["GET", "POST"],
		show:"GET"
	]

	def springSecurityService

  def profile() {
  	def user = springSecurityService.currentUser

  	if (request.method == "POST") {
  		user.properties["username", "fullName"] = params

  		user.save(flush:true)
  	}

  	[user:user]
  }

  @Secured(['ROLE_ADMIN'])
  def list() {
  	def users = User.list()
  	def roles = Role.list()

  	if (request.method == "POST") {
  		def roleInstances = params.list("roles")
  		def enabled = params.list("enabled")*.toBoolean()

  		if (enabled) {
  			def criteria = User.createCriteria()
  			users = criteria {
  				"in" "enabled", enabled
  			}
  		}

  		if (roleInstances) {
  			users = users.findAll { it.authorities.authority.any { roleInstances.contains it } }
  		}
  	}

  	[users:users, roles:roles]
  }

  def password(PasswordCommand cmd) {
  	def user = springSecurityService.currentUser

  	if (request.method == "POST") {
  		if (cmd.hasErrors()) {
  			return [cmd:cmd]
  		}

  		user.properties["password"] = cmd.currentPassword

  		user.save(flush:true)

  		flash.message = "Clave cambiada"
  	}
  }

  def create(CreateCommand cmd) {
  	def roles = Role.list()

  	if (request.method == "POST") {
  		if (cmd.hasErrors()) {
  			return [user:cmd, roles:roles]
  		}

  		def user = new User(username:cmd.username, fullName:cmd.fullName, password:cmd.password)

  		if (!user.save()) {
  			flash.message = "Nombre de usuario repetido"
  		} else {
	  		cmd.roles.each { role ->
	  			UserRole.create user, Role.findByAuthority(role), true
	  		}

	  		flash.message = "Usuario creado"
  		}
  	}

  	[roles:roles]
  }

  def show(Long id) {
  	def user = User.get id

  	if (!user) {
  		response.sendError 404
  	}

  	[user:user]
  }
}

class PasswordCommand {
	def springSecurityService
  def passwordEncoder

	String currentPassword
	String newPassword
	String repeatPassword

	static constraints = {
		currentPassword validator: { currentPassword, obj ->
			def user = obj.springSecurityService.currentUser

			if (!obj.passwordEncoder.isPasswordValid(user.password, currentPassword, null)) {
				return "passwordCommand.currentPassword.notMatch"
			}
		}

		newPassword validator:{ newPassword, obj ->
			if (newPassword != obj.repeatPassword) {
				return "passwordCommand.newPassword.notMatch"
			}
		}
	}
}

class CreateCommand {
	String username
	String fullName
	String password
	List<String> roles

	static constraints = {
		importFrom User
		roles validator: { roles ->
			if (!roles) {
				return "createCommand.roles.empty"
			}
		}
	}
}
