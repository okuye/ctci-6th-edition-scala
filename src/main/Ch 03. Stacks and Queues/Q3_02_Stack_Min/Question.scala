package Q3_02_Stack_Min

object Question {
  def main(args: Array[String]): Unit = {
    val stack = new StackWithMin()
    val stack2 = new StackWithMin2()
    val array = Array(2, 1, 3, 1)
    for (value <- array) {
      stack.push(value)
      stack2.push(value)
      print(value + ", ")
    }
    println()

    for (_ <- array.indices) {
      println(s"Popped ${stack.pop().value}, ${stack2.pop()}")
      println(s"New min is ${stack.min()}, ${stack2.min()}")
    }
  }
}
