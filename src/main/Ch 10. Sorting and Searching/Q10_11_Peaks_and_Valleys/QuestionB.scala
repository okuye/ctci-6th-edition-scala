package Q10_11_Peaks_and_Valleys

import CtCILibrary.AssortedMethods

object QuestionB {
  def swap(array: Array[Int], left: Int, right: Int): Unit = {
    val temp = array(left)
    array(left) = array(right)
    array(right) = temp
  }

  def sortValleyPeak(array: Array[Int]): Unit = {
    for (i <- 1 until array.length by 2) {
      val biggestIndex = maxIndex(array, i - 1, i, i + 1)
      if (i != biggestIndex) {
        swap(array, i, biggestIndex)
      }
    }
  }

  def maxIndex(array: Array[Int], a: Int, b: Int, c: Int): Int = {
    val len = array.length
    val aValue = if (a >= 0 && a < len) array(a) else Int.MinValue
    val bValue = if (b >= 0 && b < len) array(b) else Int.MinValue
    val cValue = if (c >= 0 && c < len) array(c) else Int.MinValue

    val max = Array(aValue, bValue, cValue).max

    if (aValue == max) a
    else if (bValue == max) b
    else c
  }

  def main(args: Array[String]): Unit = {
    val array = Array(48, 40, 31, 62, 28, 21, 64, 40, 23, 17)
    println(AssortedMethods.arrayToString(array))
    sortValleyPeak(array)
    println(AssortedMethods.arrayToString(array))
    println(Tester.confirmValleyPeak(array))
  }
}
