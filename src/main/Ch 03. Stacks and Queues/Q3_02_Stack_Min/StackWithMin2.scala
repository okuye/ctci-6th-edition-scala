package Q3_02_Stack_Min

import scala.collection.mutable.Stack

class StackWithMin2 extends Stack[Int] {
  private val s2 = new Stack[Int]

  override def push(value: Int): this.type = {
    if (value <= min()) {
      s2.push(value)
    }
    super.push(value)
  }

  override def pop(): Int = {
    val value = super.pop()
    if (value == min()) {
      s2.pop()
    }
    value
  }

  def min(): Int = {
    if (s2.isEmpty) {
      Int.MaxValue
    } else {
      s2.top
    }
  }
}
