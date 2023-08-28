package Q2_06_Palindrome

import CtCILibrary.LinkedListNode

object QuestionC {
  class Result(val node: LinkedListNode, val result: Boolean)

  def isPalindromeRecurse(head: LinkedListNode, length: Int): Result = {
    if (head == null || length <= 0) {
      return new Result(head, true) // Even number of nodes
    } else if (length == 1) {
      return new Result(head.next, true) // Odd number of nodes
    }

    val res = isPalindromeRecurse(head.next, length - 2) // Recurse on sublist

    if (!res.result || res.node == null) {
      return res // Pass back a failure
    }

    val isMatch = head.data == res.node.data // Check if matches corresponding node on the other side
    val nextNode = res.node.next // Return corresponding node

    new Result(nextNode, isMatch && res.result)
  }

  def lengthOfList(n: LinkedListNode): Int = {
    var size = 0
    var current = n
    while (current != null) {
      size += 1
      current = current.next
    }
    size
  }

  def isPalindrome(head: LinkedListNode): Boolean = {
    val length = lengthOfList(head)
    val p = isPalindromeRecurse(head, length)
    p.result
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
