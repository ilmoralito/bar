package ni.com.bar

class Cigar extends Product {
	String measure

  static constraints = {
  	measure blank:false, unique:["brand"], inList:["10", "20"], maxSize:50
  }

}
