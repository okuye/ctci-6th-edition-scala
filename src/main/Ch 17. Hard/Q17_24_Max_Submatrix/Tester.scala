package Q17_24_Max_Submatrix

import CtCILibrary.AssortedMethods

object Tester {
  def main(args: Array[String]): Unit = {
    val matrix = AssortedMethods.randomMatrix(10, 10, -5, 5)
    AssortedMethods.printMatrix(matrix)
    val subA = QuestionA.getMaxMatrix(matrix)
    println(subA.toString())

    val subB = QuestionB.getMaxMatrix(matrix)
    println(subB.toString())

    val subC = QuestionC.getMaxMatrix(matrix)
    println(subC.toString())
  }
}
