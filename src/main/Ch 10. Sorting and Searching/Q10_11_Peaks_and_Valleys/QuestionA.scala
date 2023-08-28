package Q10_11_Peaks_and_Valleys

import scala.util.Sorting
import CtCILibrary.AssortedMethods

object QuestionA {
  def sortValleyPeak(array: Array[Int]): Unit = {
    Sorting.quickSort(array)
    for (i <- 1 until array.length by 2) {
      swap(array, i - 1, i)
    }
  }

  def swap(array: Array[Int], left: Int, right: Int): Unit = {
    val temp = array(left)
    array(left) = array(right)
    array(right) = temp
  }

  def main(args: Array[String]): Unit = {
    val array = Array(48, 40, 31, 62, 28, 21, 64, 40, 23, 17)
    println(AssortedMethods.arrayToString(array))
    sortValleyPeak(array)
    println(AssortedMethods.arrayToString(array))
    println(Tester.confirmValleyPeak(array))
  }
}
