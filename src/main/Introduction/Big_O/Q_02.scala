package Big_O

object Q_02 {
  def power(a: Int, b: Int): Int = {
    if (b < 0) {
      0 // error
    } else if (b == 0) {
      1
    } else {
      a * power(a, b - 1)
    }
  }

  def main(args: Array[String]): Unit = {
    println(power(3, 4))
  }
}
