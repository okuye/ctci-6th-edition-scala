package Q3_03_Stack_of_Plates

import scala.collection.mutable.ArrayBuffer

class SetOfStacks(capacity: Int) {
  private val stacks = ArrayBuffer[Stack]()

  private def getLastStack: Option[Stack] = {
    if (stacks.isEmpty) None
    else Some(stacks.last)
  }

  def push(v: Int): Unit = {
    getLastStack match {
      case Some(last) if !last.isFull =>
        last.push(v)
      case _ =>
        val stack = new Stack(capacity)
        stack.push(v)
        stacks += stack
    }
  }

  def pop(): Int = {
    getLastStack match {
      case Some(last) =>
        val v = last.pop()
        if (last.isEmpty) {
          stacks.remove(stacks.length - 1)
        }
        v
      case None => throw new NoSuchElementException
    }
  }

  def popAt(index: Int): Int = {
    leftShift(index, removeTop = true)
  }

  private def leftShift(index: Int, removeTop: Boolean): Int = {
    val stack = stacks(index)
    val removedItem = if (removeTop) stack.pop() else stack.removeBottom()
    if (stack.isEmpty) {
      stacks.remove(index)
    } else if (stacks.size > index + 1) {
      val v = leftShift(index + 1, removeTop = false)
      stack.push(v)
    }
    removedItem
  }

  def isEmpty: Boolean = {
    getLastStack match {
      case Some(last) => last.isEmpty
      case None => true
    }
  }
}
