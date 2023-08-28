package Q7_01_Deck_of_Cards

import scala.collection.mutable.ArrayBuffer

class BlackJackGameAutomator(numPlayers: Int) {
  private val HIT_UNTIL = 16
  private var deck: Deck[BlackJackCard] = new Deck[BlackJackCard]()
  private val hands: Array[BlackJackHand] =
    Array.fill(numPlayers)(new BlackJackHand())

  def dealInitial(): Boolean = {
    hands.foreach { hand =>
      val card1 = deck.dealCard()
      val card2 = deck.dealCard()
      if (card1.isEmpty || card2.isEmpty) return false
      hand.addCard(card1.get)
      hand.addCard(card2.get)
    }
    true
  }

  def getBlackJacks(): ArrayBuffer[Int] = {
    hands.indices.filter(i => hands(i).isBlackJack()).to(ArrayBuffer)
  }

  def playHand(i: Int): Boolean = playHand(hands(i))

  def playHand(hand: BlackJackHand): Boolean = {
    while (hand.score() < HIT_UNTIL) {
      val card = deck.dealCard()
      if (card.isEmpty) return false
      hand.addCard(card.get)
    }
    true
  }

  def playAllHands(): Boolean = hands.forall(playHand)

  def getWinners(): ArrayBuffer[Int] = {
    val winners = ArrayBuffer[Int]()
    var winningScore = 0
    hands.indices.foreach { i =>
      val hand = hands(i)
      if (!hand.busted()) {
        if (hand.score() > winningScore) {
          winningScore = hand.score()
          winners.clear()
          winners += i
        } else if (hand.score() == winningScore) {
          winners += i
        }
      }
    }
    winners
  }

  def initializeDeck(): Unit = {
    val cards = ArrayBuffer[BlackJackCard]()
    for {
      i <- 1 to 13
      j <- 0 to 3
    } {
      val suit = Suit(j)
      cards += new BlackJackCard(i, suit)
    }
    deck = new Deck[BlackJackCard](cards)
    deck.shuffle()
  }

  def printHandsAndScore(): Unit = {
    hands.indices.foreach { i =>
      println(s"Hand $i (${hands(i).score()}): ${hands(i)}")
    }
  }
}
