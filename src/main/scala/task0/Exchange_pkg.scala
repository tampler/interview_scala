
package object Exchange_pkg

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
