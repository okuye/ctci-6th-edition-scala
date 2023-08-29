package Q16_13_Bisect_Squares

class Line(val start: Point, val end: Point) {
  override def toString: String = s"Line from ${start.toString} to ${end.toString}"
}
