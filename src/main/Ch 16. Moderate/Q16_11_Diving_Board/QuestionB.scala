package Q16_11_Diving_Board

import scala.collection.mutable.HashSet

object QuestionB {
  var counter = 0

  def allLengths(k: Int, shorter: Int, longer: Int): HashSet[Int] = {
    val lengths = HashSet[Int]()
    val visited = HashSet[String]()
    getAllLengths(k, 0, shorter, longer, lengths, visited)
    lengths
  }

  def getAllLengths(k: Int, total: Int, shorter: Int, longer: Int, lengths: HashSet[Int], visited: HashSet[String]): Unit = {
    counter += 1
    if (k == 0) {
      lengths.add(total)
      return
    }
    val key = s"$k $total"
    if (visited.contains(key)) {
      return
    }
    getAllLengths(k - 1, total + shorter, shorter, longer, lengths, visited)
    getAllLengths(k - 1, total + longer, shorter, longer, lengths, visited)
    visited.add(key)
  }

  def main(args: Array[String]): Unit = {
    val lengths = allLengths(12, 1, 3)
    println(lengths.mkString(", "))
    println(counter)
  }
}
