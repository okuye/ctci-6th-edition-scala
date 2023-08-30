package Big_O

import scala.annotation.tailrec
import scala.util.control.Breaks._

object Q_12 {
  def binarySearch(a: Array[Int], x: Int): Int = {
    var low = 0
    var high = a.length - 1
    var mid = 0

    while (low <= high) {
      mid = (low + high) / 2
      if (a(mid) < x) {
        low = mid + 1
      } else if (a(mid) > x) {
        high = mid - 1
      } else {
        return mid
      }
    }
    -1
  }

  def mergesort(array: Array[Int]): Unit = {
    val helper = new Array[Int](array.length)
    mergesort(array, helper, 0, array.length - 1)
  }

  def mergesort(
      array: Array[Int],
      helper: Array[Int],
      low: Int,
      high: Int
  ): Unit = {
    if (low < high) {
      val middle = (low + high) / 2
      mergesort(array, helper, low, middle) // Sort left half
      mergesort(array, helper, middle + 1, high) // Sort right half
      merge(array, helper, low, middle, high) // Merge them
    }
  }

  def merge(
      array: Array[Int],
      helper: Array[Int],
      low: Int,
      middle: Int,
      high: Int
  ): Unit = {
    for (i <- low to high) {
      helper(i) = array(i)
    }

    var helperLeft = low
    var helperRight = middle + 1
    var current = low

    while (helperLeft <= middle && helperRight <= high) {
      if (helper(helperLeft) <= helper(helperRight)) {
        array(current) = helper(helperLeft)
        helperLeft += 1
      } else {
        array(current) = helper(helperRight)
        helperRight += 1
      }
      current += 1
    }

    val remaining = middle - helperLeft
    for (i <- 0 to remaining) {
      array(current + i) = helper(helperLeft + i)
    }
  }

  def intersection(a: Array[Int], b: Array[Int]): Int = {
    mergesort(b)
    var intersect = 0

    for (x <- a) {
      if (binarySearch(b, x) >= 0) {
        intersect += 1
      }
    }

    intersect
  }

  def main(args: Array[String]): Unit = {
    val a = Array(1, 3, 5, 7)
    val b = Array(1, 9, 2, 7)
    val x = intersection(a, b)
    println(x)
  }
}
