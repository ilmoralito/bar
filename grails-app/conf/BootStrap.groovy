import ni.com.bar.*
import grails.util.Environment

class BootStrap {
    def init = { servletContext ->
    	switch(Environment.current) {
    		case Environment.DEVELOPMENT:
    			def adminRole = new Role(authority:"ROLE_ADMIN").save(failOnError:true)
    			def userRole = new Role(authority:"ROLE_USER").save(failOnError:true)

    			def testAdminUser = new User(username:"admin", password:"password").save(failOnError:true)
    			def testUserUser = new User(username:"user", password:"password").save(failOnError:true)

    			UserRole.create testAdminUser, adminRole, true
    			UserRole.create testUserUser, userRole, true

    			assert User.count() == 2
    			assert Role.count() == 2
    			assert UserRole.count() == 2
    		break
    	}
    }
    def destroy = {
    }
}
