package Q7_01_Deck_of_Cards

import CtCILibrary.AssortedMethods

import scala.collection.mutable.ArrayBuffer

class Deck[T <: Card](initialCards: ArrayBuffer[T] = ArrayBuffer.empty[T]) {
  private val cards: ArrayBuffer[T] = initialCards
  private var dealtIndex: Int = 0

  def setDeckOfCards(deckOfCards: ArrayBuffer[T]): Unit = {
    cards.clear()
    cards ++= deckOfCards
  }

  def shuffle(): Unit = {
    for (i <- cards.indices) {
      val j = AssortedMethods.randomIntInRange(i, cards.length - 1)
      val card1 = cards(i)
      val card2 = cards(j)
      cards(i) = card2
      cards(j) = card1
    }
  }

  def remainingCards(): Int = cards.length - dealtIndex

  def dealHand(number: Int): Array[T] = {
    if (remainingCards() < number) {
      return Array.empty[T]
    }

    val hand = new Array[T](number)
    var count = 0
    while (count < number) {
      val card = dealCard()
      if (card.isDefined) {
        hand(count) = card.get
        count += 1
      }
    }

    hand
  }

  def dealCard(): Option[T] = {
    if (remainingCards() == 0) {
      return None
    }

    val card = cards(dealtIndex)
    card.markUnavailable()
    dealtIndex += 1

    Some(card)
  }

  def printDeck(): Unit = {
    cards.foreach(_.printCard())
  }
}
