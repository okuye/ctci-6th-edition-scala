package Q6_07_The_Apocalypse

import scala.util.Random

object Question {

  def runOneFamily(): (Int, Int) = {
    val random = new Random()
    var boys = 0
    var girls = 0
    while (girls == 0) { // until we have a girl
      if (random.nextBoolean()) { // girl
        girls += 1
      } else { // boy
        boys += 1
      }
    }
    (girls, boys)
  }

  def runNFamilies(n: Int): Double = {
    var boys = 0
    var girls = 0
    for (_ <- 1 to n) {
      val (g, b) = runOneFamily()
      girls += g
      boys += b
    }
    girls.toDouble / (boys + girls)
  }

  def main(args: Array[String]): Unit = {
    val ratio = runNFamilies(10000000)
    println(ratio)
  }
}
