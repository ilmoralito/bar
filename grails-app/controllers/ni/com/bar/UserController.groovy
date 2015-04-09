package ni.com.bar

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class UserController {
	static defaultAction = "profile"
	static allowedMethods = [
		profile:["GET", "POST"],
		password:["GET", "POST"],
		list:"GET"
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
