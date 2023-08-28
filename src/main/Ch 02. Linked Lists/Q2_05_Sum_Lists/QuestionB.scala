package Q2_05_Sum_Lists

import CtCILibrary.LinkedListNode

object QuestionB {
  private class PartialSum {
    var sum: LinkedListNode = _
    var carry: Int = 0
  }

  private def length(l: LinkedListNode): Int = {
    if (l == null) {
      0
    } else {
      1 + length(l.next)
    }
  }

  private def addListsHelper(
      l1: LinkedListNode,
      l2: LinkedListNode
  ): PartialSum = {
    if (l1 == null && l2 == null) {
      new PartialSum()
    } else {
      val sum = addListsHelper(l1.next, l2.next)
      val valSum = sum.carry + l1.data + l2.data
      val fullResult = insertBefore(sum.sum, valSum % 10)
      sum.sum = fullResult
      sum.carry = valSum / 10
      sum
    }
  }

  private def addLists(
      l1: LinkedListNode,
      l2: LinkedListNode
  ): LinkedListNode = {
    val len1 = length(l1)
    val len2 = length(l2)
    var list1 = l1
    var list2 = l2
    if (len1 < len2) {
      list1 = padList(list1, len2 - len1)
    } else {
      list2 = padList(list2, len1 - len2)
    }
    val sum = addListsHelper(list1, list2)
    if (sum.carry == 0) {
      sum.sum
    } else {
      val result = insertBefore(sum.sum, sum.carry)
      result
    }
  }

  private def padList(l: LinkedListNode, padding: Int): LinkedListNode = {
    var head = l
    for (_ <- 0 until padding) {
      head = insertBefore(head, 0)
    }
    head
  }

  private def insertBefore(list: LinkedListNode, data: Int): LinkedListNode = {
    val node = new LinkedListNode(data)
    if (list != null) {
      node.next = list
    }
    node
  }

  private def linkedListToInt(node: LinkedListNode): Int = {
    var value = 0
    var current = node
    while (current != null) {
      value = value * 10 + current.data
      current = current.next
    }
    value
  }

  def main(args: Array[String]): Unit = {
    val lA1 = new LinkedListNode(3, null, null)
    val lA2 = new LinkedListNode(1, null, lA1)

    val lB1 = new LinkedListNode(5, null, null)
    val lB2 = new LinkedListNode(9, null, lB1)
    val lB3 = new LinkedListNode(1, null, lB2)

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
