package task0
import Exchange_pkg._

// Matching Engine
final case class Matcher() extends SystemComponent {

  // Loopback method. Sends back what's on input
  def loopback (data:ClientsT):ClientsT = data 

}


