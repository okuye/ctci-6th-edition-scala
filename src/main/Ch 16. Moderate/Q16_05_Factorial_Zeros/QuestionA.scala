package Q16_05_Factorial_Zeros

object QuestionA {

  def factorsOf5(i: Int): Int = {
    var count = 0
    var num = i
    while (num % 5 == 0) {
      count += 1
      num /= 5
    }
    count
  }

  def countFactZeros(num: Int): Int = {
    var count = 0
    for (i <- 2 to num) {
      count += factorsOf5(i)
    }
    count
  }

  def factorial(num: Int): Int = {
    if (num == 1) {
      1
    } else if (num > 1) {
      num * factorial(num - 1)
    } else {
      -1 // Error
    }
  }

  def main(args: Array[String]): Unit = {
    for (i <- 1 until 12) {
      println(s"$i! (or ${factorial(i)}) has ${countFactZeros(i)} zeros")
    }
  }
}
