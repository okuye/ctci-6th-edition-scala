package Q2_02_Return_Kth_To_Last

import CtCILibrary.LinkedListNode
import CtCILibrary.AssortedMethods

object QuestionD {

  def nthToLast(head: LinkedListNode, k: Int): LinkedListNode = {
    var p1 = head
    var p2 = head

    // Move p1 k nodes into the list.
    for (_ <- 0 until k) {
      if (p1 == null) return null // Out of bounds
      p1 = p1.next
    }

    // Move them at the same pace. When p1 hits the end, p2 will be at the right element.
    while (p1 != null) {
      p1 = p1.next
      p2 = p2.next
    }
    p2
  }

  def main(args: Array[String]): Unit = {
    val array = Array(0, 1, 2, 3)
    val head = AssortedMethods.createLinkedListFromArray(array)
    for (i <- 0 to array.length + 1) {
      val node = nthToLast(head, i)
      val nodeValue = if (node == null) "null" else node.data.toString
      println(s"$i: $nodeValue")
    }
  }
}
