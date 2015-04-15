package ni.com.bar

class Beer extends Product {

	String measure
	String presentation

  static constraints = {
  	measure blank:false, inList:["1L", "12Oz", "700ml"], maxSize:50, validator:{ measure, beer ->
  		if (beer.presentation == "can" && measure == "1L") {
  			return "product.measure.notValid"
  		}
  	}
  	presentation blank:false, inList:["bottle", "can"], maxSize:50
  }

}
