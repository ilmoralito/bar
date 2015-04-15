package ni.com.bar

import grails.util.Holders

class Cigar extends Product {

	String measure

  static constraints = {
  	measure blank:false, unique:["brand"], inList:["10", "20"], maxSize:50
  }

}
