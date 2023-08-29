package Q16_13_Bisect_Squares

class Square(val left: Double, val top: Double, val size: Double) {
  val bottom: Double = top + size
  val right: Double = left + size

  def middle(): Point = {
    new Point((this.left + this.right) / 2.0, (this.top + this.bottom) / 2.0)
  }

  def contains(other: Square): Boolean = {
    this.left <= other.left && this.right >= other.right && this.top <= other.top && this.bottom >= other.bottom
  }

  def extend(mid1: Point, mid2: Point, size: Double): Point = {
    val xdir = if (mid1.x < mid2.x) -1 else 1
    val ydir = if (mid1.y < mid2.y) -1 else 1

    if (mid1.x == mid2.x) {
      return new Point(mid1.x, mid1.y + ydir * size / 2.0)
    }

    val slope = (mid1.y - mid2.y) / (mid1.x - mid2.x)
    val (x1, y1) = if (Math.abs(slope) == 1) {
      (mid1.x + xdir * size / 2.0, mid1.y + ydir * size / 2.0)
    } else if (Math.abs(slope) < 1) {
      (
        mid1.x + xdir * size / 2.0,
        slope * (mid1.x + xdir * size / 2.0 - mid1.x) + mid1.y
      )
    } else {
      val yVal = mid1.y + ydir * size / 2.0
      ((yVal - mid1.y) / slope + mid1.x, yVal)
    }
    new Point(x1, y1)

  }

  def cut(other: Square): Line = {
    val p1 = extend(this.middle(), other.middle(), this.size)
    val p2 = extend(this.middle(), other.middle(), -1 * this.size)
    val p3 = extend(other.middle(), this.middle(), other.size)
    val p4 = extend(other.middle(), this.middle(), -1 * other.size)

    val points = List(p2, p3, p4)
    val start = points.minBy(p => (p.x, p.y))
    val end = points.maxBy(p => (p.x, p.y))

    new Line(start, end)
  }

  override def toString: String = {
    s"($left, $top)|($right,$bottom)"
  }
}
