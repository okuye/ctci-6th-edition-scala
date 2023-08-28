package Q1_08_Zero_Matrix

import CtCILibrary.AssortedMethods

import scala.util.control.Breaks._
object QuestionB {

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
    var rowHasZero = false
    var colHasZero = false

    // Check if first row has a zero
    breakable {
      for (j <- matrix(0).indices) {
        if (matrix(0)(j) == 0) {
          rowHasZero = true
          break() // break out of the loop
        }
      }
    }

    // Check if first column has a zero
    breakable {
      for (i <- matrix.indices) {
        if (matrix(i)(0) == 0) {
          colHasZero = true
          break() // break out of the loop
        }
      }
    }

    // Check for zeros in the rest of the array
    for (i <- 1 until matrix.length; j <- 1 until matrix(0).length) {
      if (matrix(i)(j) == 0) {
        matrix(i)(0) = 0
        matrix(0)(j) = 0
      }
    }

    // Nullify rows based on values in first column
    for (i <- 1 until matrix.length) {
      if (matrix(i)(0) == 0) {
        nullifyRow(matrix, i)
      }
    }

    // Nullify columns based on values in first row
    for (j <- 1 until matrix(0).length) {
      if (matrix(0)(j) == 0) {
        nullifyColumn(matrix, j)
      }
    }

    // Nullify first row
    if (rowHasZero) {
      nullifyRow(matrix, 0)
    }

    // Nullify first column
    if (colHasZero) {
      nullifyColumn(matrix, 0)
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
