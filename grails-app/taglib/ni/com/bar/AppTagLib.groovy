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

  def presentation = { attrs ->
    def p = attrs.presentation

    if (p == "bottle") {
      out << "Botella"
    } else if (p == "can") {
      out << "Lata"
    } else {
      out << "Caja"
    }
  }
}
