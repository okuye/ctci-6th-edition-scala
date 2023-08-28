package Q1_07_Rotate_Matrix

import CtCILibrary.AssortedMethods

object Question {

  def rotate(matrix: Array[Array[Int]]): Boolean = {
    if (matrix.isEmpty || matrix.length != matrix(0).length) return false // Not a square
    val n = matrix.length

    for (layer <- 0 until n / 2) {
      val first = layer
      val last = n - 1 - layer
      for (i <- first until last) {
        val offset = i - first
        val top = matrix(first)(i) // save top

        // left -> top
        matrix(first)(i) = matrix(last - offset)(first)

        // bottom -> left
        matrix(last - offset)(first) = matrix(last)(last - offset)

        // right -> bottom
        matrix(last)(last - offset) = matrix(i)(last)

        // top -> right
        matrix(i)(last) = top // right <- saved top
      }
    }
    true
  }

  def main(args: Array[String]): Unit = {
    val matrix = AssortedMethods.randomMatrix(3, 3, 0, 9)
    AssortedMethods.printMatrix(matrix)
    rotate(matrix)
    println()
    AssortedMethods.printMatrix(matrix)
  }

}
