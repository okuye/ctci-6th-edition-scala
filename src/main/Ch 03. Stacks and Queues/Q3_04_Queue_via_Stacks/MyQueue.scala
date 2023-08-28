package Q3_04_Queue_via_Stacks

import scala.collection.mutable.Stack

class MyQueue[T] {
  private val stackNewest = Stack[T]()
  private val stackOldest = Stack[T]()

  def size(): Int = stackNewest.size + stackOldest.size

  def add(value: T): Unit = {
    // Push onto stackNewest
    stackNewest.push(value)
  }

  /* Move elements from stackNewest into stackOldest. This is usually done so that we can
   * do operations on stackOldest.
   */
  private def shiftStacks(): Unit = {
    if (stackOldest.isEmpty) {
      while (stackNewest.nonEmpty) {
        stackOldest.push(stackNewest.pop())
      }
    }
  }

  def peek(): T = {
    shiftStacks()
    stackOldest.top // retrieve the oldest item.
  }

  def remove(): T = {
    shiftStacks()
    stackOldest.pop() // pop the oldest item.
  }
}
