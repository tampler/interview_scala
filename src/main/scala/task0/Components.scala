package task0

import scalaz._
import Scalaz._
import effect._
import IO._

sealed abstract class SystemComponent {
  type ClientsT = IList[String]
  type OrdersT  = IList[String]
}

final case class Matcher() extends SystemComponent

final case class Transactor (id:Int, clientsFile:String, ordersFile:String) extends SystemComponent {


  // Wrap to IO monad
  def readData (fin:String):ClientsT = {

    // Wrap unsafe operation into a safe IO Monad
    val stream  = IO {
      val source  = scala.io.Source.fromFile(fin)
      source.getLines.toStream
    }
   
    // safely return
    stream.unsafePerformIO.toIList
  }

  // Initialization
  def init():Unit = {

    val act0  = for {
      _ <- putStrLn("Initialization...")
    } yield()
    
    act0.unsafePerformIO
  
  }
 
}
