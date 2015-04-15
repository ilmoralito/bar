package ni.com.bar

class Cigar extends Product {
	String measure

  static constraints = {
  	measure blank:false, inList:["10", "20"], maxSize:50
  }

}
