package Q16_24_Pairs_With_Sum

object QuestionA {

  def printPairSums(array: Array[Int], sum: Int): List[Pair] = {
    for {
      i <- array.indices.toList
      j <- (i + 1) until array.length if array(i) + array(j) == sum
    } yield Pair(array(i), array(j))
  }

  def main(args: Array[String]): Unit = {
    val test = Array(9, 3, 6, 5, 5, 7, -1, 13, 14, -2, 12, 0)
    val pairs = printPairSums(test, 12)
    pairs.foreach(p => println(p))
  }
}
