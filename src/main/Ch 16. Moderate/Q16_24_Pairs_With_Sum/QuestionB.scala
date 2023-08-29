package Q16_24_Pairs_With_Sum

import scala.collection.mutable

object QuestionB {

  def printPairSums(array: Array[Int], sum: Int): List[Pair] = {
    val result = mutable.ListBuffer[Pair]()
    val unpairedCount = mutable.Map[Int, Int]().withDefaultValue(0)

    for (x <- array) {
      val complement = sum - x
      if (unpairedCount(complement) > 0) {
        result += Pair(x, complement)
        adjustCounterBy(unpairedCount, complement, -1)
      } else {
        adjustCounterBy(unpairedCount, x, 1)
      }
    }
    result.toList
  }

  def adjustCounterBy(counter: mutable.Map[Int, Int], key: Int, delta: Int): Unit = {
    counter(key) = counter(key) + delta
  }

  def main(args: Array[String]): Unit = {
    val test = Array(-1, -1, -1, -1, 0, 0, 0, 0, 1, 1)
    val pairs = printPairSums(test, -1)
    pairs.foreach(p => println(p))
  }
}
