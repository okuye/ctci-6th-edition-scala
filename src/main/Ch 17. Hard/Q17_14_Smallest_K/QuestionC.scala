package Q17_14_Smallest_K

import scala.util.Random

object QuestionC {

  def smallestK(array: Array[Int], k: Int): Array[Int] = {
    if (k <= 0 || k > array.length) throw new IllegalArgumentException()

    val threshold = rank(array, k - 1)
    val smallest = Array.fill(k)(0)
    var count = 0
    for (a <- array) {
      if (a <= threshold) {
        smallest(count) = a
        count += 1
      }
    }
    smallest
  }

  def rank(array: Array[Int], rnk: Int): Int = {
    rank(array, 0, array.length - 1, rnk)
  }

  def rank(array: Array[Int], left: Int, right: Int, rnk: Int): Int = {
    val pivot = array(randomIntInRange(left, right))
    val leftEnd = partition(array, left, right, pivot)
    val leftSize = leftEnd - left + 1
    if (rnk == leftSize - 1) max(array, left, leftEnd)
    else if (rnk < leftSize) rank(array, left, leftEnd, rnk)
    else rank(array, leftEnd + 1, right, rnk - leftSize)
  }

  def partition(array: Array[Int], left: Int, right: Int, pivot: Int): Int = {
    var l = left
    var r = right
    while (l <= r) {
      if (array(l) > pivot) {
        swap(array, l, r)
        r -= 1
      } else if (array(r) <= pivot) {
        swap(array, l, r)
        l += 1
      } else {
        l += 1
        r -= 1
      }
    }
    l - 1
  }

  def randomIntInRange(min: Int, max: Int): Int = {
    Random.nextInt(max + 1 - min) + min
  }

  def swap(array: Array[Int], i: Int, j: Int): Unit = {
    val t = array(i)
    array(i) = array(j)
    array(j) = t
  }

  def max(array: Array[Int], left: Int, right: Int): Int = {
    var maxVal = Int.MinValue
    for (i <- left to right) {
      maxVal = Math.max(array(i), maxVal)
    }
    maxVal
  }

  def main(args: Array[String]): Unit = {
    val array = Array(1, 5, 2, 9, -1, 11, 6, 13, 15)
    val smallest = smallestK(array, 3)
    println(smallest.mkString(", "))
  }

}
