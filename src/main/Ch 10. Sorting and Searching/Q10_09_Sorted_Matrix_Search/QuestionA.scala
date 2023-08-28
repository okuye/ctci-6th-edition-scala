package Q10_09_Sorted_Matrix_Search

import CtCILibrary.AssortedMethods

object QuestionA {

  def findElement(matrix: Array[Array[Int]], elem: Int): Boolean = {
    var row = 0
    var col = matrix(0).length - 1
    while (row < matrix.length && col >= 0) {
      if (matrix(row)(col) == elem) {
        return true
      } else if (matrix(row)(col) > elem) {
        col -= 1
      } else {
        row += 1
      }
    }
    false
  }

  def main(args: Array[String]): Unit = {
    val M = 10
    val N = 5
    val matrix = Array.ofDim[Int](M, N)

    for (i <- 0 until M; j <- 0 until N) {
      matrix(i)(j) = 10 * i + j
    }

    AssortedMethods.printMatrix(matrix)

    for (i <- 0 until M; j <- 0 until M) {
      val v = 10 * i + j
      println(s"$v: ${findElement(matrix, v)}")
    }
  }
}
