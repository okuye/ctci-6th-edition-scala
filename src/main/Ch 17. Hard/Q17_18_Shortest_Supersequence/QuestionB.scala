package Q17_18_Shortest_Supersequence

import scala.collection.mutable.ArrayBuffer

object QuestionB {
  def getNextElement(bigArray: Array[Int], value: Int): Array[Int] = {
    var next = -1
    val nexts = new Array[Int](bigArray.length)
    for (i <- bigArray.length - 1 to 0 by -1) {
      if (bigArray(i) == value) {
        next = i
      }
      nexts(i) = next
    }
    nexts
  }

  def getNextElementsMulti(big: Array[Int], small: Array[Int]): Array[Array[Int]] = {
    val nextElements = new Array[Array[Int]](small.length)
    for (i <- 0 until small.length) {
      nextElements(i) = getNextElement(big, small(i))
    }
    nextElements
  }

  def getClosureForIndex(nextElements: Array[Array[Int]], index: Int): Int = {
    var max = -1
    for (i <- 0 until nextElements.length) {
      if (nextElements(i)(index) == -1) {
        return -1
      }
      max = math.max(max, nextElements(i)(index))
    }
    max
  }

  def getClosures(nextElements: Array[Array[Int]]): Array[Int] = {
    val maxNextElement = new Array[Int](nextElements(0).length)
    for (i <- 0 until nextElements(0).length) {
      maxNextElement(i) = getClosureForIndex(nextElements, i)
    }
    maxNextElement
  }

  case class Range(start: Int, end: Int)

  def getShortestClosure(closures: Array[Int]): Option[Range] = {
    var bestStart = -1
    var bestEnd = -1
    for (i <- 0 until closures.length) {
      if (closures(i) == -1) {
        return None
      }
      val current = closures(i) - i
      if (bestStart == -1 || current < bestEnd - bestStart) {
        bestStart = i
        bestEnd = closures(i)
      }
    }
    if (bestStart < 0 || bestEnd < 0) {
      None
    } else {
      Some(Range(bestStart, bestEnd))
    }
  }

  def shortestSupersequence(big: Array[Int], small: Array[Int]): Option[Range] = {
    val nextElements = getNextElementsMulti(big, small)
    val closures = getClosures(nextElements)
    getShortestClosure(closures)
  }

  def main(args: Array[String]): Unit = {
    val array = Array(9, 5, 1, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 9, 7)
    val set = Array(1, 5, 9)
    println(array.length)
    val shortest = shortestSupersequence(array, set)
    shortest.foreach(range => println(range.start + ", " + range.end))
  }
}

