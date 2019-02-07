
package task0

import scalaz._
import Scalaz._
import effect._
import IO._

import Exchange_pkg._

// Input Transactor
final case class Transactor (id:Int, clientsFile:String, ordersFile:String) extends SystemComponent {

  lazy val clientData:ClientsT = readFile(clientsFile)

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

  // Show contents of some container
  //def show[A <: TraversableLike ](in:A):Boolean = {
  //def show[+A <: IList[A] ](in:A):Boolean = {  // FIXME
  def show (in:ClientsT):Boolean = {  // FIXME
    in map (i => println(i))
    true
  }

  // Write request queue with input data
  def dispatch ():ClientsT = clientData
 
  // Read response Queue and take no action
  def retire ():Unit = {}

  // Parse input data 
  def parse (str:String)  = {

    val out = str split ("\t") map (_.trim) match {

      case Array (id, amount, seqPos @ _*) => Position (id.toString, amount.toInt, seqPos map(_.toInt))
      case _ => Position("", 0, _) // TBD: Add error handling here
    }

    out
  }
  
  //def parseOrd (str:String)  = {

  //  val EOrd  = Exchange_pkg.Order
  //  
  //  val out = str split ("\t") map (_.trim) match {

  //    case Array (id, side, sec, price, qty) => EOrd (id.toString, EOrd.toOrder(side), sec, price.toInt, qty.toInt)
  //    //case _ => Order("", 0) // TBD: Add error handling here
  //  }

  //  out
  //}

}
