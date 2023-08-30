package Big_O

object Ex_01 {
  def sum(n: Int): Int = {
    if (n <= 0) {
      0
    } else {
      n + sum(n - 1)
    }
  }

  def main(args: Array[String]): Unit = {
    val s: Int = sum(4)
    println(s)
  }
}
