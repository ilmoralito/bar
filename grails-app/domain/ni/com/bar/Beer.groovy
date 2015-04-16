package ni.com.bar

import grails.util.Holders as h

class Beer extends Product {
	String presentation
  String measure

  static constraints = {
  	presentation blank: false, inList: h.config.ni.com.bar.presentationsAndMeasures.beer.keySet() as List, maxSize: 50
    measure blank: false, inList: h.config.ni.com.bar.presentationsAndMeasures.beer*.value.flatten() as List, maxSize: 50, validator: { measure, obj ->
    	def pams = h.config.ni.com.bar.presentationsAndMeasures.beer

    	if (Beer.findByBrandAndPresentationAndMeasure(obj.brand, obj.presentation, measure)) {
    		return "beer.measure.repeated"
    	}

    	if (!(measure in pams[obj.presentation])) {
    		return "beer.measure.notValid"
    	}
    }
  }
}
