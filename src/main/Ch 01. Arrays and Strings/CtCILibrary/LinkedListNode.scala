package CtCILibrary

class LinkedListNode(var data: Int = 0, var next: LinkedListNode = null, var prev: LinkedListNode = null) {
  var last: LinkedListNode = _

  def setNext(n: LinkedListNode): Unit = {
    next = n
    if (this == last) {
      last = n
    }
    if (n != null && n.prev != this) {
      n.setPrevious(this)
    }
  }

  def setPrevious(p: LinkedListNode): Unit = {
    prev = p
    if (p != null && p.next != this) {
      p.setNext(this)
    }
  }

  def printForward(): String = {
    if (next != null) {
      data + "->" + next.printForward()
    } else {
      data.toString
    }
  }

  override def clone(): LinkedListNode = {
    val next2 = if (next != null) next.clone() else null
    new LinkedListNode(data, next2, null)
  }
}
