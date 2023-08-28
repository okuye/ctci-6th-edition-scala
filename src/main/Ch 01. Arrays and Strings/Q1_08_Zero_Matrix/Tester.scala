package Q1_08_Zero_Matrix

import CtCILibrary.AssortedMethods

object Tester {

  def matricesAreEqual(
      m1: Array[Array[Int]],
      m2: Array[Array[Int]]
  ): Boolean = {
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
    val matrix1 = AssortedMethods.randomMatrix(nrows, ncols, -10, 10)
    val matrix2 = cloneMatrix(matrix1)

    AssortedMethods.printMatrix(matrix1)

    QuestionA.setZeros(matrix1)
    QuestionB.setZeros(matrix2)

    println()

    AssortedMethods.printMatrix(matrix1)
    println()
    AssortedMethods.printMatrix(matrix2)

    if (matricesAreEqual(matrix1, matrix2)) {
      println("Equal")
    } else {
      println("Not Equal")
    }
  }
}
