package Q17_14_Smallest_K

import CtCILibrary.AssortedMethods
import scala.util.Random

object QuestionD {

  case class PartitionResult(leftSize: Int, middleSize: Int)

  def smallestK(array: Array[Int], k: Int): Array[Int] = {
    if (k <= 0 || k > array.length) throw new IllegalArgumentException()

    val threshold = rank(array, k - 1)
    val smallest = Array.fill(k)(0)
    var count = 0
    for (a <- array) {
      if (a < threshold) {
        smallest(count) = a
        count += 1
      }
    }

    while (count < k) {
      smallest(count) = threshold
      count += 1
    }

    smallest
  }

  def rank(array: Array[Int], k: Int): Int = {
    if (k >= array.length) throw new IllegalArgumentException()
    rank(array, k, 0, array.length - 1)
  }

  private def rank(array: Array[Int], k: Int, start: Int, end: Int): Int = {
    val pivot = array(randomIntInRange(start, end))
    val partition = partition(array, start, end, pivot)
    val leftSize = partition.leftSize
    val middleSize = partition.middleSize

    if (k < leftSize) rank(array, k, start, start + leftSize - 1)
    else if (k < leftSize + middleSize) pivot
    else rank(array, k - leftSize - middleSize, start + leftSize + middleSize, end)
  }

  private def partition(array: Array[Int], start: Int, end: Int, pivot: Int): PartitionResult = {
    var left = start
    var right = end
    var middle = start
    while (middle <= right) {
      if (array(middle) < pivot) {
        swap(array, middle, left)
        middle += 1
        left += 1
      } else if (array(middle) > pivot) {
        swap(array, middle, right)
        right -= 1
      } else {
        middle += 1
      }
    }
    PartitionResult(left - start, right - left + 1)
  }

  def randomIntInRange(min: Int, max: Int): Int = {
    Random.nextInt(max + 1 - min) + min
  }

  def swap(array: Array[Int], i: Int, j: Int): Unit = {
    val t = array(i)
    array(i) = array(j)
    array(j) = t
  }

  def main(args: Array[String]): Unit = {
    val array = Array(1, 5, 2, 3, 2, 9, -1, 11, 6, 13, 15, 2)
    val smallest = smallestK(array, 6)
    println(AssortedMethods.arrayToString(smallest))
  }

}
