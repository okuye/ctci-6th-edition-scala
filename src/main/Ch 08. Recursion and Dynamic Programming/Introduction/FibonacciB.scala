package Introduction

object FibonacciB extends App {
  def fibonacci(n: Int): Int = {
    fibonacci(n, Array.fill(n + 1)(0))
  }

  def fibonacci(i: Int, memo: Array[Int]): Int = {
    if (i == 0) return 0
    else if (i == 1) return 1

    if (memo(i) == 0) {
      memo(i) = fibonacci(i - 1, memo) + fibonacci(i - 2, memo)
    }
    memo(i)
  }

  val max = 100 // Make this as big as you want! (Though you'll exceed the bounds of a long around 46)
  val trials = 10 // Run code multiple times to compute average time.
  val times = Array.fill(max)(0.0) // Store times

  for (_ <- 0 until trials) { // Run this 10 times to compute
    for (i <- 0 until max) {
      val start = System.currentTimeMillis()
      println(fibonacci(i))
      val end = System.currentTimeMillis()
      val time = end - start
      times(i) += time
    }
  }

  for (j <- 0 until max) {
    // println(s"$j: ${times(j) / trials}ms")
  }
}
