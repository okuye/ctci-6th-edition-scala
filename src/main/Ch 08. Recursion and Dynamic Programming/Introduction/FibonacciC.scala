package Introduction

object FibonacciC extends App {
  def fibonacci(n: Int): Int = {
    if (n == 0) return 0
    else if (n == 1) return 1

    val memo = Array.fill(n)(0)
    memo(0) = 0
    memo(1) = 1
    for (i <- 2 until n) {
      memo(i) = memo(i - 1) + memo(i - 2)
    }
    memo(n - 1) + memo(n - 2)
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
