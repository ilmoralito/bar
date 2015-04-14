package ni.com.bar

class Product {

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
