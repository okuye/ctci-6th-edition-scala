package Introduction

import scala.collection.mutable

class MyQueue[T] {
  private class QueueNode[T](val data: T) {
    var next: QueueNode[T] = _
  }

  private var first: QueueNode[T] = _
  private var last: QueueNode[T] = _

  def add(item: T): Unit = {
    val t = new QueueNode[T](item)
    if (last != null) {
      last.next = t
    }
    last = t
    if (first == null) {
      first = last
    }
  }

  def remove(): T = {
    if (first == null) throw new NoSuchElementException()
    val data = first.data
    first = first.next
    if (first == null) {
      last = null
    }
    data
  }

  def peek(): T = {
    if (first == null) throw new NoSuchElementException()
    first.data
  }

  def isEmpty: Boolean = first == null
}
