package ni.com.bar

import grails.plugin.springsecurity.annotation.Secured

@Secured(["ROLE_ADMIN"])
class ProviderController {

	static allowedMethods = [
    index:"GET",
		save:"POST",
    show:"GET",
    update:"POST"
	]

  def index() {
    def providers = Provider.list()

    [providers:providers]
   }

  def save() {
   	def provider = new Provider(params)

   	if (!provider.save()) {
   		chain action:"index", model:[provider:provider]
      return
   	}

    flash.message = "Proveedor creado"
    redirect action:"index"
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
