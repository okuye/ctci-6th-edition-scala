package Big_O

object Q_10 {
  def sumDigits(n: Int): Int = {
    var sum = 0
    var num = n
    while (num > 0) {
      sum += num % 10
      num /= 10
    }
    sum
  }

  def main(args: Array[String]): Unit = {
    println(sumDigits(1252))
  }
}
