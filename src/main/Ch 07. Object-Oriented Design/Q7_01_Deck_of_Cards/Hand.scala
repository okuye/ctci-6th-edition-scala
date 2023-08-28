package Q7_01_Deck_of_Cards

import scala.collection.mutable.ArrayBuffer

class Hand[T <: Card] {
  protected val cards: ArrayBuffer[T] = ArrayBuffer.empty[T]

  def score(): Int = cards.map(_.value()).sum

  def addCard(card: T): Unit = cards += card

  def printHand(): Unit = cards.foreach(_.printCard())
}
