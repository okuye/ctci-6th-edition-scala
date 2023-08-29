package Q17_18_Shortest_Supersequence

import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks.break

object QuestionA {
  def findNextInstance(array: Array[Int], element: Int, index: Int): Int = {
    for (i <- index until array.length) {
      if (array(i) == element) {
        return i
      }
    }
    -1
  }

  def findClosure(bigArray: Array[Int], smallArray: Array[Int], index: Int): Int = {
    var max = -1
    for (i <- 0 until smallArray.length) {
      val next = findNextInstance(bigArray, smallArray(i), index)
      if (next == -1) {
        return -1
      }
      max = math.max(next, max)
    }
    max
  }

  case class Range(start: Int, end: Int)

  def shortestSupersequence(bigArray: Array[Int], smallArray: Array[Int]): Option[Range] = {
    var bestStart = -1
    var bestEnd = -1
    for (i <- 0 until bigArray.length) {
      val end = findClosure(bigArray, smallArray, i)
      if (end == -1) break
      if (bestStart == -1 || end - i < bestEnd - bestStart) {
        bestStart = i
        bestEnd = end
      }
    }
    if (bestStart < 0 || bestEnd < 0) {
      None
    } else {
      Some(Range(bestStart, bestEnd))
    }
  }

  def main(args: Array[String]): Unit = {
    val array = Array(7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 9, 7)
    val set = Array(1, 5, 9)
    println(array.length)
    val shortest = shortestSupersequence(array, set)
    shortest.foreach(range => println(range.start + ", " + range.end))
  }
}
