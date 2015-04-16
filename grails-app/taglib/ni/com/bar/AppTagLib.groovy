package ni.com.bar

class AppTagLib {
  static defaultEncodeAs = [taglib:'html']
  static namespace = "bar"
  //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

  def isEnabled = { attrs ->
  	if (attrs.enabled) {
  		out << "Activo"
  	} else {
  		out << "Inactivo"
  	}
  }
}
