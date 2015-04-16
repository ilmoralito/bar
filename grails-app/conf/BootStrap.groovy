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

        //PRODUCTS
        //beers
        def tona12Oz = new Beer(brand:"Tona", measure:"12Oz", presentation:"Botella").save(failOnError:true)
        def tonaLitro = new Beer(brand:"Tona", measure:"1L", presentation:"Botella").save(failOnError:true)
        def tonaLata700Ml = new Beer(brand:"Tona", measure:"700ml", presentation:"Lata").save(failOnError:true)

        assert Beer.count() == 3

        //cigars
        def belmont10 = new Cigar(brand:"Belmont", measure:"10und").save(failOnError:true)
        def belmont20 = new Cigar(brand:"Belmont", measure:"20und").save(failOnError:true)
        def winsor = new Cigar(brand:"Winsor", measure:"10und").save(failOnError:true)

        assert Cigar.count() == 3

        //juices
        def valle1 = new Juice(brand:"Valle", presentation:"Botella").save(failOnError:true)
        def valle2 = new Juice(brand:"Valle", presentation:"Lata").save(failOnError:true)
        def valle3 = new Juice(brand:"Valle", presentation:"Caja").save(failOnError:true)

        assert Juice.count() == 3

        //rones
        def extraLite = new Ron(brand:"Extra lite").save(failOnError:true)
        def ronPlata = new Ron(brand:"Ron plata").save(failOnError:true)
        def ultraLight = new Ron(brand:"ultra light").save(failOnError:true)

        assert Ron.count() == 3

        //sodas
        def coca12Oz = new Soda(brand:"coca cola", measure:"12Oz", presentation:"Botella").save(failOnError:true)

        assert Soda.count() == 1

        //water
        def alpina12Oz = new Water(brand:"Aplina", measure:"12Oz").save(failOnError:true)
        def alpina05l = new Water(brand:"Aplina", measure:"1/2L").save(failOnError:true)
        def alpina1l = new Water(brand:"Aplina", measure:"1L").save(failOnError:true)

        assert Water.count() == 3
  		break
  	}
  }
  def destroy = {
  }
}
