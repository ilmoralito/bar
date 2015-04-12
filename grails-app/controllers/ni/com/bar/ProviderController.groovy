package ni.com.bar

import grails.plugin.springsecurity.annotation.Secured

@Secured(["ROLE_ADMIN"])
class ProviderController {

	static allowedMethods = [
		index:"GET"
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
}
