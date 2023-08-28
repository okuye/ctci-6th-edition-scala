package Q5_07_Pairwise_Swap

import CtCILibrary.AssortedMethods

object Question {

  def swapOddEvenBits(x: Int): Int = {
    ((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1)
  }

  def main(args: Array[String]): Unit = {
    val a = 234321
    println(s"$a: ${AssortedMethods.toFullBinaryString(a)}")
    val b = swapOddEvenBits(a)
    println(s"$b: ${AssortedMethods.toFullBinaryString(b)}")
  }
}
