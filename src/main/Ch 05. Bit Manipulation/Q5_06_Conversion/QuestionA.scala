package Q5_06_Conversion

import CtCILibrary.AssortedMethods

object QuestionA {

  def bitSwapRequired(a: Int, b: Int): Int = {
    var count = 0
    var c = a ^ b
    while (c != 0) {
      count += c & 1 // Increment count if c ends with a 1
      c >>>= 1 // Shift right by 1
    }
    count
  }

  def main(args: Array[String]): Unit = {
    val a = -23432
    val b = 512132
    println(s"$a: ${AssortedMethods.toFullBinaryString(a)}")
    println(s"$b: ${AssortedMethods.toFullBinaryString(b)}")
    println(s"Required number of bits: ${bitSwapRequired(a, b)}")
  }
}
