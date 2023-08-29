package Q16_24_Pairs_With_Sum

import scala.collection.mutable.ArrayBuffer

object QuestionC {
  def printPairSums(array: Array[Int], sum: Int): ArrayBuffer[Pair] = {
    val result = new ArrayBuffer[Pair]()
    scala.util.Sorting.quickSort(array)
    var first = 0
    var last = array.length - 1
    while (first < last) {
      val s = array(first) + array(last)
      if (s == sum) {
        result += Pair(array(first), array(last))
        first += 1
        last -= 1
      } else {
        if (s < sum) {
          first += 1
        } else {
          last -= 1
        }
      }
    }
    result
  }

  def main(args: Array[String]): Unit = {
    val test = Array(9, 3, 6, 5, 7, 7, -1, 13, 14, -2, 12, 0)
    val pairs = printPairSums(test, 12)
    for (p <- pairs) {
      println(p.toString())
    }
  }
}
