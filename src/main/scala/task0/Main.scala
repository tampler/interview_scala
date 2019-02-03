
package task0

import scalaz._
import Scalaz._
import effect._
import IO._



sealed abstract class Currency
sealed abstract class Security
sealed abstract class Trader


final case object USD extends Currency
final case object BuySide extends Trader
final case object SellSide extends Trader

final case object SecurityA extends Security
final case object SecurityB extends Security
final case object SecurityC extends Security
final case object SecurityD extends Security


object Task extends App {

  val clientsFile = "/home/bku/work/git/scala/interview_scala/src/main/resources/clients.txt"
  val ordersFile = "/home/bku/work/git/scala/interview_scala/src/main/resources/orders.txt"

  val act0  = for {
    _ <- putStrLn("Hello Scalaz")
  } yield()
  
  act0.unsafePerformIO
  
  // Wrap to IO monad
  
  val clientsIO  = IO {
    //val source  = scala.io.Source.fromFile("/resources/clients.txt") // FIXME This doesn't work 
    val source  = scala.io.Source.fromFile(clientsFile)
    source.getLines.toStream
  }
  
  val ordersIO  = IO {
    //val source  = scala.io.Source.fromFile("/resources/clients.txt") // FIXME This doesn't work 
    val source  = scala.io.Source.fromFile(ordersFile)
    source.getLines.toStream
  }

  // Process input stream
  val clients = clientsIO.unsafePerformIO.toList
  val orders  = ordersIO.unsafePerformIO.toList
  clients foreach (println)
  orders  foreach (println)
}

