
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

  // Parse input data and repack into 6-tuples
  def parse (str:String):Position  = {

    val out:Position = str split ("\t") map (_.trim) match {

      case Array (a,b,c,d,e,f) => Position (a.toString, b.toInt, c.toInt, d.toInt, e.toInt, f.toInt)
      case _ => Position("", 0, 0, 0, 0, 0) // TBD: Add error handling here
    }

    out
  }

}
