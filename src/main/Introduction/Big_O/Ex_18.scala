package Big_O

object Ex_18 {
  def allFib(n: Int): Unit = {
    for (i <- 0 until n) {
      println(s"$i: ${fib(i)}")
    }
  }

  def fib(n: Int): Int = {
    if (n <= 0) 0
    else if (n == 1) 1
    else fib(n - 1) + fib(n - 2)
  }

  def main(args: Array[String]): Unit = {
    allFib(6)
  }
}

