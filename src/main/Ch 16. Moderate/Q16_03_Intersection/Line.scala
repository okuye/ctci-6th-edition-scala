package Q16_03_Intersection

class Line(val start: Point, val end: Point) {
  val (slope, yintercept) =
    if (start.x == end.x) {
      (Double.PositiveInfinity, Double.PositiveInfinity)
    } else {
      val s = (end.y - start.y) / (end.x - start.x)
      val y = end.y - s * end.x
      (s, y)
    }

  def isVertical: Boolean = slope == Double.PositiveInfinity

  override def toString: String =
    s"Line [slope=$slope, yintercept=$yintercept, start=$start, end=$end]"

  def getYFromX(x: Double): Double = {
    if (isVertical) {
      Double.PositiveInfinity
    } else {
      slope * x + yintercept
    }
  }
}
