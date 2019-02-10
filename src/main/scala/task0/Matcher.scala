package task0

import scalaz._
import Scalaz._
import scalaz.zio.console.{putStrLn}
import scalaz.zio.{IO}
import Exchange_pkg._
import Resources_pkg._


// Matching Engine
final class Matcher(clientsFile:String) extends SystemComponent {
  
  override def toString () = "Matcher"
  
  override def init():Unit = {
    rts.unsafeRun (putStrLn(this.toString + " Init..."))
  }
 
  lazy val clientData:ClientsT = rts.unsafeRun(Temp.readFile(clientsFile)).toIList
  
  // Loopback method. Sends back what's on input
  def loopback (data:ClientsT):ClientsT = data 

  //--------------------------------------------------------------------------------------------
  // Business Logic. Matching methods
  //--------------------------------------------------------------------------------------------
  
  @inline 
  def validate(data:DataT): IO[Exception, Boolean] = IO.syncException (true)

  @inline 
  def process(data:DataT): IO[Exception, Boolean] = IO.syncException (true)


}


