
package task0

import scalaz._
import Scalaz._
import scalaz.zio.{IO, Queue, Fiber}
import scalaz.zio.console.{putStrLn}

import Exchange_pkg._

sealed trait SystemConfig {
  val MaxMessages = 128
}


// Top level system
final class System(clientsFile:String, ordersFile:String) extends SystemComponent with SystemConfig {
  
  override def toString () = "System"
  
  override def init():Unit = {
    matcher.init()
    trans.init()
    rts.unsafeRun (putStrLn(this.toString + " Init..."))
  }

  // System components
  val trans   = new Transactor(0, ordersFile)
  val matcher = new Matcher(clientsFile)
  
  //--------------------------------------------------------------------------------------------
  // Main Business Logic
  //--------------------------------------------------------------------------------------------
  def main ():Unit = {

    //val res: IO[Nothing, Unit] = for {
    val res = for {

      // Create queues
      reqQueue <- Queue.bounded[MsgT](MaxMessages)
      rspQueue <- Queue.bounded[MsgT](MaxMessages)

      // Send batch. Type safe, async, thread safe
      send = trans.dispatch()
      _ <- reqQueue.offerAll(send.toList)

      // Debug: req queue info
      _ <- putStrLn(reqQueue.capacity.toString)
      reqSize <- reqQueue.size
      _ <- putStrLn(reqSize.toString)

      // Receive batch. Type safe, async, thread safe
      data <- reqQueue.takeAll
     
      // Spawn parallel Fibers and perform matching optimistically
      workerFiber     <-  matcher.process (data).fork
      validatorFiber  <-  matcher.validate(data).fork
    
      // Read validation result
      valid           <-  validatorFiber.join 
      
      // Interrupt worker if validation vailed
      _               =    if (!valid) workerFiber.interrupt 

      // Read result from the worker thread
      out             <-  workerFiber.join

    } yield out

    // Launch IO Effect
    //rts.unsafeRun(res)
  }

  //--------------------------------------------------------------------------------------------
  // Loopback test. For integration testing
  //--------------------------------------------------------------------------------------------
  
  def loopback ():Unit = {

    val res: IO[Nothing, Unit] = for {

      // Create queues
      reqQueue <- Queue.bounded[MsgT](MaxMessages)
      rspQueue <- Queue.bounded[MsgT](MaxMessages)

      // Send batch. Type safe, async, thread safe
      send = trans.dispatch()
      _ <- reqQueue.offerAll(send.toList)

      // Debug: req queue info
      _ <- putStrLn(reqQueue.capacity.toString)
      reqSize <- reqQueue.size
      _ <- putStrLn(reqSize.toString)

      // Receive batch. Type safe, async, thread safe
      receive <- reqQueue.takeAll

      // Send back
      resp = matcher.loopback(receive.toIList)
      _ <- rspQueue.offerAll(resp.toList)
      
      // Debug: resp queue info
      _ <- putStrLn(rspQueue.capacity.toString)
      rspSize <- rspQueue.size
      _ <- putStrLn(rspSize.toString)

    } yield ()

    // Launch IO Effect
    rts.unsafeRun(res)
  }

  

}


