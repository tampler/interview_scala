package task0

import scalaz.zio.console.{putStrLn}
import Exchange_pkg._

// Matching Engine
final class Matcher() extends SystemComponent {
  
  override def toString () = "Matcher"
  
  def init():Boolean = {
    rts.unsafeRun (putStrLn(this.toString + " Init..."))
    true 
  }

  // Loopback method. Sends back what's on input
  def loopback (data:ClientsT):ClientsT = data 

}


