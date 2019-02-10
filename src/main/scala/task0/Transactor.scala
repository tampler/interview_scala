
package task0

import scalaz._
import Scalaz._
import scalaz.zio.{IO}
import scalaz.zio.console.{putStrLn}

import Exchange_pkg._
import Resources_pkg._

// Input Transactor
final class Transactor (id:Int, ordersFile:String) extends SystemComponent {
    
  override def toString () = "Transactor"
  
  override def init():Unit = {
    rts.unsafeRun (putStrLn(this.toString + " Init..."))
  }

  lazy val orderData:ClientsT = rts.unsafeRun(Temp.readFile(ordersFile)).toIList

  // Write request queue with input data
  def dispatch ():ClientsT = orderData
 
  // Read response Queue and take no action
  def retire ():Unit = {}


}
