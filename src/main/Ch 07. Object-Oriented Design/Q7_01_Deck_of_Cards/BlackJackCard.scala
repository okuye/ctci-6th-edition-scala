package Q7_01_Deck_of_Cards

class BlackJackCard(c: Int, s: Suit.Value) extends Card(c, s) {

  override def value(): Int = {
    if (isAce()) 1
    else if (isFaceCard()) 10
    else faceValue
  }

  def minValue(): Int = {
    if (isAce()) 1
    else value()
  }

  def maxValue(): Int = {
    if (isAce()) 11
    else value()
  }

  def isAce(): Boolean = faceValue == 1

  def isFaceCard(): Boolean = faceValue >= 11 && faceValue <= 13
}
