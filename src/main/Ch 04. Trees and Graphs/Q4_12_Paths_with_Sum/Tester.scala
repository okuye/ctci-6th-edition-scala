package Q4_12_Paths_with_Sum

import CtCILibrary.{AssortedMethods, TreeNode}

object Tester extends App {

  var isWorking = true

  while (isWorking) {
    val min = -20
    val max = 20
    val size = 20
    val root = AssortedMethods.randomBST(size, min, max)

    for (
      targetSum <- Math
        .min(-1, min * size - 10) to Math.max(100, max * size + 10)
    ) {
      val answerA = QuestionA.countPathsWithSum(root, targetSum)
      val answerB = QuestionB.countPathsWithSum(root, targetSum)

      if (answerA > 0 || answerB > 0) {
        println(s"$targetSum: $answerA, $answerB | ${answerA == answerB}")
      }

      if (answerA != answerB) {
        isWorking = false
      }
    }
  }
}
