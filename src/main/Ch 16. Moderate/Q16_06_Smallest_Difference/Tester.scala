package Q16_06_Smallest_Difference

object Tester {
  def main(args: Array[String]): Unit = {
    for (_ <- 0 until 100) {
      val size = (Math.random() * 100).toInt
      // Mocking the AssortedMethods.randomArray method for the conversion
      val array1 = Array.fill(size)((Math.random() * (2 * size) - size).toInt)
      val array2 = Array.fill(size)((Math.random() * (2 * size) - size).toInt)
      val diffA = QuestionA.findSmallestDifference(array1, array2)
      val diffB = QuestionB.findSmallestDifference(array1, array2)
      val diffC = QuestionC.findSmallestDifference(array1, array2)
      if (diffA != diffB || diffB != diffC) {
        println(diffA)
        println(diffB)
        println(diffC)
        println()
      }
    }
  }
}
