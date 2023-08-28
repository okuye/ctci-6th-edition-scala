package Q10_11_Peaks_and_Valleys

import CtCILibrary.AssortedMethods

object Tester {
  def confirmValleyPeak(array: Array[Int]): Boolean = {
    for (i <- 1 until array.length - 1) {
      val prev = array(i - 1)
      val curr = array(i)
      val next = array(i + 1)
      if (!((prev <= curr && curr >= next) || (prev >= curr && curr <= next))) {
        return false
      }
    }
    true
  }

  def main(args: Array[String]): Unit = {
    for (_ <- 0 until 100) {
      val originalArray = AssortedMethods.randomArray(10, 0, 100)
      val arrayA = originalArray.clone()
      val arrayB = originalArray.clone()
      val arrayC = originalArray.clone()

      QuestionA.sortValleyPeak(arrayA)
      QuestionB.sortValleyPeak(arrayB)
      QuestionC.sortValleyPeak(arrayC)

      if (!confirmValleyPeak(arrayA) || !confirmValleyPeak(arrayB) || !confirmValleyPeak(arrayC)) {
        println(AssortedMethods.arrayToString(originalArray))
        println(AssortedMethods.arrayToString(arrayA))
        println(AssortedMethods.arrayToString(arrayB))
        println(AssortedMethods.arrayToString(arrayC))
        println(confirmValleyPeak(arrayA))
        println(confirmValleyPeak(arrayB))
        println(confirmValleyPeak(arrayC))
        return
      }
    }
  }
}
