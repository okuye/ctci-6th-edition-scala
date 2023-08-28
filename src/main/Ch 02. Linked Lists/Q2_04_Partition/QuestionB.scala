package Q2_04_Partition

import CtCILibrary.LinkedListNode

object QuestionB {

  def partition(node: LinkedListNode, x: Int): LinkedListNode = {
    var beforeStart: LinkedListNode = null
    var afterStart: LinkedListNode = null

    var currentNode = node
    while (currentNode != null) {
      val next = currentNode.next
      if (currentNode.data < x) {
        currentNode.next = beforeStart
        beforeStart = currentNode
      } else {
        currentNode.next = afterStart
        afterStart = currentNode
      }
      currentNode = next
    }

    if (beforeStart == null) {
      return afterStart
    }

    var head = beforeStart
    while (beforeStart.next != null) {
      beforeStart = beforeStart.next
    }
    beforeStart.next = afterStart
    head
  }

  def main(args: Array[String]): Unit = {
    val length = 20
    val nodes = Array.ofDim[LinkedListNode](length)
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

    val head = nodes(0)
    println(head.printForward())

    val h = partition(head, 7)
    println(h.printForward())
  }
}
