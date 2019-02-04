
package task0

import scalaz.zio.{IO, Queue}
import Exchange_pkg._

sealed trait SystemConfig {
  val MaxMessages = 10
}


// Top level system
final case class System(clientsFile:String, ordersFile:String) extends SystemComponent with SystemConfig {

  val reqQueue:IO[Nothing, ReqMsgQueue] = Queue.bounded[ReqMsgT] (MaxMessages)
  val rspQueue:IO[Nothing, RspMsgQueue] = Queue.bounded[RspMsgT] (MaxMessages)

  val trans   = Transactor(0, clientsFile, ordersFile)
  val matcher = Matcher()
  
  def loopback ():Unit = {
    //trans.loopback(reqQueue, rspQueue)
    //matcher.loopback(reqQueue, rspQueue)
  }

}


