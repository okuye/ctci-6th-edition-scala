package Q17_16_The_Masseuse

object QuestionB {

  def maxMinutes(massages: Array[Int]): Int = {
    val memo = Array.fill(massages.length)(0)
    maxMinutes(massages, 0, memo)
  }

  def maxMinutes(massages: Array[Int], index: Int, memo: Array[Int]): Int = {
    if (index >= massages.length) {
      return 0
    }
    if (memo(index) == 0) {
      val bestWith = massages(index) + maxMinutes(massages, index + 2, memo)
      val bestWithout = maxMinutes(massages, index + 1, memo)
      memo(index) = Math.max(bestWith, bestWithout)
    }

    memo(index)
  }

  def main(args: Array[String]): Unit = {
    val massages = Array(2*15, 1*15, 4*15, 5*15, 3*15, 1*15, 1*15, 3*15)
    println(maxMinutes(massages))
  }
}
