package Q2_02_Return_Kth_To_Last

import CtCILibrary.LinkedListNode
import CtCILibrary.AssortedMethods

object QuestionC {

  class Index {
    var value: Int = 0
  }

  def kthToLast(head: LinkedListNode, k: Int): LinkedListNode = {
    val idx = new Index()
    kthToLast(head, k, idx)
  }

  def kthToLast(head: LinkedListNode, k: Int, idx: Index): LinkedListNode = {
    if (head == null) {
      return null
    }
    val node = kthToLast(head.next, k, idx)
    idx.value += 1
    if (idx.value == k) {
      return head
    }
    node
  }

  def main(args: Array[String]): Unit = {
    val array = Array(0, 1, 2, 3, 4, 5, 6)
    val head = AssortedMethods.createLinkedListFromArray(array)
    for (i <- 0 to array.length + 1) {
      val node = kthToLast(head, i)
      val nodeValue = if (node == null) "null" else node.data.toString
      println(s"$i: $nodeValue")
    }
  }
}
