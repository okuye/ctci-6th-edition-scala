package Big_O

object Ex_17 {
  def fib(n: Int): Int = {
    if (n <= 0) 0
    else if (n == 1) 1
    else fib(n - 1) + fib(n - 2)
  }

  def main(args: Array[String]): Unit = {
    for (i <- 0 until 6) {
      println(s"$i: ${fib(i)}")
    }
  }
}
