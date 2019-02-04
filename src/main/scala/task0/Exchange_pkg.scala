
package object Exchange_pkg
import scala.{Enumeration}


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

// Response messages from the Matching Engine
final object MatcherMessage extends Enumeration {

  type Message = Value 
  val MF  = Value ("Matched Fully")
  val MP  = Value ("Matched Partially")
  val IOE = Value ("Invalid Order Entry")
  val OOF = Value ("Rejected: Out Of Funds")
  val RJO = Value ("Rejected: Other Error")

}
