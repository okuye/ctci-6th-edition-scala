package Q17_24_Max_Submatrix

import CtCILibrary._

object QuestionA {
  def getMaxMatrix(matrix: Array[Array[Int]]): SubMatrix = {
    val rowCount = matrix.length
    val columnCount = matrix(0).length
    var best: SubMatrix = null

    for (row1 <- 0 until rowCount) {
      for (row2 <- row1 until rowCount) {
        for (col1 <- 0 until columnCount) {
          for (col2 <- col1 until columnCount) {
            val sumValue = sum(matrix, row1, col1, row2, col2)
            if (best == null || best.getSum() < sumValue) {
              best = new SubMatrix(row1, col1, row2, col2, sumValue)
            }
          }
        }
      }
    }
    best
  }

  private def sum(matrix: Array[Array[Int]], row1: Int, col1: Int, row2: Int, col2: Int): Int = {
    var sum = 0
    for (r <- row1 to row2) {
      for (c <- col1 to col2) {
        sum += matrix(r)(c)
      }
    }
    sum
  }

  def main(args: Array[String]): Unit = {
    val matrix = AssortedMethods.randomMatrix(10, 10, -5, 5)
    AssortedMethods.printMatrix(matrix)
    val sub = getMaxMatrix(matrix)
    println(sub.toString())
  }
}
