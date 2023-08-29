package Q17_18_Shortest_Supersequence

import CtCILibrary.AssortedMethods

object Tester {

  def equivalent(ranges: Array[Range]): Boolean = {
    if (ranges(0) == null) {
      ranges.forall(_ == null)
    } else {
      val targetLength = ranges(0).length
      ranges.forall(r => {
        val length = if (r == null) 0 else r.length
        targetLength == length
      })
    }
  }

  def main(args: Array[String]): Unit = {
    for (i <- 0 until 100) {
      val array = AssortedMethods.randomArray(i, 0, 15)
      val set = Array(0, 5, 8, 10)

      val ranges = Array(
        QuestionA.shortestSupersequence(array, set),
        QuestionB.shortestSupersequence(array, set),
        QuestionC.shortestSupersequence(array, set),
        QuestionD.shortestSupersequence(array, set),
        QuestionE.shortestSupersequence(array, set)
      )

      if (!equivalent(ranges)) {
        println("Mismatching.")
      } else {
        val length = if (ranges(0) == null) 0 else ranges(0).length
        println(s"Matching: $length")
      }
    }
  }
}
