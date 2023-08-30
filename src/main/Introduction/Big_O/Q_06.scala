package Big_O

object Q_06 {
  def sqrt(n: Int): Int = {
    for (guess <- 1 to n) {
      if (guess * guess == n) {
        return guess
      }
    }
    -1
  }

  def main(args: Array[String]): Unit = {
    println(sqrt(26))
  }
}
