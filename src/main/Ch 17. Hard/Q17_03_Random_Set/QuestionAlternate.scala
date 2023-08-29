package Q17_03_Random_Set

import scala.util.Random

object QuestionAlternate {
  def pickMRecursively(original: Array[Int], m: Int, i: Int): Array[Int] = {
    if (i + 1 < m) {
      null
    } else if (i + 1 == m) {
      original.take(m)
    } else {
      val set = pickMRecursively(original, m, i - 1)
      val rand = new Random()
      val k = rand.nextInt(i + 1)
      if (k < m) {
        set(k) = original(i)
      }
      set
    }
  }

  def pickMIteratively(original: Array[Int], m: Int): Array[Int] = {
    if (m > original.length) {
      null
    } else {
      val subset = original.take(m).toArray
      val rand = new Random()
      for (i <- m until original.length) {
        val k = rand.nextInt(i + 1)
        if (k < m) {
          subset(k) = original(i)
        }
      }
      subset
    }
  }

  def main(args: Array[String]): Unit = {
    val cards = Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(cards.mkString(", "))
    val set = pickMIteratively(cards, 4)
    println(set.mkString(", "))
  }
}