package ni.com.bar

import org.grails.databinding.BindUsing

class Product {

	@BindUsing({obj, source ->
    source["brand"]?.capitalize()
  })
	String brand

	Date dateCreated
	Date lastUpdated

  static constraints = {
  	brand blank:false
  }

  static mapping = {
  	version false
  }

}
