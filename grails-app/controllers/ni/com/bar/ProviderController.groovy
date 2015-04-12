package ni.com.bar

import grails.plugin.springsecurity.annotation.Secured

@Secured(["ROLE_ADMIN"])
class ProviderController {

	static allowedMethods = [
		index:"GET",
		create:["GET", "POST"]
	]

   def index() {
   	def providers = Provider.list()

   	[providers:providers]
   }

   def create() {
   	if (request.method == "POST") {
   		def provider = new Provider(params)

   		if (!provider.save()) {
   			return [provider:provider]
   		}

   		flash.message = "Proveedor creado"
   	}
   }

   def show(Provider provider) {
   	if (!provider) {
   		response.sendError 404
   	}

   	[provider:provider]
   }

   def update(Provider provider) {
   	if (!provider) {
   		response.sendError 404
   	}

   	provider.properties["name", "address"] = params

   	flash.message = (!provider.save(flush:true)) ? "A ocurrido un error" : "Actualizacion completada"

   	redirect action:"show", params:[id:provider.id]
   }
}
