package Q2_05_Sum_Lists

import CtCILibrary.LinkedListNode

object QuestionA {

  private def addLists(l1: LinkedListNode, l2: LinkedListNode): LinkedListNode = {
    addLists(l1, l2, 0)
  }

  private def addLists(l1: LinkedListNode, l2: LinkedListNode, carry: Int): LinkedListNode = {
    if (l1 == null && l2 == null && carry == 0) {
      return null
    }

    val result = new LinkedListNode()
    var value = carry
    if (l1 != null) {
      value += l1.data
    }
    if (l2 != null) {
      value += l2.data
    }
    result.data = value % 10
    if (l1 != null || l2 != null) {
      val more = addLists(if (l1 == null) null else l1.next,
        if (l2 == null) null else l2.next,
        if (value >= 10) 1 else 0)
      result.setNext(more)
    }
    result
  }

  private def linkedListToInt(node: LinkedListNode): Int = {
    if (node.next != null) {
      10 * linkedListToInt(node.next)
    } else {
      node.data
    }
  }

  def main(args: Array[String]): Unit = {
    val lA1 = new LinkedListNode(9, null, null)
    val lA2 = new LinkedListNode(9, null, lA1)
    val lA3 = new LinkedListNode(9, null, lA2)

    val lB1 = new LinkedListNode(1, null, null)
    val lB2 = new LinkedListNode(0, null, lB1)
    val lB3 = new LinkedListNode(0, null, lB2)

    val list3 = addLists(lA1, lB1)

    println("  " + lA1.printForward())
    println("+ " + lB1.printForward())
    println("= " + list3.printForward())

    val l1 = linkedListToInt(lA1)
    val l2 = linkedListToInt(lB1)
    val l3 = linkedListToInt(list3)

    println(s"$l1 + $l2 = $l3")
    println(s"$l1 + $l2 = ${l1 + l2}")
  }
}
