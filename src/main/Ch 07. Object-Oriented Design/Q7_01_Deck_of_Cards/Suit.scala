package Q7_01_Deck_of_Cards

object Suit extends Enumeration {
  type Suit = Value

  val Club = Value(0)
  val Diamond = Value(1)
  val Heart = Value(2)
  val Spade = Value(3)

  def getSuitFromValue(value: Int): Option[Suit] = value match {
    case 0 => Some(Club)
    case 1 => Some(Diamond)
    case 2 => Some(Heart)
    case 3 => Some(Spade)
    case _ => None
  }
}
