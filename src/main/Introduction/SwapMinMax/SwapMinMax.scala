package SwapMinMax

import scala.util.control.Breaks._

object SwapMinMax {
  def getMinIndex(array: Array[Int]): Int = {
    var minIndex = 0
    for (i <- 1 until array.length) {
      if (array(i) < array(minIndex)) {
        minIndex = i
      }
    }
    minIndex
  }

  def getMaxIndex(array: Array[Int]): Int = {
    var maxIndex = 0
    for (i <- 1 until array.length) {
      if (array(i) > array(maxIndex)) {
        maxIndex = i
      }
    }
    maxIndex
  }

  def swap(array: Array[Int], m: Int, n: Int): Unit = {
    val temp = array(m)
    array(m) = array(n)
    array(n) = temp
  }

  def swapMinMaxBetter(array: Array[Int]): Unit = {
    val minIndex = getMinIndex(array)
    val maxIndex = getMaxIndex(array)
    swap(array, minIndex, maxIndex)
  }

  def swapMinMax(array: Array[Int]): Unit = {
    var minIndex = 0
    for (i <- 1 until array.length) {
      if (array(i) < array(minIndex)) {
        minIndex = i
      }
    }

    var maxIndex = 0
    for (i <- 1 until array.length) {
      if (array(i) > array(maxIndex)) {
        maxIndex = i
      }
    }

    val temp = array(minIndex)
    array(minIndex) = array(maxIndex)
    array(maxIndex) = temp
  }

  def main(args: Array[String]): Unit = {
    val array = Array(1, 3, 5, 7, 9)
    println(array.mkString(", "))
    swapMinMaxBetter(array)
    println(array.mkString(", "))
  }
}
