package Introduction

import java.util.EmptyStackException
import scala.collection.mutable

class MyStack[T] {
  private class StackNode[T](val data: T) {
    var next: StackNode[T] = _
  }

  private var top: StackNode[T] = _

  def pop(): T = {
    if (top == null) throw new EmptyStackException()
    val item = top.data
    top = top.next
    item
  }

  def push(item: T): Unit = {
    val t = new StackNode[T](item)
    t.next = top
    top = t
  }

  def peek(): T = {
    if (top == null) throw new EmptyStackException()
    top.data
  }

  def isEmpty: Boolean = top == null
}
