package Q2_02_Return_Kth_To_Last

import CtCILibrary.LinkedListNode
import CtCILibrary.AssortedMethods

object QuestionA {

  def printKthToLast(head: LinkedListNode, k: Int): Int = {
    if (head == null) {
      return 0
    }
    val index = printKthToLast(head.next, k) + 1
    if (index == k) {
      println(s"${k}th to last node is ${head.data}")
    }
    index
  }

  def main(args: Array[String]): Unit = {
    val array = Array(0, 1, 2, 3, 4, 5, 6)
    val head = AssortedMethods.createLinkedListFromArray(array)
    for (i <- 0 to array.length + 1) {
      printKthToLast(head, i)
    }
  }
}
