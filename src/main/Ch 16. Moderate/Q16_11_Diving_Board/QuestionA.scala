package Q16_11_Diving_Board

import scala.collection.mutable.HashSet

object QuestionA {
  var counter = 0

  def allLengths(k: Int, shorter: Int, longer: Int): HashSet[Int] = {
    val lengths = HashSet[Int]()
    getAllLengths(k, 0, shorter, longer, lengths)
    lengths
  }

  def getAllLengths(k: Int, total: Int, shorter: Int, longer: Int, lengths: HashSet[Int]): Unit = {
    counter += 1
    if (k == 0) {
      lengths.add(total)
      return
    }
    getAllLengths(k - 1, total + shorter, shorter, longer, lengths)
    getAllLengths(k - 1, total + longer, shorter, longer, lengths)
  }

  def main(args: Array[String]): Unit = {
    val lengths = allLengths(12, 1, 3)
    println(lengths.mkString(", "))
    println(counter)
  }
}
