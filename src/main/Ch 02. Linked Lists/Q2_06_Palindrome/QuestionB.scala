package Q2_06_Palindrome

import CtCILibrary.LinkedListNode
import scala.collection.mutable.Stack

object QuestionB {
  def isPalindrome(head: LinkedListNode): Boolean = {
    var fast = head
    var slow = head

    val stack = Stack[Int]()

    while (fast != null && fast.next != null) {
      stack.push(slow.data)
      slow = slow.next
      fast = fast.next.next
    }

    // Has odd number of elements, so skip the middle
    if (fast != null) {
      slow = slow.next
    }

    while (slow != null) {
      val top = stack.pop()
      if (top != slow.data) {
        return false
      }
      slow = slow.next
    }
    true
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
