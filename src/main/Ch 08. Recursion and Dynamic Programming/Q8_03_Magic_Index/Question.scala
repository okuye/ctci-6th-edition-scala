package Q8_03_Magic_Index

import CtCILibrary.AssortedMethods
import scala.util.Sorting

object Question {

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
    val mid = (start + end) / 2
    if (array(mid) == mid) {
      mid
    } else if (array(mid) > mid) {
      magicFast(array, start, mid - 1)
    } else {
      magicFast(array, mid + 1, end)
    }
  }

  def magicFast(array: Array[Int]): Int = {
    magicFast(array, 0, array.length - 1)
  }

  def getDistinctSortedArray(size: Int): Array[Int] = {
    val array = AssortedMethods.randomArray(size, -1 * size, size)
    Sorting.quickSort(array)
    for (i <- 1 until array.length) {
      if (array(i) == array(i - 1)) {
        array(i) += 1
      } else if (array(i) < array(i - 1)) {
        array(i) = array(i - 1) + 1
      }
    }
    array
  }

  def main(args: Array[String]): Unit = {
    for (_ <- 0 until 1000) {
      val size = AssortedMethods.randomIntInRange(5, 20)
      val array = getDistinctSortedArray(size)
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
