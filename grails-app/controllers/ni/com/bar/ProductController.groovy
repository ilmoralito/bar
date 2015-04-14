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

  	switch(productType) {
  		case "beer":
  			products = Beer.list()
  		break
  	}
  	[products:products, productType:productType]
  }
}
