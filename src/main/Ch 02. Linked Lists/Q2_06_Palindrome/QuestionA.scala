package Q2_06_Palindrome

import CtCILibrary.LinkedListNode

object QuestionA {
  def isPalindrome(head: LinkedListNode): Boolean = {
    val reversed = reverseAndClone(head)
    isEqual(head, reversed)
  }

  def reverseAndClone(node: LinkedListNode): LinkedListNode = {
    var head: LinkedListNode = null
    var currentNode = node
    while (currentNode != null) {
      val n = new LinkedListNode(currentNode.data) // Clone
      n.next = head
      head = n
      currentNode = currentNode.next
    }
    head
  }

  def isEqual(one: LinkedListNode, two: LinkedListNode): Boolean = {
    var node1 = one
    var node2 = two
    while (node1 != null && node2 != null) {
      if (node1.data != node2.data) {
        return false
      }
      node1 = node1.next
      node2 = node2.next
    }
    node1 == null && node2 == null
  }

  def main(args: Array[String]): Unit = {
    val length = 9
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
    // Uncomment to ruin palindrome
    // nodes(length - 2).data = 9

    val head = nodes(0)
    println(head.printForward())
    println(isPalindrome(head))
  }
}
