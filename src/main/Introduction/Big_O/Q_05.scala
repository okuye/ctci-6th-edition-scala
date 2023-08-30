package Big_O

object Q_05 {
  def sqrt(n: Int): Int = {
    sqrt_helper(n, 1, n)
  }

  def sqrt_helper(n: Int, min: Int, max: Int): Int = {
    if (max < min) return -1 // no square root

    val guess = (min + max) / 2
    if (guess * guess == n) { // found it!
      guess
    } else if (guess * guess < n) { // too low
      sqrt_helper(n, guess + 1, max) // try higher
    } else { // too high
      sqrt_helper(n, min, guess - 1) // try lower
    }
  }

  def main(args: Array[String]): Unit = {
    println(sqrt(26))
  }
}
