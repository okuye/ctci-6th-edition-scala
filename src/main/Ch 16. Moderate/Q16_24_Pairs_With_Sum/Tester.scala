package Q16_24_Pairs_With_Sum

import CtCILibrary.AssortedMethods

object Tester {
  def printPairs(pairs: List[Pair]): Unit = {
    for (p <- pairs) {
      print(p.toString() + ", ")
    }
    println()
  }

  def main(args: Array[String]): Unit = {
    val array = Array(9, 3, 6, 5, 7, 7, -1, 13, 14, -2, 12, 0)
    val sum = 12

    val pairsA = QuestionA.printPairSums(array, sum).toList
    val pairsB = QuestionB.printPairSums(array, sum).toList
    val pairsC = QuestionC.printPairSums(array, sum).toList

    println(AssortedMethods.arrayToString(array))
    println("sum: " + sum)
    printPairs(pairsA)
    printPairs(pairsB)
    printPairs(pairsC)
    println()
    println()
    println()
  }
}
