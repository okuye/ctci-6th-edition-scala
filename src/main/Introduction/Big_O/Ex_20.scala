package Big_O

object Ex_20 {
  def powersOf2(n: Int): Int = {
    if (n == 1) {
      println(1)
      1
    } else {
      val prev = powersOf2(n / 2)
      val curr = prev * 2
      println(curr)
      curr
    }
  }

  def main(args: Array[String]): Unit = {
    powersOf2(100)
  }
}

