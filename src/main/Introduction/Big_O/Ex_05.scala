package Big_O
object Ex_05 {
  def f(n: Int): Int = {
    if (n <= 0) {
      1
    } else {
      f(n - 1) + f(n - 1)
    }
  }

  def main(args: Array[String]): Unit = {
    f(1)
  }
}

