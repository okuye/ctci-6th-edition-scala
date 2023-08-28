package Q5_06_Conversion

import CtCILibrary.AssortedMethods

object Tester {

  def bitSwapRequired(a: Int, b: Int): Int = {
    var count = 0
    var c = a ^ b
    while (c != 0) {
      count += c & 1
      c = c >>> 1
    }
    count
  }

  def bitSwapRequired2(a: Int, b: Int): Int = {
    var count = 0
    var c = a ^ b
    while (c != 0) {
      count += 1
      c = c & (c-1)
    }
    count
  }

  def main(args: Array[String]): Unit = {
    val a = -23432
    val b = 512132
    println(s"$a: ${AssortedMethods.toFullBinaryString(a)}")
    println(s"$b: ${AssortedMethods.toFullBinaryString(b)}")
    val nbits = QuestionA.bitSwapRequired(a, b)
    val nbits2 = QuestionB.bitSwapRequired(a, b)
    println(s"Required number of bits: $nbits $nbits2")
  }
}
