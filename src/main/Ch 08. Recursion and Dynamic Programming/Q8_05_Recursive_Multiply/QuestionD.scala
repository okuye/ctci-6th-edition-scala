package Q8_05_Recursive_Multiply

object QuestionD {

  var counter = 0

  /* This is an algorithm called the peasant algorithm.
   * https://en.wikipedia.org/wiki/Multiplication_algorithm#Peasant_or_binary_multiplication
   */
  def minProduct(a: Int, b: Int): Int = {
    if (a < b) return minProduct(b, a)
    var value = 0
    var tempA = a
    var tempB = b
    while (tempA > 0) {
      counter += 1
      if ((tempA % 10) % 2 == 1) {
        value += tempB
      }
      tempA >>= 1
      tempB <<= 1
    }
    value
  }

  def main(args: Array[String]): Unit = {
    for (i <- 0 until 100; j <- 0 until 100) {
      val prod1 = minProduct(i, j)
      val prod2 = i * j
      if (prod1 != prod2) {
        println(s"ERROR: $i * $j = $prod2, not $prod1")
      }
    }
  }
}
