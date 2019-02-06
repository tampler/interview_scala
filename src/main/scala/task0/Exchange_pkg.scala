
package Exchange_pkg

import scala.{Enumeration}
import scalaz.{IList}

// Common Types
sealed abstract class Currency
sealed abstract class Security
sealed abstract class Trader

final case object RUR extends Currency
final case object BuySide extends Trader
final case object SellSide extends Trader

final case object SecurityA extends Security
final case object SecurityB extends Security
final case object SecurityC extends Security
final case object SecurityD extends Security 

// Response messages from the Matching Engine
final object MatcherMessage extends Enumeration {

  type Message = Value 

  val MF  = Value ("Matched Fully")
  val MP  = Value ("Matched Partially")
  val IOE = Value ("Invalid Order Entry")
  val OOF = Value ("Rejected: Out Of Funds")
  val RJO = Value ("Rejected: Other Error")

}

// Generic System Component
abstract class SystemComponent {

  type ClientsT = IList[String]
  type OrdersT  = IList[String]

  type MsgT = String

}
   
// Initial Customer Position. Given as an input file
final case class Position (id:String, amount:Int, posA:Int, posB:Int, posC:Int, posD:Int)

object Position {
  
  def apply (id:String, amount:Int, posA:Int, posB:Int, posC:Int, posD:Int) = new Position (id, amount, posA, posB, posC, posD)
  def toString(id:String, amount:Int, posA:Int, posB:Int, posC:Int, posD:Int): String = s"Customer: $id, Amount: $amount"

}

