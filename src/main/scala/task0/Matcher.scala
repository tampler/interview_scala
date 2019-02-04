package task0
import Exchange_pkg._

// Matching Engine
final case class Matcher() extends SystemComponent {

  // Loopback method. Sends back what's on input
  def loopback (reqQ:ReqMsgQueue, rspQ:RspMsgQueue):Unit = {

    val res = for {
      item <- reqQ.take 
      _ <- rspQ.offer(item)
    } yield(item)
    
  }

}


