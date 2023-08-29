package Q17_16_The_Masseuse

import CtCILibrary.AssortedMethods

object Tester {

  def generateRandomArray(size: Int): Array[Int] = {
    val array = AssortedMethods.randomArray(size, 1, 10)
    array.map(_ * 15)
  }

  def sumEveryOther(array: Array[Int]): Array[Int] = {
    val first = array.indices.collect { case i if i % 2 == 0 => array(i) }.sum
    val second = array.indices.collect { case i if i % 2 == 1 => array(i) }.sum
    Array(first, second)
  }

  def main(args: Array[String]): Unit = {
    val cutOff = 5
    val numTests = 100

    for (i <- 1 until cutOff) {
      val massages = generateRandomArray(i)
      val maxA = QuestionA.maxMinutes(massages)
      val maxB = QuestionB.maxMinutes(massages)
      val maxC = QuestionC.maxMinutes(massages)
      val maxD = QuestionD.maxMinutes(massages)
      val list = sumEveryOther(massages)
      if (maxA != list(0) && maxA != list(1)) {
        println(AssortedMethods.arrayToString(massages))
        println(s"$maxA, $maxB, $maxC, $maxD")
      }

      if (maxA != maxB || maxB != maxC || maxC != maxD) {
        println(s"Error at $i: $maxA, $maxB, $maxC, $maxD")
      }
    }

    for (i <- cutOff until numTests) {
      val massages = generateRandomArray(i)
      val maxB = QuestionB.maxMinutes(massages)
      val maxC = QuestionC.maxMinutes(massages)
      val maxD = QuestionD.maxMinutes(massages)
      val list = sumEveryOther(massages)
      if (maxB != list(0) && maxB != list(1)) {
        println(AssortedMethods.arrayToString(massages))
        println(s"$maxB, $maxC, $maxD")
      }

      if (maxB != maxC || maxC != maxD) {
        println(s"Error at $i: $maxB, $maxC, $maxD")
      }
    }

    println("All tests have run.")
  }
}
