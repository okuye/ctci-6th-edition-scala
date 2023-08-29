package Q16_14_Best_Line

import scala.collection.mutable

object Question {

  /* Find line that goes through the most number of points. */
  def findBestLine(points: Array[Point]): Line = {
    val linesBySlope = getListOfLines(points)
    getBestLine(linesBySlope)
  }

  /* Add each pair of points as a line to the list. */
  def getListOfLines(points: Array[Point]): mutable.HashMap[Double, List[Line]] = {
    val linesBySlope = mutable.HashMap[Double, List[Line]]()
    for (i <- points.indices; j <- i + 1 until points.length) {
      val line = new Line(points(i), points(j))
      val key = Line.floorToNearestEpsilon(line.slope)
      linesBySlope(key) = line :: linesBySlope.getOrElse(key, Nil)
    }
    linesBySlope
  }


  /* Return the line with the most equivalent other lines. */
  def getBestLine(linesBySlope: mutable.HashMap[Double, List[Line]]): Line = {
    var bestLine: Line = null
    var bestCount = 0

    for (slope <- linesBySlope.keys) {
      for (line <- linesBySlope(slope)) {
        val count = countEquivalentLines(linesBySlope, line)
        if (count > bestCount) {
          bestLine = line
          bestCount = count
          bestLine.print()
          println(bestCount)
        }
      }
    }
    bestLine
  }

  def countEquivalentLines(linesBySlope: mutable.HashMap[Double, List[Line]], line: Line): Int = {
    val key = Line.floorToNearestEpsilon(line.slope)
    val count = countEquivalentLines(linesBySlope.getOrElse(key, Nil), line)
    count + countEquivalentLines(linesBySlope.getOrElse(key - Line.epsilon, Nil), line) +
      countEquivalentLines(linesBySlope.getOrElse(key + Line.epsilon, Nil), line)
  }

  def countEquivalentLines(lines: List[Line], line: Line): Int = {
    if (lines == null) 0
    else lines.count(_.isEquivalentToLine(line))
  }

  def createPoints(): Array[Point] = {
    val n_points = 100
    println("Points on Graph\n***************")
    val firstHalf = (0 until n_points / 2).map(i => new Point(i, 2.3 * i + 20.0))
    val secondHalf = (0 until n_points / 2 - 1).map(i => new Point(i, 3.0 * i + 1.0))

    (firstHalf ++ secondHalf).toArray
  }

  def validate(line: Line, points: Array[Point]): Int = {
    (for {
      i <- points.indices
      j <- i + 1 until points.length
      other = new Line(points(i), points(j))
      if line.isEquivalentToLine(other)
    } yield 1).sum
  }

  def main(args: Array[String]): Unit = {
    val points = createPoints()
    val line = findBestLine(points)
    line.print()
    println(validate(line, points))
  }
}
