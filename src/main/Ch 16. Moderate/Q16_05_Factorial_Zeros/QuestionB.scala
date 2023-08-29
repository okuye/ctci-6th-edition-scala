package Q16_05_Factorial_Zeros

object QuestionB {

  def countFactZeros(num: Int): Int = {
    if (num < 0) {
      println("Factorial is not defined for negative numbers")
      return 0
    }
    var count = 0
    var i = 5
    while (num / i > 0) {
      count += num / i
      i *= 5
    }
    count
  }

  def factorial(num: Int): Int = {
    if (num == 1) {
      1
    } else if (num > 1) {
      num * factorial(num - 1)
    } else {
      -1  // Error
    }
  }

  def main(args: Array[String]): Unit = {
    for (i <- 1 until 12) {
      println(s"$i! (or ${factorial(i)}) has ${countFactZeros(i)} zeros")
    }
  }
}
