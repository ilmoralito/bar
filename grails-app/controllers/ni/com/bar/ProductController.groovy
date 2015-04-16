package ni.com.bar

import grails.plugin.springsecurity.annotation.Secured

@Secured(["ROLE_ADMIN"])
class ProductController {

  static methodAlloweds = [
    index:"GET"
  ]

  def grailsApplication
  def productService

  def index() {
  	def products
  	def productType = params?.productType ?: "beer"
  	def brands
    def measures = []
    def presentations = []

  	switch(productType) {
  		case "beer":
        def beers = Beer.list()

        brands = beers.brand.unique()
        products = beers.groupBy { it.brand }
  		break

      case "ron":
        def rones = Ron.list()

        products = rones
      break

      case "soda":
        def sodas = Soda.list()

        brands = sodas.brand.unique()
        products = sodas.groupBy { it.brand }
      break

      case "juice":
        def juices = Juice.list()

        brands = juices.brand.unique()
        products = juices.groupBy { it.brand }
      break

      case "cigar":
        def cigars = Cigar.list()

        brands = cigars.brand.unique()
        products = cigars.groupBy { it.brand }
      break
  	}

  	[
      products:products,
      productType:productType,
      brands:brands,
      measures:productService.getMeasures(productType),
      presentations:productService.getPresentations(productType),
      productsWithMeasure:['beer', 'cigar', 'water', 'soda'],
      productsWithPresentations:['beer', 'soda', 'juice', 'energy drink']
    ]
  }

  def save(String productType) {
  	def product

    switch(productType) {
      case "beer":
        product = new Beer(params)
      break

      case "ron":
        product = new Ron(params)
      break

      case "soda":
        product = new Soda(params)
      break

      case "juice":
        product = new Juice(params)
      break

      case "cigar":
        product = new Cigar(params)
      break
    }

  	if (!product.save()) {
  		flash.message = "A ocurrido un error"
  		product.errors.allErrors.each { err ->
  			log.error "[field:$err.field, message:$err.defaultMessage]"
  		}
  	} else {
  		flash.message = "Agregado correctamente"
  	}


  	redirect action:"index", params:[productType:productType]
  }
}
