package Q17_05_Letters_and_Numbers

import scala.collection.mutable

object QuestionB {
  def computeDeltaArray(array: Array[Char]): Array[Int] = {
    val deltas = new Array[Int](array.length)
    var delta = 0
    for (i <- array.indices) {
      if (array(i).isLetter) delta += 1
      else if (array(i).isDigit) delta -= 1
      deltas(i) = delta
    }
    deltas
  }

  def findLongestMatch(deltas: Array[Int]): Array[Int] = {
    val map = mutable.HashMap[Int, Int]()
    map.put(0, -1)
    val max = Array(0, 0)
    for (i <- deltas.indices) {
      if (!map.contains(deltas(i))) {
        map.put(deltas(i), i)
      } else {
        val matchIndex = map(deltas(i))
        val distance = i - matchIndex
        val longest = max(1) - max(0)
        if (distance > longest) {
          max(1) = i
          max(0) = matchIndex
        }
      }
    }
    max
  }

  def extract(array: Array[Char], start: Int, end: Int): Array[Char] = {
    if (start > end) return Array.emptyCharArray
    array.slice(start, end + 1)
  }

  def findLongestSubarray(array: Array[Char]): Array[Char] = {
    val deltas = computeDeltaArray(array)
    val matchIndices = findLongestMatch(deltas)
    extract(array, matchIndices(0) + 1, matchIndices(1))
  }

  def isEqual(array: Array[Char], start: Int, end: Int): Boolean = {
    var counter = 0
    for (i <- start until end) {
      if (array(i).isLetter) counter += 1
      else if (array(i).isDigit) counter -= 1
    }
    counter == 0
  }

  def main(args: Array[String]): Unit = {
    val b = '1'
    val a = 'a'
    val array = Array(a, b, a, b, a, b, b, b, b, b, a, a, a, a, a, b, a, b, a, b, b, a, a, a, a, a, a, a)
    array.foreach(ch => print(s"$ch "))
    println()

    val max = findLongestSubarray(array)
    if (max.isEmpty) {
      println("No equal subarray")
    } else {
      println(max.length)
      max.foreach(ch => print(s"$ch "))
      println(s"\nIs Valid? ${isEqual(max, 0, max.length)}")
    }
  }
}
