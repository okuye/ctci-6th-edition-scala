package Q17_24_Max_Submatrix

import CtCILibrary.AssortedMethods

object QuestionC {
  def getMaxMatrix(matrix: Array[Array[Int]]): SubMatrix = {
    val rowCount = matrix.length
    val colCount = matrix(0).length

    var best: SubMatrix = null

    for (rowStart <- 0 until rowCount) {
      val partialSum = new Array[Int](colCount)

      for (rowEnd <- rowStart until rowCount) {
        // Add values at row rowEnd.
        for (i <- 0 until colCount) {
          partialSum(i) += matrix(rowEnd)(i)
        }

        val bestRange = maxSubArray(partialSum, colCount)
        if (best == null || best.getSum() < bestRange.sum) {
          best = new SubMatrix(rowStart, bestRange.start, rowEnd, bestRange.end, bestRange.sum)
        }
      }
    }
    best
  }

  def maxSubArray(array: Array[Int], N: Int): Range = {
    var best: Range = null
    var start = 0
    var sum = 0

    for (i <- 0 until N) {
      sum += array(i)
      if (best == null || sum > best.sum) {
        best = new Range(start, i, sum)
      }

      if (sum < 0) {
        start = i + 1
        sum = 0
      }
    }
    best
  }

  def main(args: Array[String]): Unit = {
    val matrix = AssortedMethods.randomMatrix(10, 10, -5, 5)
    AssortedMethods.printMatrix(matrix)
    println(getMaxMatrix(matrix))
  }
}
