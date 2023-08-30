package Big_O

object Q_01 {
  def product(a: Int, b: Int): Int = {
    var sum = 0
    for (i <- 0 until b) {
      sum += a
    }
    sum
  }

  def main(args: Array[String]): Unit = {
    println(product(5, 6))
  }
}
