package Q8_08_Permutations_With_Dups

import scala.collection.mutable

object Question {

  def buildFreqTable(s: String): mutable.Map[Char, Int] = {
    val map = mutable.Map[Char, Int]().withDefaultValue(0)
    for (c <- s) {
      map(c) += 1
    }
    map
  }

  def printPerms(map: mutable.Map[Char, Int], prefix: String, remaining: Int, result: mutable.ListBuffer[String]): Unit = {
    if (remaining == 0) {
      result += prefix
      return
    }

    for (c <- map.keys) {
      val count = map(c)
      if (count > 0) {
        map(c) -= 1
        printPerms(map, prefix + c, remaining - 1, result)
        map(c) = count
      }
    }
  }

  def printPerms(s: String): List[String] = {
    val result = mutable.ListBuffer[String]()
    val map = buildFreqTable(s)
    printPerms(map, "", s.length, result)
    result.toList
  }

  def main(args: Array[String]): Unit = {
    val s = "aabbccc"
    val result = printPerms(s)
    println(s"Count: ${result.size}")
    result.foreach(println)
  }
}
