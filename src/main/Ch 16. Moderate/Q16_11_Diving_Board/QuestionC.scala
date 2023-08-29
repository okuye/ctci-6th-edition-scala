package Q16_11_Diving_Board

import scala.collection.mutable.HashSet

object QuestionC {
  var counter = 0

  def allLengths(k: Int, shorter: Int, longer: Int): HashSet[Int] = {
    counter += 1
    val lengths = HashSet[Int]()
    for (nShorter <- 0 to k) {
      val nLonger = k - nShorter
      val length = nShorter * shorter + nLonger * longer
      lengths.add(length)
    }
    lengths
  }

  def main(args: Array[String]): Unit = {
    val lengths = allLengths(12, 1, 3)
    println(lengths.mkString(", "))
  }
}
