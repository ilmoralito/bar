import ni.com.bar.*
import grails.util.Environment

class BootStrap {
  def init = { servletContext ->
  	switch(Environment.current) {
  		case Environment.DEVELOPMENT:
  			def adminRole = new Role(authority:"ROLE_ADMIN").save(failOnError:true)
  			def userRole = new Role(authority:"ROLE_USER").save(failOnError:true)

  			def testAdminUser = new User(username:"admin", fullName:"fullName", password:"password").save(failOnError:true)
        def testUserUser = new User(username:"user", fullName:"another fullName", password:"password").save(failOnError:true)
  			def testUser = new User(username:"test", fullName:"fullName enabled false", password:"password", enabled:false).save(failOnError:true)

  			UserRole.create testAdminUser, adminRole, true
        UserRole.create testUserUser, userRole, true
  			UserRole.create testUser, userRole, true

        assert Role.count() == 2
  			assert User.count() == 3
  			assert UserRole.count() == 3

        //providers
        def provider1 = new Provider(name:"Cerveceria de Nicaragua", address:"Entrada a leon carretera Chinandega KM 45").save(failOnError:true)
        def provider2 = new Provider(name:"Ron", address:"Chinandega KM 8787").save(failOnError:true)

        assert Provider.count() == 2
  		break
  	}
  }
  def destroy = {
  }
}
