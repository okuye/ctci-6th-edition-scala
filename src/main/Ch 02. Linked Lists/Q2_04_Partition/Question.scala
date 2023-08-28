package Q2_04_Partition

import CtCILibrary.LinkedListNode

object Question {

  def partition(node: LinkedListNode, x: Int): LinkedListNode = {
    var beforeStart: LinkedListNode = null
    var beforeEnd: LinkedListNode = null
    var afterStart: LinkedListNode = null
    var afterEnd: LinkedListNode = null

    var currentNode = node
    while (currentNode != null) {
      val next = currentNode.next
      currentNode.next = null
      if (currentNode.data < x) {
        if (beforeStart == null) {
          beforeStart = currentNode
          beforeEnd = beforeStart
        } else {
          beforeEnd.next = currentNode
          beforeEnd = currentNode
        }
      } else {
        if (afterStart == null) {
          afterStart = currentNode
          afterEnd = afterStart
        } else {
          afterEnd.next = currentNode
          afterEnd = currentNode
        }
      }
      currentNode = next
    }

    if (beforeStart == null) {
      return afterStart
    }

    beforeEnd.next = afterStart
    beforeStart
  }

  def main(args: Array[String]): Unit = {
    val vals = Array(33, 9, 2, 3, 10, 10389, 838, 874578, 5)
    val head = new LinkedListNode(vals(0), null, null)
    var current = head
    for (i <- 1 until vals.length) {
      current = new LinkedListNode(vals(i), null, current)
    }
    println(head.printForward())

    val h = partition(head, 3)

    println(h.printForward())
  }
}
