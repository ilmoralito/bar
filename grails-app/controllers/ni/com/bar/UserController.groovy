package ni.com.bar

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class UserController {
	static defaultAction = "profile"
	static allowedMethods = [
		profile:["GET", "POST"],
		password:["GET", "POST"]
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

  def password() {

  }
}
