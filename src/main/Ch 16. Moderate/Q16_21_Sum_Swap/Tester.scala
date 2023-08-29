package Q16_21_Sum_Swap

import CtCILibrary.AssortedMethods

object Tester {

  def isEquivalent(a: Option[(Int, Int)], b: Option[(Int, Int)], c: Option[(Int, Int)], d: Option[(Int, Int)]): Boolean = {
    (a, b, c, d) match {
      case (Some(sa), Some(sb), Some(sc), Some(sd)) =>
        difference(sa) == difference(sb) && difference(sa) == difference(sc) && difference(sa) == difference(sd)
      case (None, None, None, None) => true
      case _ => false
    }
  }

  def difference(pair: (Int, Int)): Int = pair._1 - pair._2

  def arrayToString(array: Array[Int]): String = array.mkString(" ")

  def main(args: Array[String]): Unit = {
    var count = 0
    val max = 100
    while (count < max) {
      val array1 = AssortedMethods.randomArray(10, -10, 10)
      val array2 = AssortedMethods.randomArray(10, -10, 10)
      val swapsA = QuestionA.findSwapValues(array1, array2)
      val swapsB = QuestionB.findSwapValues(array1, array2)
      val swapsC = QuestionC.findSwapValues(array1, array2)
      val swapsD = QuestionD.findSwapValues(array1, array2)

      if (List(swapsA, swapsB, swapsC, swapsD).exists(_.isDefined)) {
        count += 1
      }

      if (!isEquivalent(swapsA, swapsB, swapsC, swapsD)) {
        println("Error")
        println(AssortedMethods.arrayToString(array1))
        println(AssortedMethods.arrayToString(array2))
        println(AssortedMethods.arrayToString(swapsA.toArray))
        println(AssortedMethods.arrayToString(swapsB.toArray))
        println(AssortedMethods.arrayToString(swapsC.toArray))
        println(AssortedMethods.arrayToString(swapsD.toArray))
      } else {
        println("Equivalent.")
        println(AssortedMethods.arrayToString(array1))
        println(AssortedMethods.arrayToString(array2))
        println(AssortedMethods.arrayToString(swapsA.toArray))
        println(AssortedMethods.arrayToString(swapsB.toArray))
        println(AssortedMethods.arrayToString(swapsC.toArray))
        println(AssortedMethods.arrayToString(swapsD.toArray))
        println("\n")
      }
    }
  }
}
