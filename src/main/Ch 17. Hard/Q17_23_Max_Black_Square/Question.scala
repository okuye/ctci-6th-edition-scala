package Q17_23_Max_Black_Square

import CtCILibrary.AssortedMethods

object Question {
  def findSquareWithSize(matrix: Array[Array[Int]], squareSize: Int): Subsquare = {
    val count = matrix.length - squareSize + 1

    for (row <- 0 until count) {
      for (col <- 0 until count) {
        if (isSquare(matrix, row, col, squareSize)) {
          return Subsquare(row, col, squareSize)
        }
      }
    }
    null
  }

  def findSquare(matrix: Array[Array[Int]]): Subsquare = {
    assert(matrix.length > 0)
    matrix.foreach(row => assert(row.length == matrix.length))

    val N = matrix.length

    (N to 1 by -1).foreach { i =>
      val square = findSquareWithSize(matrix, i)
      if (square != null) {
        return square
      }
    }
    null
  }

  def isSquare(matrix: Array[Array[Int]], row: Int, col: Int, size: Int): Boolean = {
    for (j <- 0 until size) {
      if (matrix(row)(col + j) == 1 || matrix(row + size - 1)(col + j) == 1) {
        return false
      }
    }

    for (i <- 1 until size - 1) {
      if (matrix(row + i)(col) == 1 || matrix(row + i)(col + size - 1) == 1) {
        return false
      }
    }
    true
  }

  def main(args: Array[String]): Unit = {
    val matrix = AssortedMethods.randomMatrix(7, 7, 0, 1)
    AssortedMethods.printMatrix(matrix)
    val square = findSquare(matrix)
    square.print()
  }
}
