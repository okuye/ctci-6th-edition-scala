package Q10_09_Sorted_Matrix_Search

import CtCILibrary.AssortedMethods

object QuestionB {

  def partitionAndSearch(matrix: Array[Array[Int]], origin: Coordinate, dest: Coordinate, pivot: Coordinate, x: Int): Coordinate = {
    val lowerLeftOrigin = new Coordinate(pivot.row, origin.column)
    val lowerLeftDest = new Coordinate(dest.row, pivot.column - 1)
    val upperRightOrigin = new Coordinate(origin.row, pivot.column)
    val upperRightDest = new Coordinate(pivot.row - 1, dest.column)

    val lowerLeft = findElement(matrix, lowerLeftOrigin, lowerLeftDest, x)
    if (lowerLeft == null) {
      findElement(matrix, upperRightOrigin, upperRightDest, x)
    } else {
      lowerLeft
    }
  }

  def findElement(matrix: Array[Array[Int]], origin: Coordinate, dest: Coordinate, x: Int): Coordinate = {
    if (!origin.inbounds(matrix) || !dest.inbounds(matrix)) {
      return null
    }
    if (matrix(origin.row)(origin.column) == x) {
      return origin
    } else if (!origin.isBefore(dest)) {
      return null
    }

    val start = origin.clone().asInstanceOf[Coordinate]
    val diagDist = math.min(dest.row - origin.row, dest.column - origin.column)
    val end = new Coordinate(start.row + diagDist, start.column + diagDist)
    val p = new Coordinate(0, 0)

    while (start.isBefore(end)) {
      p.setToAverage(start, end)
      if (x > matrix(p.row)(p.column)) {
        start.row = p.row + 1
        start.column = p.column + 1
      } else {
        end.row = p.row - 1
        end.column = p.column - 1
      }
    }

    partitionAndSearch(matrix, origin, dest, start, x)
  }

  def findElement(matrix: Array[Array[Int]], x: Int): Coordinate = {
    val origin = new Coordinate(0, 0)
    val dest = new Coordinate(matrix.length - 1, matrix(0).length - 1)
    findElement(matrix, origin, dest, x)
  }

  def main(args: Array[String]): Unit = {
    val matrix = Array(
      Array(15, 30, 50, 70, 73),
      Array(35, 40, 100, 102, 120),
      Array(36, 42, 105, 110, 125),
      Array(46, 51, 106, 111, 130),
      Array(48, 55, 109, 140, 150)
    )

    AssortedMethods.printMatrix(matrix)
    val m = matrix.length
    val n = matrix(0).length

    var count = 0
    val littleOverTheMax = matrix(m - 1)(n - 1) + 10
    for (i <- 0 until littleOverTheMax) {
      val c = findElement(matrix, i)
      if (c != null) {
        println(s"$i: (${c.row}, ${c.column})")
        count += 1
      }
    }
    println(s"Found $count unique elements.")
  }
}
