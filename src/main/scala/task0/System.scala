
package task0

import scalaz.zio.{IO, Queue}
import Exchange_pkg._

// Top level system
final case class System() extends SystemComponent {

  val reqQueue:IO[Nothing, Queue[ClientsT]]  = Queue.bounded[ClientsT] (100)

  val transactor  = Transactor(0, "","")
  val matcher  = Matcher()
  
  

}


