package ni.com.bar

import grails.util.Holders as h

class Cigar extends Product {
	String measure

  static constraints = {
  	measure blank:false, inList:h.config.ni.com.bar.presentationsAndMeasures.cigar*.value.flatten() as List, maxSize:50, validator: { measure, obj ->
  		if (Cigar.findByBrandAndMeasure(obj.brand, measure)) {
  			return "cigar.measure.repeated"
  		}
  	}
  }
}
