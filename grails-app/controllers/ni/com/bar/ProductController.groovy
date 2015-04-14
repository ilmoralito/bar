package ni.com.bar

import grails.plugin.springsecurity.annotation.Secured

@Secured(["ROLE_ADMIN"])
class ProductController {

	static methodAlloweds = [
		index:"GET"
	]

  def index() {
  	def products
  	def productType = params?.productType ?: "beer"
  	def brands = {
  		if (productType == "beer") {
  			return Beer.list().brand.unique()
  		}
  	}

  	switch(productType) {
  		case "beer":
  			products = Beer.list().groupBy { it.brand }
  		break
  	}

  	[products:products, productType:productType, brands:brands.call()]
  }

  def save(String productType) {
  	def beer = new Beer(params)

  	if (!beer.save()) {
  		flash.message = "A ocurrido un error"
  		beer.errors.allErrors.each { err ->
  			log.error "[field:$err.field, message:$err.defaultMessage]"
  		}
  	} else {
  		flash.message = "Agregado correctamente"
  	}


  	redirect action:"index", params:[productType:productType]
  }
}
