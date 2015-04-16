package ni.com.bar

import grails.util.Holders as h

class Beer extends Product {
	String presentation
  String measure

  static constraints = {
  	presentation blank:false, inList:h.config.ni.com.bar.presentationsAndMeasures.beer.keySet() as List, maxSize:50
    measure blank:false, inList:h.config.ni.com.bar.presentationsAndMeasures.beer*.value.flatten() as List, maxSize:50
  }
}
