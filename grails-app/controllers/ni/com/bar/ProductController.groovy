package ni.com.bar

import grails.plugin.springsecurity.annotation.Secured

@Secured(["ROLE_ADMIN"])
class ProductController {

  static methodAlloweds = [
    index:"GET",
    save:"POST",
    delete:"GET"
  ]

  def grailsApplication
  def productService

  def index() {
    def productType = params?.productType ?: "beer"
    def p = [beer: Beer, ron: Ron, water: Water, energyDrink: EnergyDrink, soda: Soda, juice: Juice, cigar: Cigar]

  	def products = p[productType].list()

  	[
      products: productType != "ron" ? products.groupBy { it.brand } : products,
      productType:productType,
      brands:products?.brand?.unique(),
      measures:productService.getMeasures(productType),
      presentations:productService.getPresentations(productType),
      productsWithMeasure:['beer', 'cigar', 'water', 'soda'],
      productsWithPresentations:['beer', 'soda', 'juice', 'energyDrink']
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

      case "water":
        product = new Water(params)
      break

      case "energyDrink":
        product = new EnergyDrink(params)
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

  def delete(Long id, String productType) {
    def product = Product.get id

    if (!product) {
      response.sendError 404
    }

    product.delete flush:true

    redirect action:"index", params:[productType:productType]
  }
}
