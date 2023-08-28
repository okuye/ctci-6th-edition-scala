package Q8_03_Magic_Index

import CtCILibrary.AssortedMethods
import scala.util.Sorting

object QuestionB {

  def magicSlow(array: Array[Int]): Int = {
    for (i <- array.indices) {
      if (array(i) == i) {
        return i
      }
    }
    -1
  }

  def magicFast(array: Array[Int], start: Int, end: Int): Int = {
    if (end < start) {
      return -1
    }
    val midIndex = (start + end) / 2
    val midValue = array(midIndex)
    if (midValue == midIndex) {
      midIndex
    } else {
      /* Search left */
      val leftIndex = math.min(midIndex - 1, midValue)
      val left = magicFast(array, start, leftIndex)
      if (left >= 0) {
        return left
      }

      /* Search right */
      val rightIndex = math.max(midIndex + 1, midValue)
      magicFast(array, rightIndex, end)
    }
  }

  def magicFast(array: Array[Int]): Int = {
    magicFast(array, 0, array.length - 1)
  }

  /* Creates an array that is sorted */
  def getSortedArray(size: Int): Array[Int] = {
    val array = AssortedMethods.randomArray(size, -1 * size, size)
    Sorting.quickSort(array)
    array
  }

  def main(args: Array[String]): Unit = {
    for (_ <- 0 until 1000) {
      val size = AssortedMethods.randomIntInRange(5, 20)
      val array = getSortedArray(size)
      val v2 = magicFast(array)
      if (v2 == -1 && magicSlow(array) != -1) {
        val v1 = magicSlow(array)
        println(s"Incorrect value: index = -1, actual = $v1")
        println(AssortedMethods.arrayToString(array))
      } else if (v2 > -1 && array(v2) != v2) {
        println(s"Incorrect values: index= $v2, value ${array(v2)}")
        println(AssortedMethods.arrayToString(array))
      }
    }
  }
}
