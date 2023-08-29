package Q16_13_Bisect_Squares

object Question {

  def randomInt(n: Int): Int = (Math.random() * n).toInt

  def printLine(l: Line): Unit = {
    println(s"${l.start.x}\t${l.start.y}")
    println(s"${l.end.x}\t${l.end.y}")
  }

  def printSquare(s: Square): Unit = {
    println(s"${s.left}\t${s.top}\t${s.size}")
  }

  def isApproxEqual(d1: Double, d2: Double): Boolean = {
    val epsilon = .001
    Math.abs(d1 - d2) < epsilon
  }

  def isApproxEqual(p1: Point, p2: Point): Boolean = {
    isApproxEqual(p1.x, p2.x) && isApproxEqual(p1.y, p2.y)
  }

  def doTest(s1: Square, s2: Square, start: Point, end: Point): Boolean = {
    val line = s1.cut(s2)
    val r = (isApproxEqual(line.start, start) && isApproxEqual(line.end, end)) ||
      (isApproxEqual(line.start, end) && isApproxEqual(line.end, start))

    if (!r) {
      printSquare(s1)
      printSquare(s2)
      printLine(line)
      println(start)
      println(end)
      println()
    }
    r
  }

  def doTestFull(s1: Square, s2: Square, start: Point, end: Point): Boolean = {
    doTest(s1, s2, start, end) && doTest(s2, s1, start, end)
  }

  def doTests(): Unit = {
    doTestFull(new Square(1, 1, 5), new Square(1, 1, 5), new Point(3.5, 1), new Point(3.5, 6))
    doTestFull(new Square(1, 1, 5), new Square(2, 2, 3), new Point(3.5, 1), new Point(3.5, 6))
    // ... [similar tests as in the original code]
  }

  def main(args: Array[String]): Unit = {
    doTests()
  }

}
