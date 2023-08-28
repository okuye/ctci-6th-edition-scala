package Q10_11_Peaks_and_Valleys

import CtCILibrary.AssortedMethods

object QuestionC {
  def swap(array: Array[Int], left: Int, right: Int): Unit = {
    val temp = array(left)
    array(left) = array(right)
    array(right) = temp
  }

  def sortValleyPeak(array: Array[Int]): Unit = {
    for (i <- 1 until array.length by 2) {
      if (array(i - 1) < array(i)) {
        swap(array, i - 1, i)
      }
      if (i + 1 < array.length && array(i + 1) < array(i)) {
        swap(array, i + 1, i)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val array = Array(5, 3, 1, 2, 3)
    println(AssortedMethods.arrayToString(array))
    sortValleyPeak(array)
    println(AssortedMethods.arrayToString(array))
    println(Tester.confirmValleyPeak(array))
  }
}
