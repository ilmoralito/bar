package ni.com.bar

import grails.util.Holders as h

class EnergyDrink extends Product {
	String presentation

  static constraints = {
  	presentation blank: false, inList: h.config.ni.com.bar.presentationsAndMeasures.energyDrink, maxSize: 50, validator: { presentation, obj ->
  		if (EnergyDrink.findByBrandAndPresentation(obj.brand, presentation)) {
  			return "energyDring.presentation.notValid"
  		}
  	}
  }
}
