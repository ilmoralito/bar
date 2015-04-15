package ni.com.bar

class Juice extends Product {

	String presentation

  static constraints = {
  	presentation blank:false, inList:["bottle", "can", "box"], maxSize:50
  }
}
