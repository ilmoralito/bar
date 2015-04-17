package ni.com.bar

import grails.transaction.Transactional

@Transactional
class ProductService {
	def grailsApplication

  def getMeasures(String product) {
		grailsApplication.config.ni.com.bar.presentationsAndMeasures[product]*.value?.flatten()
	}

  def getPresentations(String product) {
  	def target = grailsApplication.config.ni.com.bar.presentationsAndMeasures[product]
		target instanceof List ? target : target?.keySet()
  }
}
