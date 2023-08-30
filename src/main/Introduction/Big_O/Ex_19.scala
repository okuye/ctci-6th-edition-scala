package Big_O

object Ex_19 {
  def allFib(n: Int): Unit = {
    val memo = new Array[Int](n + 1)
    for (i <- 0 until n) {
      println(s"$i: ${fib(i, memo)}")
    }
  }

  def fib(n: Int, memo: Array[Int]): Int = {
    if (n <= 0) 0
    else if (n == 1) 1
    else if (memo(n) > 0) memo(n)
    else {
      memo(n) = fib(n - 1, memo) + fib(n - 2, memo)
      memo(n)
    }
  }

  def main(args: Array[String]): Unit = {
    allFib(6)
  }
}

