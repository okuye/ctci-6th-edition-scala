package Q2_01_Remove_Dups

import CtCILibrary.LinkedListNode

object QuestionC {

  def deleteDups(head: LinkedListNode): Unit = {
    if (head == null) return
    var previous = head
    var current = previous.next
    while (current != null) {
      // Look backwards for dups, and remove any that you see.
      var runner = head
      while (runner != current) {
        if (runner.data == current.data) {
          val tmp = current.next
          previous.next = tmp
          current = tmp
          // We know we can't have more than one dup preceding
          // our element since it would have been removed earlier.
          runner = current // to break out of the loop
        } else {
          runner = runner.next
        }
      }

      // If runner == current, then we didn't find any duplicate
      // elements in the previous for loop. We then need to increment current.
      // If runner != current, then we must have hit the break condition,
      // in which case we found a dup and current has already been incremented.
      if (runner == current) {
        previous = current
        current = current.next
      }
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
