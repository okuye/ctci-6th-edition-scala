package Q17_24_Max_Submatrix

import CtCILibrary._

object QuestionB {
  def getMaxMatrix(matrix: Array[Array[Int]]): SubMatrix = {
    var best: SubMatrix = null
    val rowCount = matrix.length
    val columnCount = matrix(0).length
    val sumThrough = precomputeSums(matrix)

    for (row1 <- 0 until rowCount) {
      for (row2 <- row1 until rowCount) {
        for (col1 <- 0 until columnCount) {
          for (col2 <- col1 until columnCount) {
            val sumValue = sum(sumThrough, row1, col1, row2, col2)
            if (best == null || best.getSum() < sumValue) {
              best = new SubMatrix(row1, col1, row2, col2, sumValue)
            }
          }
        }
      }
    }
    best
  }

  private def precomputeSums(matrix: Array[Array[Int]]): Array[Array[Int]] = {
    val sumThrough = Array.ofDim[Int](matrix.length, matrix(0).length)
    for (r <- 0 until matrix.length) {
      for (c <- 0 until matrix(0).length) {
        val left = if (c > 0) sumThrough(r)(c - 1) else 0
        val top = if (r > 0) sumThrough(r - 1)(c) else 0
        val overlap = if (r > 0 && c > 0) sumThrough(r - 1)(c - 1) else 0
        sumThrough(r)(c) = left + top - overlap + matrix(r)(c)
      }
    }
    sumThrough
  }

  private def sum(sumThrough: Array[Array[Int]], r1: Int, c1: Int, r2: Int, c2: Int): Int = {
    val topAndLeft = if (r1 > 0 && c1 > 0) sumThrough(r1 - 1)(c1 - 1) else 0
    val left = if (c1 > 0) sumThrough(r2)(c1 - 1) else 0
    val top = if (r1 > 0) sumThrough(r1 - 1)(c2) else 0
    val full = sumThrough(r2)(c2)
    full - left - top + topAndLeft
  }

  def main(args: Array[String]): Unit = {
    val matrix = AssortedMethods.randomMatrix(10, 10, -5, 5)
    AssortedMethods.printMatrix(matrix)
    println(getMaxMatrix(matrix))
  }
}
