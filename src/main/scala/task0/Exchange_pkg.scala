
package Exchange_pkg

import scala.{Enumeration}
import scalaz.{IList}

// Common Types
sealed abstract class Currency
final case object RUR extends Currency

// Response messages from the Matching Engine
final object MatcherMessage extends Enumeration {

  type MatcherMessage = Value 

  val MF  = Value ("Matched Fully")
  val MP  = Value ("Matched Partially")
  val IOE = Value ("Invalid Order Entry")
  val OOF = Value ("Rejected: Out Of Funds")
  val RJO = Value ("Rejected: Other Error")

}

final object OrderType extends Enumeration {

  type OrderType = Value 

  val inv = Value ("invalid entry")
  
  val b = Value ("buy")
  val s = Value ("sell")

}

final object SecurityType extends Enumeration {

  type SecurityType = Value 

  val inv   = Value ("invalid entry")
  
  val secA  = Value ("Security A")
  val secB  = Value ("Security B")
  val secC  = Value ("Security C")
  val secD  = Value ("Security D")
  
}

// Generic System Component
abstract class SystemComponent {

  type ClientsT = IList[String]
  type OrdersT  = IList[String]

  type MsgT = String

  type ClientData = Tuple6[String,Int,Int,Int,Int,Int]
}
   
// Initial Customer Position. Given as an input file
sealed abstract class Record
final case class Position (id:String, amount:Int, pos:Seq[Int]) extends Record
final case class MarketOrder (cust:String, side:String, sec:String, price:Int, qty:Int) extends Record
//final case class Order (cust:String, side:OrderType.type, sec:SecurityType.type, price:Int, qty:Int) extends Record
//
//object Order {
//
//  implicit def StringtoOrder (s:String):OrderType.id = s match {
//    case "b"  => OrderType.b
//    case "s"  => OrderType.s
//    case _    => OrderType.inv
//  }
//
//}

