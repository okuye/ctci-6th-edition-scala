package Big_O

object Ex_15 {
  def factorial(n: Int): Int = {
    if (n < 0) {
      -1
    } else if (n == 0) {
      1
    } else {
      n * factorial(n - 1)
    }
  }

  def main(args: Array[String]): Unit = {
    val result = factorial(4)
    println(result)
  }
}
