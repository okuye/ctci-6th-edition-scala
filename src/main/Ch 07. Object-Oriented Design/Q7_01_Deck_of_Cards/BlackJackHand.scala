package Q7_01_Deck_of_Cards

import scala.collection.mutable.ArrayBuffer

class BlackJackHand extends Hand[BlackJackCard] {

  override def score(): Int = {
    val scores = possibleScores()
    val maxUnder = Int.MinValue
    val minOver = Int.MaxValue
    scores.foldLeft((maxUnder, minOver)) { case ((maxU, minO), score) =>
      if (score > 21 && score < minO) (maxU, score)
      else if (score <= 21 && score > maxU) (score, minO)
      else (maxU, minO)
    } match {
      case (maxU, _) if maxU != Int.MinValue => maxU
      case (_, minO) => minO
    }
  }

  private def possibleScores(): ArrayBuffer[Int] = {
    val scores = ArrayBuffer[Int]()
    if (cards.isEmpty) return scores
    cards.foreach(card => addCardToScoreList(card, scores))
    scores
  }

  private def addCardToScoreList(card: BlackJackCard, scores: ArrayBuffer[Int]): Unit = {
    if (scores.isEmpty) scores += 0
    val length = scores.length
    for (i <- 0 until length) {
      val score = scores(i)
      scores(i) = score + card.minValue()
      if (card.minValue() != card.maxValue()) scores += score + card.maxValue()
    }
  }

  def busted(): Boolean = score() > 21

  def is21(): Boolean = score() == 21

  def isBlackJack(): Boolean = {
    if (cards.length != 2) return false
    val first = cards(0)
    val second = cards(1)
    (first.isAce() && second.isFaceCard()) || (second.isAce() && first.isFaceCard())
  }
}
