package ni.com.bar

import grails.util.Holders

class Soda extends Product {

	String measure
	String presentation

  static constraints = {
  	measure blank:false, inList:Holders.config.ni.com.bar.measures.soda as List, maxSize:50
  	presentation blank:false, inList:Holders.config.ni.com.bar.presentations.beers as List
  }
}
