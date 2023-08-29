package Q17_02_Shuffle

import scala.util.Random
import scala.jdk.CollectionConverters._

object Question {
  def shuffleArrayRecursively(cards: Array[Int], i: Int): Array[Int] = {
    if (i == 0) {
      cards
    } else {
      shuffleArrayRecursively(cards, i - 1)
      val rand = new Random()
      val k = rand.nextInt(i + 1)
      val temp = cards(k)
      cards(k) = cards(i)
      cards(i) = temp
      cards
    }
  }

  def shuffleArrayIteratively(cards: Array[Int]): Unit = {
    val rand = new Random()
    for (i <- cards.indices) {
      val k = rand.nextInt(i + 1)
      val temp = cards(k)
      cards(k) = cards(i)
      cards(i) = temp
    }
  }

  def main(args: Array[String]): Unit = {
    val cards = Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(cards.mkString(", "))
    shuffleArrayIteratively(cards)
    println(cards.mkString(", "))
  }
}