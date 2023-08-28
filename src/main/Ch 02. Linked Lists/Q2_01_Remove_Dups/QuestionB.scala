package Q2_01_Remove_Dups

import CtCILibrary.LinkedListNode

object QuestionB {

  def deleteDups(head: LinkedListNode): Unit = {
    var current = head
    while (current != null) {
      // Remove all future nodes that have the same value
      var runner = current
      while (runner.next != null) {
        if (runner.next.data == current.data) {
          runner.next = runner.next.next
        } else {
          runner = runner.next
        }
      }
      current = current.next
    }
  }

  def main(args: Array[String]): Unit = {
    val first = new LinkedListNode(0, null, null)
    var head = first
    var second = first
    var current = first  // Use a separate variable for iteration

    for (i <- 1 until 8) {
      second = new LinkedListNode(i % 2, null, null)
      current.setNext(second)
      second.setPrevious(current)
      current = second
    }

    println(head.printForward())
    deleteDups(head)
    println(head.printForward())
  }
}
