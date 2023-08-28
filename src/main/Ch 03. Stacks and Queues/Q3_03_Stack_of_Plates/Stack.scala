package Q3_03_Stack_of_Plates

import scala.Option

class Node(val value: Int) {
  var above: Option[Node] = None
  var below: Option[Node] = None
}

class Stack(capacity: Int) {
  private var _size: Int = 0
  private var top: Option[Node] = None
  private var bottom: Option[Node] = None

  def isFull: Boolean = capacity == _size

  private def join(above: Option[Node], below: Option[Node]): Unit = {
    below.foreach(_.above = above)
    above.foreach(_.below = below)
  }

  def push(v: Int): Boolean = {
    if (_size >= capacity) return false
    _size += 1
    val n = new Node(v)
    if (_size == 1) bottom = Some(n)
    join(Some(n), top)
    top = Some(n)
    true
  }

  def pop(): Int = {
    top match {
      case Some(t) =>
        top = t.below
        _size -= 1
        t.value
      case None => throw new NoSuchElementException
    }
  }

  def isEmpty: Boolean = _size == 0

  def removeBottom(): Int = {
    bottom match {
      case Some(b) =>
        bottom = b.above
        if (bottom.isDefined) bottom.get.below = None
        _size -= 1
        b.value
      case None => throw new NoSuchElementException
    }
  }
}
