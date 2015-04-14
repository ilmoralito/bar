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
  	def brands

  	switch(productType) {
  		case "beer":
        def beers = Beer.list()

        brands = beers.brand.unique()
        products = beers.groupBy { it.brand }
  		break
      case "cigar":
        def cigars = Cigar.list()

        brands = cigars.brand.unique()
        products = cigars.groupBy { it.brand }
      break
  	}

  	[products:products, productType:productType, brands:brands]
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
