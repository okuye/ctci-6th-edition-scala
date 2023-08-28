package Q2_04_Partition

import CtCILibrary.LinkedListNode

object QuestionC {

  def partition(node: LinkedListNode, x: Int): LinkedListNode = {
    var head = node
    var tail = node

    var currentNode = node
    while (currentNode != null) {
      val next = currentNode.next
      if (currentNode.data < x) {
        currentNode.next = head
        head = currentNode
      } else {
        tail.next = currentNode
        tail = currentNode
      }
      currentNode = next
    }
    tail.next = null

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

    val h = partition(head, 8)
    println(h.printForward())
  }
}
