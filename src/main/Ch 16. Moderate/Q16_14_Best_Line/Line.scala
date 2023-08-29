package Q16_14_Best_Line

class Line(p: Point, q: Point) {
  val epsilon: Double = 0.5
  var slope: Double = _  // Now it's public
  var intercept: Double = _
  var infiniteSlope: Boolean = false

  if (Math.abs(p.x - q.x) > epsilon) {
    slope = (p.y - q.y) / (p.x - q.x)
    intercept = p.y - slope * p.x
  } else {
    infiniteSlope = true
    intercept = p.x
  }

  def isEquivalent(a: Double, b: Double): Boolean = Math.abs(a - b) < epsilon

  def print(): Unit = println(s"y = $slope x + $intercept")

  def isEquivalentToLine(other: Line): Boolean =
    isEquivalent(other.slope, slope) && isEquivalent(other.intercept, intercept) && (infiniteSlope == other.infiniteSlope)
}

object Line {
  val epsilon: Double = 0.5

  def floorToNearestEpsilon(d: Double): Double = {
    val r = (d / epsilon).toInt
    r.toDouble * epsilon
  }
}
