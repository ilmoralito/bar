package ni.com.bar

import grails.util.Holders as h

class Soda extends Product {

	String presentation
	String measure

  static constraints = {
  	presentation blank: false, inList: h.config.ni.com.bar.presentationsAndMeasures.soda.keySet() as List, maxSize: 50, validator: { presentation, obj ->
  		if (Soda.findByBrandAndPresentationAndMeasure(obj.brand, presentation, obj.measure)) {
  			return "beer.measure.repeated"
  		}
  	}
  	measure blank: false, inList: h.config.ni.com.bar.presentationsAndMeasures.soda*.value.flatten() as List, maxSize: 50, validator: { measure, obj ->
  		def pams = h.config.ni.com.bar.presentationsAndMeasures.beer

  		if (!(measure in pams[obj.presentation])) {
    		return "beer.measure.notValid"
    	}
  	}
  }
}
