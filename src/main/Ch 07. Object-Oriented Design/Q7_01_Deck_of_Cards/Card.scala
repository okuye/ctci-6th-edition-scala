package Q7_01_Deck_of_Cards

import Q7_01_Deck_of_Cards.Suit.{Club, Diamond, Heart, Spade, Suit}

abstract class Card(c: Int, s: Suit) {
  private var available = true

  protected val faceValue: Int = c
  protected val _suit: Suit = s

  def value(): Int

  def suit(): Suit = _suit

  def isAvailable(): Boolean = available

  def markUnavailable(): Unit = {
    available = false
  }

  def markAvailable(): Unit = {
    available = true
  }

  def printCard(): Unit = {
    val faceValues = Array("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")
    print(faceValues(faceValue - 1))
    suit match {
      case Club => print("c")
      case Heart => print("h")
      case Diamond => print("d")
      case Spade => print("s")
    }
    print(" ")
  }
}
