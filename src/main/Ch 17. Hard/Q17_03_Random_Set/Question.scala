package Q17_03_Random_Set

import scala.util.Random
import scala.collection.mutable.ArrayBuffer

object Question {
  def pickMRandomly(original: Array[Int], m: Int): Array[Int] = {
    val cards = original.clone()
    val rand = new Random()
    for (i <- 0 until cards.length) {
      val k = rand.nextInt(i + 1)
      val temp = cards(k)
      cards(k) = cards(i)
      cards(i) = temp
    }
    cards.take(m)
  }

  def main(args: Array[String]): Unit = {
    val cards = Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(cards.mkString(", "))
    val set = pickMRandomly(cards, 4)
    println(set.mkString(", "))
  }
}