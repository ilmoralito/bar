package ni.com.bar

class Provider {

	String name
	String address

  static constraints = {
  	name blank:false, unique:true
  	address blank:false, unique:true
  }

  static mapping = {
  	version false
  }

}
