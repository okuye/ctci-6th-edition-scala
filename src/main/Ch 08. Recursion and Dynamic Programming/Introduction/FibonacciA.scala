package Introduction

object FibonacciA extends App {
  def fibonacci(i: Int): Int = {
    if (i == 0) {
      0
    } else if (i == 1) {
      1
    } else {
      fibonacci(i - 1) + fibonacci(i - 2)
    }
  }

  val max = 35 // WARNING: If you make this above 40ish, your computer may seriously slow down.
  val trials = 10 // Run code multiple times to compute average time.
  val times = Array.fill(max)(0.0) // Store times

  for (_ <- 0 until trials) { // Run this 10 times to compute
    for (i <- 0 until max) {
      val start = System.currentTimeMillis()
      fibonacci(i)
      val end = System.currentTimeMillis()
      val time = end - start
      times(i) += time
    }
  }

  for (j <- 0 until max) {
    println(s"$j: ${times(j) / trials}ms")
  }
}
