package Q2_06_Palindrome

import CtCILibrary.LinkedListNode

object Tester {

  def main(args: Array[String]): Unit = {
    val max = 11
    for (length <- 1 until max) {
      val nodes = new Array[LinkedListNode](length)
      for (i <- 0 until length) {
        nodes(i) = new LinkedListNode(if (i >= length / 2) length - i - 1 else i, null, null)
      }

      for (i <- 0 until length) {
        if (i < length - 1) {
          nodes(i).setNext(nodes(i + 1))
        }
        if (i > 0) {
          nodes(i).setPrevious(nodes(i - 1))
        }
      }
      for (i <- -1 until length) {
        if (i >= 0) {
          nodes(i).data += 1 // Ruin palindrome
        }

        val head = nodes(0)
        println(head.printForward())
        val resultA = QuestionA.isPalindrome(head)
        val resultB = QuestionB.isPalindrome(head)
        val resultC = QuestionC.isPalindrome(head)
        println("A: " + resultA)
        println("B: " + resultB)
        println("C: " + resultC)
        if (resultA != resultB || resultB != resultC) {
          println("ERROR")
          return // exit the loop
        }
        if (i >= 0) {
          nodes(i).data -= 1
        }
      }
    }
  }
}
