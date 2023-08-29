package Q16_13_Bisect_Squares

class Point(val x: Double, val y: Double) {
  def isEqual(p: Point): Boolean = p.x == x && p.y == y

  override def toString: String = s"($x, $y)"
}
