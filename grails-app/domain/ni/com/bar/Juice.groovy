package ni.com.bar

import grails.util.Holders as h

class Juice extends Product {

	String presentation

  static constraints = {
  	presentation blank:false, inList:h.config.ni.com.bar.presentationsAndMeasures.juice.keySet() as List, maxSize:50
  }
}
