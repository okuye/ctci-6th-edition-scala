package Big_O

object Ex_02 {
  def pairSum(a: Int, b: Int): Int = a + b

  def pairSumSequence(n: Int): Int = {
    var sum = 0
    for (i <- 0 until n) {
      sum += pairSum(i, i + 1)
    }
    sum
  }

  def main(args: Array[String]): Unit = {
    val s: Int = pairSumSequence(4)
    println(s)
  }
}
