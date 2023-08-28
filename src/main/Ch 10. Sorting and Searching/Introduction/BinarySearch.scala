package Introduction

object BinarySearch {

  def binarySearch(a: Array[Int], x: Int): Int = {
    var low = 0
    var high = a.length - 1
    var mid = 0

    while (low <= high) {
      mid = low + (high - low) / 2
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

  def binarySearchRecursive(a: Array[Int], x: Int, low: Int, high: Int): Int = {
    if (low > high) return -1

    val mid = (low + high) / 2
    if (a(mid) < x) {
      binarySearchRecursive(a, x, mid + 1, high)
    } else if (a(mid) > x) {
      binarySearchRecursive(a, x, low, mid - 1)
    } else {
      mid
    }
  }

  def binarySearchRecursiveClosest(a: Array[Int], x: Int, low: Int, high: Int): Int = {
    if (low > high) {
      if (high < 0) return low
      if (low >= a.length) return high
      if (x - a(high) < a(low) - x) {
        return high
      }
      return low
    }

    val mid = (low + high) / 2
    if (a(mid) < x) {
      binarySearchRecursiveClosest(a, x, mid + 1, high)
    } else if (a(mid) > x) {
      binarySearchRecursiveClosest(a, x, low, mid - 1)
    } else {
      mid
    }
  }

  def main(args: Array[String]): Unit = {
    val array = Array(3, 6, 9, 12, 15, 18)
    for (i <- 0 until 20) {
      val loc = binarySearch(array, i)
      val loc2 = binarySearchRecursive(array, i, 0, array.length - 1)
      val loc3 = binarySearchRecursiveClosest(array, i, 0, array.length - 1)
      println(s"$i: $loc $loc2 $loc3")
    }
  }
}
