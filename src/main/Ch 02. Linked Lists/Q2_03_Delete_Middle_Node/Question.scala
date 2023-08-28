package Q2_03_Delete_Middle_Node

import CtCILibrary.{AssortedMethods, LinkedListNode}

object Question {

  def deleteNode(n: LinkedListNode): Boolean = {
    if (n == null || n.next == null) {
      return false // Failure
    }
    val next = n.next
    n.data = next.data
    n.next = next.next
    true
  }

  def main(args: Array[String]): Unit = {
    val head = AssortedMethods.randomLinkedList(10, 0, 10)
    println(head.printForward())
    deleteNode(head.next.next.next.next) // delete node 4
    println(head.printForward())
  }
}
