package Q16_03_Intersection

object Question {

  /* Checks if middle is between start and end. */
  def isBetween(start: Double, middle: Double, end: Double): Boolean = {
    if (start > end) {
      end <= middle && middle <= start
    } else {
      start <= middle && middle <= end
    }
  }

  /* Checks if middle is between start and end. */
  def isBetween(start: Point, middle: Point, end: Point): Boolean = {
    isBetween(start.x, middle.x, end.x) && isBetween(start.y, middle.y, end.y)
  }

  def intersection(start1: Point, end1: Point, start2: Point, end2: Point): Point = {
    val line1 = new Line(start1, end1)
    val line2 = new Line(start2, end2)

    if (line1.slope == line2.slope) {
      if (line1.yintercept != line2.yintercept) {
        return null
      }

      /* Check if the start or end of one line is in the other. If so, return that point */
      if (isBetween(start1, start2, end1)) start2
      else if (isBetween(start1, end2, end1)) end2
      else if (isBetween(start2, start1, end2)) start1
      else if (isBetween(start2, end1, end2)) end1
      else null
    } else {
      /* Compute the intersection of the infinite lines, and then check if this falls within the
       * boundary of the line segments. Note that at most one line is vertical. */

      /* Get intersection's x coordinate. If one is vertical, always use its x coordinate.
       * Otherwise, compute the intersection's x coordinate based on setting each line's y = mx + b equation
       * equal and solving for x. */
      val x = if (line1.isVertical || line2.isVertical) { // Remove parentheses
        if (line1.isVertical) line1.start.x else line2.start.x
      } else {
        (line2.yintercept - line1.yintercept) / (line1.slope - line2.slope)
      }

      /* Get intersection's y coordinate using a non-vertical line. Note that if line1 is vertical
       * then line 2 is not vertical (else it would have been caught earlier). */
      val y = if (line1.isVertical) line2.getYFromX(x) else line1.getYFromX(x)

      /* We now have the intersection of the infinite lines. Check if it's within the boundaries
       * of each line segment. */
      val intersection = new Point(x, y)
      if (isBetween(start1, intersection, end1) && isBetween(start2, intersection, end2)) {
        intersection
      } else {
        null
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val s1 = new Point(2147000000, 1)
    val e1 = new Point(-2147000000, -1)
    val s2 = new Point(-10, 0)
    val e2 = new Point(0, 0)
    val intersection = intersection(s1, e1, s2, e2)
    println(s"Line Segment 1: $s1 to $e1")
    println(s"Line Segment 2: $s2 to $e2")
    intersection match {
      case null => println("Intersection: None")
      case _ => println(s"Intersection: $intersection")
    }
//    println(s"Intersection: ${if (intersection.eq(null)) "None" else intersection}")
    intersection match {
      case null => // Do nothing
      case _    =>
      println(s"Intersection is on segment1: ${Tester.checkIfPointOnLineSegments(s1, intersection, e1)}")
      println(s"Intersection is on segment1: ${Tester.checkIfPointOnLineSegments(s2, intersection, e2)}")
    }
  }
}
