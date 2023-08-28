package Q2_01_Remove_Dups

import scala.collection.mutable.HashSet
import CtCILibrary.LinkedListNode

object QuestionA {

  def deleteDups(n: LinkedListNode): Unit = {
    val set = new HashSet[Int]()
    var previous: LinkedListNode = null
    var current = n

    while (current != null) {
      if (set.contains(current.data)) {
        previous.next = current.next
      } else {
        set.add(current.data)
        previous = current
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
