package Q17_16_The_Masseuse

object QuestionC {

  def maxMinutes(massages: Array[Int]): Int = {
    val memo = Array.fill(massages.length + 2)(0)
    memo(massages.length) = 0
    memo(massages.length + 1) = 0

    for (i <- massages.length - 1 to 0 by -1) {
      val bestWith = massages(i) + memo(i + 2)
      val bestWithout = memo(i + 1)
      memo(i) = Math.max(bestWith, bestWithout)
    }

    memo(0)
  }

  def main(args: Array[String]): Unit = {
    val massages = Array(2*15, 1*15, 4*15, 5*15, 3*15, 1*15, 1*15, 3*15)
    println(maxMinutes(massages))
  }
}
