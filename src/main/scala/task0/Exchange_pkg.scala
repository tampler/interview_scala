
package Exchange_pkg

import scala.{Enumeration}
import scalaz.{IList}
import scalaz.zio.{IO, Queue, RTS}

// Common Types
sealed abstract class Currency
final case object RUR extends Currency

// Response messages from the Matching Engine
final object MatcherMessage extends Enumeration {

  type MatcherMessage = Value 

  val MF  = Value ("Matched Fully")
  val MP  = Value ("Matched Partially")
  val IOE = Value ("Invalid oer Entry")
  val OOF = Value ("Rejected: Out Of Funds")
  val RJO = Value ("Rejected: Other Error")

}

final object oerType extends Enumeration {

  type oerType = Value 

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
  
  // ZIO effect wrapper
  val rts = new RTS {}

  type ClientsT = IList[String]
  type OrdersT  = IList[String]

  type MsgT = String

}
  
   
// Initial idomer Position. Given as an input file
sealed abstract class Record
final case class Position (val id:String, val amount:Int, val pos:Seq[Int]) extends Record
final case class MarketOrder (val id:String, val side:String, val sec:String, val price:Int, val qty:Int) extends Record


//final object Position {
//  def apply (id:String, amount:Int, pos:Seq[Int]):Position = new Position(id:String, amount:Int, pos:Seq[Int])
//  def unapply (p:Position):Option[String, Int, Seq[Int]] = Some(o.id, o.amount, )
//}
//
//final object MarketOrder {
//  def apply (id:String, side:String, sec:String, price:Int, qty:Int):MarketOrder = new MarketOrder(id:String, side:String, sec:String, price:Int, qty:Int)
//
//  def unapply (o:MarketOrder):Option[Tuple5[String, String, String, Int, Int]] = Some(o.id, o.side, o.sec, o.price, o.qty)
//}


//final case class MarketOrder (id:String, side:oerType.type, sec:SecurityType.type, price:Int, qty:Int) extends Reco
//
//object MarketOrder {
//
//  implicit def Stringtooer (s:String):oerType.id = s match {
//    case "b"  => oerType.b
//    case "s"  => oerType.s
//    case _    => oerType.inv
//  }
//
//}

