package Q1_08_Zero_Matrix

import CtCILibrary.AssortedMethods

object QuestionA {

  def nullifyRow(matrix: Array[Array[Int]], row: Int): Unit = {
    for (j <- matrix(row).indices) {
      matrix(row)(j) = 0
    }
  }

  def nullifyColumn(matrix: Array[Array[Int]], col: Int): Unit = {
    for (i <- matrix.indices) {
      matrix(i)(col) = 0
    }
  }

  def setZeros(matrix: Array[Array[Int]]): Unit = {
    val row = Array.fill(matrix.length)(false)
    val column = Array.fill(matrix(0).length)(false)

    // Store the row and column index with value 0
    for (i <- matrix.indices; j <- matrix(i).indices) {
      if (matrix(i)(j) == 0) {
        row(i) = true
        column(j) = true
      }
    }

    // Nullify rows
    for (i <- row.indices) {
      if (row(i)) {
        nullifyRow(matrix, i)
      }
    }

    // Nullify columns
    for (j <- column.indices) {
      if (column(j)) {
        nullifyColumn(matrix, j)
      }
    }
  }

  def matricesAreEqual(m1: Array[Array[Int]], m2: Array[Array[Int]]): Boolean = {
    if (m1.length != m2.length || m1(0).length != m2(0).length) {
      return false
    }

    for (k <- m1.indices; j <- m1(k).indices) {
      if (m1(k)(j) != m2(k)(j)) {
        return false
      }
    }
    true
  }

  def cloneMatrix(matrix: Array[Array[Int]]): Array[Array[Int]] = {
    val c = Array.ofDim[Int](matrix.length, matrix(0).length)
    for (i <- matrix.indices; j <- matrix(i).indices) {
      c(i)(j) = matrix(i)(j)
    }
    c
  }

  def main(args: Array[String]): Unit = {
    val nrows = 10
    val ncols = 15
    val matrix = AssortedMethods.randomMatrix(nrows, ncols, -10, 10)

    AssortedMethods.printMatrix(matrix)

    setZeros(matrix)

    println()

    AssortedMethods.printMatrix(matrix)
  }
}
