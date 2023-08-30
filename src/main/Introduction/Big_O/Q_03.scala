package Big_O

object Q_03 {
  def mod(a: Int, b: Int): Int = {
    if (b <= 0) {
      -1
    } else {
      val div = a / b
      a - div * b
    }
  }

  def main(args: Array[String]): Unit = {
    println(mod(3, 6))
  }
}
