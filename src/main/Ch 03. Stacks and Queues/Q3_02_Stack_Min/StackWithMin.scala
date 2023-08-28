package Q3_02_Stack_Min

import scala.collection.mutable.Stack

class StackWithMin extends Stack[NodeWithMin] {
  def push(value: Int): Unit = {
    val newMin = Math.min(value, min())
    super.push(new NodeWithMin(value, newMin))
  }

  def min(): Int = {
    if (this.isEmpty) {
      Int.MaxValue
    } else {
      this.top.min
    }
  }
}
