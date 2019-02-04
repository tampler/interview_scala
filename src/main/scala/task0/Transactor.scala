
package task0

import scalaz._
import Scalaz._
import effect._
import IO._

import Exchange_pkg._

// Input Transactor
final case class Transactor (id:Int, clientsFile:String, ordersFile:String) extends SystemComponent {


  // Wrap to IO monad
  def readFile (fin:String):ClientsT = {

    // Wrap unsafe operation into a safe IO Monad
    val stream  = IO {
      val source  = scala.io.Source.fromFile(fin)
      source.getLines.toStream
    }
   
    // safely return
    stream.unsafePerformIO.toIList
  }

  // Initialization
  def init():Boolean = {

    val act0  = for {
      _ <- putStrLn("Initialization...")
    } yield()
   
    // Returns okay if all works fine. Unsafe IO may throw an exception
    act0.unsafePerformIO
    true 
  }

  def show(in:ClientsT):Boolean = {
    in map (i => println(i))
    true
  }
 
}

