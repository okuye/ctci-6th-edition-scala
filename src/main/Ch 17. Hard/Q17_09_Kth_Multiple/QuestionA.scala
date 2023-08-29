package Q17_09_Kth_Multiple

import scala.collection.mutable.ArrayBuffer

object QuestionA {

  def allPossibleKFactors(k: Int): ArrayBuffer[Int] = {
    val values = ArrayBuffer[Int]()
    for {
      a <- 0 to k
      b <- 0 to k
      c <- 0 to k
    } {
      val powA = Math.pow(3, a).toInt
      val powB = Math.pow(5, b).toInt
      val powC = Math.pow(7, c).toInt
      var value = powA * powB * powC
      if (
        value < 0 || powA == Int.MaxValue || powB == Int.MaxValue || powC == Int.MaxValue
      ) {
        value = Int.MaxValue
      }
      values.append(value)
    }
    values
  }

  def getKthMagicNumber(k: Int): Int = {
    val possibilities = allPossibleKFactors(k).sorted
    possibilities(k)
  }

  def main(args: Array[String]): Unit = {
    for (i <- 0 until 50) {
      println(s"$i : ${getKthMagicNumber(i)}")
    }
  }
}
