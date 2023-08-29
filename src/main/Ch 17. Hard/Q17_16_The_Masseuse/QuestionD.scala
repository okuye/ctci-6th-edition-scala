package Q17_16_The_Masseuse

object QuestionD {

  def maxMinutes(massages: Array[Int]): Int = {
    var oneAway = 0
    var twoAway = 0

    for (i <- massages.length - 1 to 0 by -1) {
      val bestWith = massages(i) + twoAway
      val bestWithout = oneAway
      val current = Math.max(bestWith, bestWithout)
      twoAway = oneAway
      oneAway = current
    }

    oneAway
  }

  def main(args: Array[String]): Unit = {
    val massages = Array(2*15, 1*15, 4*15, 5*15, 3*15, 1*15, 1*15, 3*15)
    println(maxMinutes(massages))
  }
}
