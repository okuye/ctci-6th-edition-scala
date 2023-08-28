package Introduction

object FibonacciD extends App {
  def fibonacci(n: Int): Int = {
    if (n == 0) return 0
    var a = 0
    var b = 1
    for (_ <- 2 until n) {
      val c = a + b
      a = b
      b = c
    }
    a + b
  }

  val max =
    100 // Make this as big as you want! (Though you'll exceed the bounds of a long around 46)
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
