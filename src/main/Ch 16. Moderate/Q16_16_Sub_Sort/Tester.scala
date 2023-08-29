package Q16_16_Sub_Sort

import CtCILibrary.AssortedMethods

object Tester {

  def main(args: Array[String]): Unit = {
    for (_ <- 0 until 1000) {
      val array = AssortedMethods.randomArray(7, 1, 3)
      val r1 = Question.findUnsortedSequence(array)
      val r2 = Question.findUnsortedSequence(array)

      if (r1 != r2) {
        println("ERROR")
        println(AssortedMethods.arrayToString(array))
        println(r1)
        println(r2)
      }
    }
  }
}
