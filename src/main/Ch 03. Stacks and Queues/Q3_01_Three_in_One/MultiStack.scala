package Q3_01_Three_in_One

class MultiStack(numberOfStacks: Int, defaultSize: Int) {
  private class StackInfo(var start: Int, val capacity: Int) {
    var size: Int = 0

    def withIncreasedCapacity: StackInfo = new StackInfo(start, capacity + 1)

    def isWithinStackCapacity(index: Int): Boolean = {
      if (index < 0 || index >= values.length) {
        false
      } else {
        val contiguousIndex =
          if (index < start) index + values.length else index
        val end = start + capacity
        start <= contiguousIndex && contiguousIndex < end
      }
    }

    def lastCapacityIndex(): Int = adjustIndex(start + capacity - 1)
    def lastElementIndex(): Int = adjustIndex(start + size - 1)
    def isFull(): Boolean = size == capacity
    def isEmpty(): Boolean = size == 0
  }

  private val info: Array[StackInfo] = Array.fill(numberOfStacks)(
    new StackInfo(defaultSize * numberOfStacks, defaultSize)
  )
  private val values: Array[Int] = Array.fill(numberOfStacks * defaultSize)(0)

  private def adjustIndex(index: Int): Int =
    ((index % values.length) + values.length) % values.length
  private def nextIndex(index: Int): Int = adjustIndex(index + 1)
  private def previousIndex(index: Int): Int = adjustIndex(index - 1)

  private def shiftAndExpand(stackNum: Int): Unit = {
    val nextStack = (stackNum + 1) % info.length
    shift(nextStack)
    val updatedCapacity = info(stackNum).capacity + 1
    info(stackNum) = new StackInfo(info(stackNum).start, updatedCapacity)
  }
  private def shift(stackNum: Int): Unit = {

    println("/// Shifting " + stackNum)
    val stack = info(stackNum)

    if (stack.size >= stack.capacity) {
      shiftAndExpand(stackNum)
    }

    var index = stack.lastCapacityIndex()
    while (stack.isWithinStackCapacity(index)) {
      values(index) = values(previousIndex(index))
      index = previousIndex(index)
    }

    values(stack.start) = 0
    stack.start = nextIndex(stack.start)
    info(stackNum) = new StackInfo(stack.start, stack.capacity - 1)
  }

  private def expand(stackNum: Int): Unit = {
    val newCapacity = info(stackNum).capacity + 1
    shift((stackNum + 1) % info.length)
    info(stackNum) = new StackInfo(info(stackNum).start, newCapacity)
  }

  def push(stackNum: Int, value: Int): Unit = {
    if (allStacksAreFull) {
      throw new FullStackException()
    }

    val stack = info(stackNum)
    if (stack.isFull) {
      expand(stackNum)
    }

    stack.size += 1
    values(stack.lastElementIndex) = value
  }

  def pop(stackNum: Int): Int = {
    val stack = info(stackNum)
    if (stack.isEmpty) {
      throw new EmptyStackException()
    }

    val value = values(stack.lastElementIndex)
    values(stack.lastElementIndex) = 0
    stack.size -= 1
    value
  }

  def peek(stackNum: Int): Int = values(info(stackNum).lastElementIndex)

  def getValues: Array[Int] = values

  def getStackValues(stackNum: Int): Array[Int] = {
    val stack = info(stackNum)
    (for (i <- 0 until stack.size)
      yield values(adjustIndex(stack.start + i))).toArray
  }

  def stackToString(stackNum: Int): String = {
    val items = getStackValues(stackNum)
    s"$stackNum: ${items.mkString(", ")}"
  }

  def numberOfElements: Int = info.map(_.size).sum
  def allStacksAreFull: Boolean = numberOfElements == values.length
}
