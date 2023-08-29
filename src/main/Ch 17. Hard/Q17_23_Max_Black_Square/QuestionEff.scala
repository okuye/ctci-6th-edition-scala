package Q17_23_Max_Black_Square

import CtCILibrary.AssortedMethods

object QuestionEff {
  def findSquareWithSize(processed: Array[Array[SquareCell]], square_size: Int): Subsquare = {
    val count = processed.length - square_size + 1

    for (row <- 0 until count) {
      for (col <- 0 until count) {
        if (isSquare(processed, row, col, square_size)) {
          return Subsquare(row, col, square_size)
        }
      }
    }
    null
  }

  def findSquare(matrix: Array[Array[Int]]): Subsquare = {
    assert(matrix.length > 0)
    matrix.foreach(row => assert(row.length == matrix.length))

    val processed = processSquare(matrix)
    val N = matrix.length

    (N to 1 by -1).foreach { i =>
      val square = findSquareWithSize(processed, i)
      if (square != null) {
        return square
      }
    }
    null
  }

  def isSquare(matrix: Array[Array[SquareCell]], row: Int, col: Int, size: Int): Boolean = {
    val topLeft = matrix(row)(col)
    val topRight = matrix(row)(col + size - 1)
    val bottomRight = matrix(row + size - 1)(col)
    if (topLeft.zerosRight < size || topLeft.zerosBelow < size ||
      topRight.zerosBelow < size || bottomRight.zerosRight < size) {
      false
    } else {
      true
    }
  }

  def processSquare(matrix: Array[Array[Int]]): Array[Array[SquareCell]] = {
    val processed = Array.ofDim[SquareCell](matrix.length, matrix.length)

    for (r <- matrix.length - 1 to 0 by -1) {
      for (c <- matrix.length - 1 to 0 by -1) {
        var rightZeros = 0
        var belowZeros = 0
        if (matrix(r)(c) == 0) {
          rightZeros += 1
          belowZeros += 1
          if (c + 1 < matrix.length) {
            val previous = processed(r)(c + 1)
            rightZeros += previous.zerosRight
          }
          if (r + 1 < matrix.length) {
            val previous = processed(r + 1)(c)
            belowZeros += previous.zerosBelow
          }
        }
        processed(r)(c) = new SquareCell(rightZeros, belowZeros)
      }
    }
    processed
  }

  def main(args: Array[String]): Unit = {
    val matrix = AssortedMethods.randomMatrix(7, 7, 0, 1)
    AssortedMethods.printMatrix(matrix)
    val square = findSquare(matrix)
    square.print()
  }
}
