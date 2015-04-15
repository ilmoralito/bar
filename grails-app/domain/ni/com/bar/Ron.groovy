package ni.com.bar

class Ron extends Product {

  static constraints = {
  	brand unique:true
  }

  static mapping = {
  	version false
  }
}
