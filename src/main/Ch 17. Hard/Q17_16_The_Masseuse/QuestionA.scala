package Q17_16_The_Masseuse

object QuestionA {

  def maxMinutes(massages: Array[Int]): Int = {
    maxMinutes(massages, 0)
  }

  def maxMinutes(massages: Array[Int], index: Int): Int = {
    if (index >= massages.length) { // Out of bounds
      return 0
    }

    // Best with this reservation.
    val bestWith = massages(index) + maxMinutes(massages, index + 2)

    // Best without this reservation.
    val bestWithout = maxMinutes(massages, index + 1)

    // Return best of this subarray, starting from index.
    Math.max(bestWith, bestWithout)
  }

  def main(args: Array[String]): Unit = {
    val massages = Array(30, 15, 60, 75, 45, 15, 15, 45)
    println(maxMinutes(massages))
  }
}
