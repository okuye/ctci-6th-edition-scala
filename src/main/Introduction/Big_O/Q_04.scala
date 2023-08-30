package Big_O

object Q_04 {
  def div(a: Int, b: Int): Int = {
    var count = 0
    var sum = b
    while (sum <= a) {
      sum += b
      count += 1
    }
    count
  }

  def main(args: Array[String]): Unit = {
    println(div(12, 4))
  }
}
