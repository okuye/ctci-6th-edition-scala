package Q3_01_Three_in_One

import scala.collection.mutable.ArrayBuffer

class FixedMultiStack(stackSize: Int) {
  private val numberOfStacks = 3
  private val stackCapacity = stackSize
  private val values = new Array[Int](stackSize * numberOfStacks)
  private val sizes = Array.fill(numberOfStacks)(0)

  def push(stackNum: Int, value: Int): Unit = {
    if (isFull(stackNum)) {
      throw new FullStackException()
    }

    sizes(stackNum) += 1
    values(indexOfTop(stackNum)) = value
  }

  def pop(stackNum: Int): Int = {
    if (isEmpty(stackNum)) {
      throw new EmptyStackException()
    }

    val topIndex = indexOfTop(stackNum)
    val value = values(topIndex)
    values(topIndex) = 0
    sizes(stackNum) -= 1
    value
  }

  def peek(stackNum: Int): Int = {
    if (isEmpty(stackNum)) {
      throw new EmptyStackException()
    }
    values(indexOfTop(stackNum))
  }

  def isEmpty(stackNum: Int): Boolean = sizes(stackNum) == 0

  def isFull(stackNum: Int): Boolean = sizes(stackNum) == stackCapacity

  private def indexOfTop(stackNum: Int): Int = {
    val offset = stackNum * stackCapacity
    val size = sizes(stackNum)
    offset + size - 1
  }

  def getValues: Array[Int] = values

  def getStackValues(stackNum: Int): Array[Int] = {
    val items = new ArrayBuffer[Int](sizes(stackNum))
    for (i <- 0 until sizes(stackNum)) {
      items += values(stackNum * stackCapacity + i)
    }
    items.toArray
  }

  def stackToString(stackNum: Int): String = {
    val items = getStackValues(stackNum)
    s"$stackNum: ${items.mkString("[", ", ", "]")}"
  }
}

class FullStackException extends Exception
class EmptyStackException extends Exception
