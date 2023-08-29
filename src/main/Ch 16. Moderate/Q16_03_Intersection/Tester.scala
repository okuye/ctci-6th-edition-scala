package Q16_03_Intersection

import scala.collection.mutable.ArrayBuffer

object Tester {

  def equalish(a: Double, b: Double): Boolean = {
    Math.abs(a - b) < 0.001
  }

  def checkIfPointOnLineSegments(start: Point, middle: Point, end: Point): Boolean = {
    if (equalish(start.x, middle.x) && equalish(start.y, middle.y)) {
      true
    } else if (equalish(middle.x, end.x) && equalish(middle.y, end.y)) {
      true
    } else if (start.x == end.x) {
      if (equalish(start.x, middle.x)) {
        Question.isBetween(start, middle, end)
      } else {
        false
      }
    } else {
      val line = new Line(start, end)
      val x = middle.x
      val y = line.slope * x + line.yintercept
      equalish(y, middle.y)
    }
  }

  def getPoints(size: Int): ArrayBuffer[Point] = {
    val points = ArrayBuffer[Point]()
    for (x1 <- -size until size by 3) {
      for (y1 <- -size + 1 until size - 1 by 3) {
        points.append(new Point(x1, y1))
      }
    }
    points
  }

  def runTest(start1: Point, end1: Point, start2: Point, end2: Point): Boolean = {
    val intersection = Question.intersection(start1, end1, start2, end2)
    var validate1 = true
    var validate2 = true

    if (intersection == null) {
      println("No intersection.")
    } else {
      validate1 = checkIfPointOnLineSegments(start1, intersection, end1)
      validate2 = checkIfPointOnLineSegments(start2, intersection, end2)

      if (validate1 && validate2) {
        println("has intersection")
      }
      if (!validate1 || !validate2) {
        println(s"ERROR -- $validate1, $validate2")
      }
    }

    println(s"  Start1: ${start1.x}, ${start1.y}")
    println(s"  End1: ${end1.x}, ${end1.y}")
    println(s"  Start2: ${start2.x}, ${start2.y}")
    println(s"  End2: ${end2.x}, ${end2.y}")

    if (intersection != null) {
      println(s"  Intersection: ${intersection.x}, ${intersection.y}")
    }

    if (!validate1 || !validate2) {
      false
    } else {
      true
    }
  }

  def main(args: Array[String]): Unit = {
    val points = getPoints(10)

    for (start1 <- points) {
      for (end1 <- points) {
        for (start2 <- points) {
          for (end2 <- points) {
            val success = runTest(start1, end1, start2, end2)
            if (!success) {
              return
            }
          }
        }
      }
    }
  }
}
