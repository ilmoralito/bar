package ni.com.bar

import grails.util.Holders as h

class Juice extends Product {

	String presentation

  static constraints = {
  	presentation blank: false, inList: h.config.ni.com.bar.presentationsAndMeasures.juice as List, maxSize: 50, validator: { presentation, obj ->
  		if (Juice.findByBrandAndPresentation(obj.brand, presentation)) {
  			return "cigar.measure.repeated"
  		}
  	}
  }
}
