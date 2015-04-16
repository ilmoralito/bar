package ni.com.bar

import grails.util.Holders as h

class Water extends Product {
	String measure

  static constraints = {
  	measure blank:false, inList:h.config.ni.com.bar.presentationsAndMeasures.water*.value.flatten(), maxSize:50
  }
}
